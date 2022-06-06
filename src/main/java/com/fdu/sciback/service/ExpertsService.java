package com.fdu.sciback.service;

import com.fdu.sciback.entity.ExpertsEntity;

import java.util.List;

public interface ExpertsService {

    List<ExpertsEntity> getExpertsEntityByIds(List<String> ids);
}
