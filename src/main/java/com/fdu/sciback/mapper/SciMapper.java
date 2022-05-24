package com.fdu.sciback.mapper;

import com.fdu.sciback.entity.scis.FieldsEntity;
import com.fdu.sciback.entity.scis.PublicationsEntity;
import com.fdu.sciback.entity.scis.SciEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SciMapper {
    List<SciEntity> queryAll();

    /***
     * 根据level抽取数据
     * @param level  抽取的level
     * @param nums   抽取的数量
     * @return
     */
    List<FieldsEntity> getFieldByLevel(@Param("level") Integer level, @Param("nums") Integer nums);

    FieldsEntity getFieldById(@Param("id") Integer id);

    SciEntity getPublicationById(@Param("id") Integer id);

}
