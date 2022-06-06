package com.fdu.sciback.service;

import com.alibaba.fastjson.JSONArray;
import com.fdu.sciback.entity.DblpEntity;

import java.util.List;

public interface IDblpService {
    List<DblpEntity> queryAll();

    DblpEntity getPaperById(String id);

    JSONArray getAuthors();

    List<DblpEntity> getDblpBykeyword(final String keyword);
}
