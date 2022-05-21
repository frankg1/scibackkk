package com.fdu.sciback.mapper;

import com.fdu.sciback.entity.All1760DataEntity;
import com.fdu.sciback.entity.DblpEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface All1760DataMapper {
    List<All1760DataEntity> queryAll();

    All1760DataEntity getAll1760DataById(@Param("id") int id);
}

