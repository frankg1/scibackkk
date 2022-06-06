package com.fdu.sciback.service;

import com.fdu.sciback.entity.scis.SciEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public interface ISciService {
    List<SciEntity> queryAll();

    JSONObject getFields();

    List<SciEntity.Publication> getPublicationsById(Integer id);

    JSONArray getSciDatasByIds(List<Integer> ids);

    JSONObject getSciFields();
}
