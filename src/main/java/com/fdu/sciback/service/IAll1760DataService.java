package com.fdu.sciback.service;

import com.fdu.sciback.entity.All1760DataEntity;

import java.util.List;

public interface IAll1760DataService {
    List<All1760DataEntity> queryAll();

    All1760DataEntity getAll1760DataById(final int id);
}
