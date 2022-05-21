package com.fdu.sciback.service;

import com.fdu.sciback.entity.scis.FieldsEntity;
import com.fdu.sciback.entity.scis.SciEntity;
import net.sf.json.JSONObject;

import java.util.List;

public interface ISciService {
    List<SciEntity> queryAll();

    List<FieldsEntity> getFieldByLevel(Integer level, Integer nums);

    JSONObject getFields();

    FieldsEntity getFieldById(Integer id);
}
