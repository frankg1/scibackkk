package com.fdu.sciback.service;

import com.fdu.sciback.entity.Id2NameEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IId2NameService {
    List<Id2NameEntity> queryAll();

    Id2NameEntity getId2NameById(int id);
}
