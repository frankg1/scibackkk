package com.fdu.sciback.service;

import com.fdu.sciback.entity.scis.FieldsEntity;
import net.sf.json.JSONObject;

import java.util.List;

public interface ISciFieldsService {
    List<FieldsEntity> getFieldByLevel(Integer level, Integer nums);

    FieldsEntity getFieldById(Integer id);

    JSONObject getFields();


}
