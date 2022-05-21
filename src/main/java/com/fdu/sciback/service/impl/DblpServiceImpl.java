package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.DblpEntity;

import com.fdu.sciback.mapper.DblpMapper;

import com.fdu.sciback.service.IDblpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DblpServiceImpl implements IDblpService {
    @Autowired
    private DblpMapper dblpMapper;

    @Override
    public List<DblpEntity> queryAll() {
        return dblpMapper.queryAll();
    }

    public DblpEntity getPaperById(String id) {
        return dblpMapper.getPaperById(id);
    }
}
