package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.scis.FieldsEntity;
import com.fdu.sciback.entity.scis.SciEntity;
import com.fdu.sciback.mapper.SciMapper;
import com.fdu.sciback.service.ISciService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class SciServiceImpl implements ISciService {
    @Autowired
    private SciMapper sciMapper;

    private int fields_len = 0;

    @Override
    public List<SciEntity> queryAll() {
        return sciMapper.queryAll();
    }

    public List<FieldsEntity> getFieldByLevel(Integer level, Integer nums) {
        return sciMapper.getFieldByLevel(level, nums);
    }

    public FieldsEntity getFieldById(Integer id) {
        return sciMapper.getFieldById(id);
    }
    public JSONObject getFields() {
        // 抽取的 level 层数
        final int levels = 3;

        // 抽取每层 level 的数量
        final int nums = 5;

        this.fields_len = 0;

        JSONObject result = new JSONObject();
        List<FieldsEntity> level1 = this.getFieldByLevel(1, nums);
        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<level1.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("sci_id", level1.get(i).getId());
            obj.put("label", level1.get(i).getName_zh());

            List<Integer> ChildNodes = level1.get(i).getChildnodes();
            if(ChildNodes.size() > nums) {
                ChildNodes = ChildNodes.subList(0, nums-1);
            }
            obj.put("children", this.getFieldChildByDfs(2, ChildNodes));

            lists.add(obj);
        }

        result.put("name", "fields");
        result.put("data", lists);
        result.put("len", this.fields_len);

        for(int i=1; i<=levels; i++) {
            this.indexFields(result.getJSONArray("data"), 1, i);
        }

        return result;
    }

    public List<JSONObject> getFieldChildByDfs(int level, List<Integer> children) {
        final int  max_level = 3;
        final int nums = 5;
        if(level > max_level) { return null; }

        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<children.size(); i++) {
            JSONObject obj = new JSONObject();
            FieldsEntity node = this.getFieldById(children.get(i));
            obj.put("sci_id", node.getId());
            obj.put("label", node.getName_zh());

            List<Integer> ChildNodes = node.getChildnodes();
            if(ChildNodes.size() > nums) {
                ChildNodes = ChildNodes.subList(0, nums-1);
            }
            obj.put("children", this.getFieldChildByDfs(level+1, ChildNodes));
            lists.add(obj);
        }
        return lists;
    }

    public void indexFields(JSONArray lists, int cur, int max) {
        if(lists == null) { return; }
        for(int i=0; i<lists.size(); i++) {
            JSONObject row = lists.getJSONObject(i);
            if(cur == max) {
                row.put("id", ++this.fields_len);
            } else {
                indexFields(row.getJSONArray("children"), cur+1, max);
            }
        }
    }
}
