package com.alice.pet.business.service;

import com.alice.pet.business.domain.PetInfo;
import com.github.pagehelper.Page;

import java.util.List;

public interface PetInfoService {
    Boolean updatePetInfo(PetInfo petInfo);

    Boolean addPetInfo(PetInfo petInfo);

    PetInfo searchPetInfoById(Integer id);

    Page<PetInfo> searchPetInfoAll(int offset, int limit);

    Boolean deletePetInfo(Integer id);

    Boolean deleteBatch(Integer[] ids);
}
