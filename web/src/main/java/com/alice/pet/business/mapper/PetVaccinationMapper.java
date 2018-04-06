package com.alice.pet.business.mapper;


import com.alice.pet.business.domain.PetVaccination;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetVaccinationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PetVaccination record);

    int insertSelective(PetVaccination record);

    PetVaccination selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PetVaccination record);

    int updateByPrimaryKey(PetVaccination record);
}