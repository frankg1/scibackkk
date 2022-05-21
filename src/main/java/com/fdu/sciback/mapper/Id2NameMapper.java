package com.fdu.sciback.mapper;

import com.fdu.sciback.entity.DblpEntity;
import com.fdu.sciback.entity.Id2NameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Id2NameMapper {
    List<Id2NameEntity> queryAll();

    Id2NameEntity getId2NameById(@Param("id") int id);
}
