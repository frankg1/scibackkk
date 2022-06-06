package com.fdu.sciback.mapper;

import com.fdu.sciback.entity.ExpertsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExpertsMapper {

    ExpertsEntity getExpertsEntityById(@Param("id") String id);
}
