package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.All1760DataEntity;
import com.fdu.sciback.mapper.All1760DataMapper;
import com.fdu.sciback.service.IAll1760DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class All1760DataServiceImpl implements IAll1760DataService {

    @Autowired
    private All1760DataMapper all1760DataMapper;

    @Override
    public List<All1760DataEntity> queryAll(){return all1760DataMapper.queryAll();}

    public All1760DataEntity getAll1760DataById(final int id) {
        return all1760DataMapper.getAll1760DataById(id);
    }
}
