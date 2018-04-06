package com.alice.pet.business.web;

import com.alice.pet.base.common.page.PageList;
import com.alice.pet.base.model.MessageBean;
import com.alice.pet.base.web.BaseController;
import com.alice.pet.business.domain.PetInfo;
import com.alice.pet.business.service.PetInfoService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/petInfo")
@Slf4j
public class PetInfoController extends BaseController {

    @Resource
    private PetInfoService service;

    @GetMapping
    public String page() {
        return "/business/petInfo/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public MessageBean list(int offset, int limit) {
        log.info("入参:{},出参:{}", offset, limit);
        return this.process(()->{
            Page<PetInfo> petInfos = service.searchPetInfoAll(offset,limit);
            return new PageList(petInfos.getTotal(), petInfos.getResult().stream().collect(Collectors.toList()));
        });
    }

}
