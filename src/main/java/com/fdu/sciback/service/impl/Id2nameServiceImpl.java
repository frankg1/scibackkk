package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.Id2NameEntity;
import com.fdu.sciback.mapper.Id2NameMapper;
import com.fdu.sciback.service.IId2NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Id2nameServiceImpl implements IId2NameService {
    @Autowired
    private Id2NameMapper id2NameMapper;

    @Override
    public List<Id2NameEntity> queryAll(){return id2NameMapper.queryAll();}

    public Id2NameEntity getId2NameById(int id) {
        return id2NameMapper.getId2NameById(id);
    }

}
