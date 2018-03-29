package com.alice.pet.base.web;

import com.alice.pet.base.common.annotation.Log;
import com.alice.pet.base.common.constants.RedisConstants;
import com.alice.pet.base.common.exception.BizException;
import com.alice.pet.base.depend.client.SsoClient;
import com.alice.pet.base.depend.model.SsoModel;
import com.alice.pet.base.domain.Menu;
import com.alice.pet.base.domain.User;
import com.alice.pet.base.enums.LoginUserTypeEnum;
import com.alice.pet.base.model.MessageBean;
import com.alice.pet.base.model.UserModel;
import com.alice.pet.base.service.MenuService;
import com.alice.pet.base.service.UserService;
import com.alice.pet.base.shiro.AuthcToken;
import com.alice.pet.base.shiro.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xudong.cheng
 * @date 2018/1/16 下午7:44
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

//    @Autowired
//    private SsoClient ssoClient;

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

//    @Log("发送验证码")
//    @ResponseBody
//    @RequestMapping("captcha")
//    public MessageBean sendCaptcha(User user) {
//        return this.process(() -> {
//            SsoModel model = ssoClient.sendCode(user.getAccount());
//            return ssoClient.verifty(model);
//        });
//    }

    @Log("后台登录页面")
    @RequestMapping(value = "adminLogin", method = RequestMethod.GET)
    public String toAdminLogin(Model model) {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        model.addAttribute("show", false);
        return "sys/adminLogin";
    }

    @Log("统一登录页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(Model model) {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        model.addAttribute("show", false);
        return "sys/adminLogin";
    }

    @Log("登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String account, String password, String captcha, LoginUserTypeEnum loginUserType, Model model) {
        try {
            AuthcToken token = new AuthcToken(account, password, captcha, loginUserType);
            userService.login(token);
        } catch (BizException e) {
            model.addAttribute("show", true);
            model.addAttribute("msg", e.getDesc());
            return "sys/adminLogin";
        }
        return "redirect:/index";
    }

    @Log("主页")
    @RequestMapping("index")
    public String index(Model model) {
        User currentUser = ShiroUtil.getCurrentUser();
        model.addAttribute("currentUser", new UserModel(currentUser));
        Session session = ShiroUtil.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Menu> menus = (List<Menu>) session.getAttribute(RedisConstants.CURRENT_USER_MENU_KEY);
        if (menus == null) {
            if (currentUser.getRoleCodes().contains("admin")) {
                menus = menuService.findMenuForAdmin();
            } else {
                menus = menuService.findMenuByUserId(currentUser.getUserId());
            }
            session.setAttribute(RedisConstants.CURRENT_USER_MENU_KEY, menus);
        }
        model.addAttribute("menus", menus);
        return "sys/index";
    }

    @Log("首页")
    @RequestMapping("home")
    public String home() {
        return "home";
    }

    @Log("登出")
    @RequestMapping("logout")
    public String logout() {
        LoginUserTypeEnum loginUserType = (LoginUserTypeEnum) ShiroUtil.getSessionAttr(RedisConstants.CURRENT_USER_TYPE);
        SecurityUtils.getSubject().logout();
        if (LoginUserTypeEnum.manager.equals(loginUserType)) {
            return "redirect:/adminLogin";
        }
        return "redirect:/adminLogin";
    }

}
