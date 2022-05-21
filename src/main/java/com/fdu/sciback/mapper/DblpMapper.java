package com.fdu.sciback.mapper;

import com.fdu.sciback.entity.DblpEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DblpMapper {
    List<DblpEntity> queryAll();

    DblpEntity getPaperById(@Param("id") String id);
}
