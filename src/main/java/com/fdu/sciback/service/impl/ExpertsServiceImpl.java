package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.ExpertsEntity;
import com.fdu.sciback.mapper.ExpertsMapper;
import com.fdu.sciback.service.ExpertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertsServiceImpl implements ExpertsService {

    @Autowired
    ExpertsMapper expertsMapper;

    public List<ExpertsEntity> getExpertsEntityByIds(List<String> ids){
        List<ExpertsEntity> exps = new ArrayList<>();
        for(int i=0; i<ids.size(); i++) {
            String id = ids.get(i);
            exps.add(expertsMapper.getExpertsEntityById(id));
        }
        return exps;
    }
}
