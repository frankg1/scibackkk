package com.fdu.sciback.service.impl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fdu.sciback.entity.DblpEntity;

import com.fdu.sciback.mapper.DblpMapper;

import com.fdu.sciback.service.IDblpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public JSONArray getAuthors() {
        List<DblpEntity> papers = dblpMapper.getAuthors();
        JSONArray Authors = new JSONArray();
        for(int i=0; i<papers.size(); i++) {
            DblpEntity p = papers.get(i);
            if (p != null) {
                List<Object> aus = p.getAuthors();
                JSONObject obj = new JSONObject();
                obj.put("title", p.getTitle());
                obj.put("authors", aus);
                Authors.add(obj);
            }
        }
        return Authors;
    }

    public List<DblpEntity> getDblpBykeyword(final String keyword){
        return dblpMapper.getDblpEntityByKeyword(keyword);
    }
}
