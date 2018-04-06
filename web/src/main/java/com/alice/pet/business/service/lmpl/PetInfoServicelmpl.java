package com.alice.pet.business.service.lmpl;

import com.alice.pet.business.domain.PetInfo;
import com.alice.pet.business.mapper.PetInfoMapper;
import com.alice.pet.business.service.PetInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("PetInfoService")
@Slf4j
public class PetInfoServicelmpl implements PetInfoService {


    @Resource
    private PetInfoMapper petInfoMapper;


    @Override
    public Boolean updatePetInfo(PetInfo petInfo) {
        return 0 != petInfoMapper.updateByPrimaryKey(petInfo);
    }

    @Override
    public Boolean addPetInfo(PetInfo petInfo) {
        return 0 != petInfoMapper.insert(petInfo);
    }

    @Override
    public PetInfo searchPetInfoById(Integer id) {
        return petInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<PetInfo> searchPetInfoAll(int offset, int limit) {
        log.info("入参:{},出参:{}", offset, limit);
        return PageHelper.offsetPage(offset, limit)
                .doSelectPage(() -> petInfoMapper.selectAll());
    }

    @Override
    public Boolean deletePetInfo(Integer id) {
        return 0 != petInfoMapper.deleteByPrimaryKey(id);
    }
}
