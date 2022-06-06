package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.DblpEntity;
import com.fdu.sciback.entity.scis.FieldsEntity;
import com.fdu.sciback.entity.scis.SciEntity;
import com.fdu.sciback.mapper.SciMapper;
import com.fdu.sciback.service.ISciService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SciServiceImpl implements ISciService {
    /***
     * 研究领域的总数
     */
    private int fieldTotalNums;

    /***
     * 选中的研究领域Id（前端的Id）
     */
    private int fieldCheckedId;

    /***
     * 抽取的每一层的数量
     */
    private final int levelNums = 5;

    /***
     * 抽取的深度
     */
    private final int levelDepth = 3;

    /***
     * 返回的JSON
     */
    private JSONObject result;

    @Autowired
    private SciMapper sciMapper;





    @Override
    public List<SciEntity> queryAll() {
        return sciMapper.queryAll();
    }

    public JSONObject getFields() {
        fieldTotalNums = 0;
        fieldCheckedId = -1;
        result = new JSONObject();

        List<FieldsEntity> level1 = sciMapper.getFieldByLevel(1, levelNums);
        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<level1.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("sci_id", level1.get(i).getId());
            obj.put("label", level1.get(i).getName_zh());

            List<Integer> ChildNodes = level1.get(i).getChildnodes();
            if(ChildNodes.size() > levelNums) {
                ChildNodes = ChildNodes.subList(0, levelNums);
            }
            obj.put("children", this.getFieldChildByDfs(2, ChildNodes));

            lists.add(obj);
        }

        result.put("name", "fields");
        result.put("data", lists);
        result.put("dataNums", fieldTotalNums);

        for(int i=1; i<=levelDepth; i++) {
            this.indexFields(result.getJSONArray("data"), 1, i);
        }

        result.put("checkedKey", fieldCheckedId);
        result.put("expendKey", levelNums+1);
        return result;
    }

    public List<JSONObject> getFieldChildByDfs(int level, List<Integer> children) {
        if(level > levelDepth) { return null; }

        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<children.size(); i++) {
            JSONObject obj = new JSONObject();
            FieldsEntity node = sciMapper.getFieldById(children.get(i));
            obj.put("sci_id", node.getId());
            obj.put("label", node.getName_zh());

            List<Integer> ChildNodes = node.getChildnodes();
            if(ChildNodes.size() > levelNums) {
                ChildNodes = ChildNodes.subList(0, levelNums);
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
                row.put("id", ++fieldTotalNums);
                if (max == levelDepth && fieldCheckedId == -1) {
                    fieldCheckedId = fieldTotalNums;
                }
            } else {
                indexFields(row.getJSONArray("children"), cur+1, max);
            }
        }
    }

    public List<SciEntity.Publication> getPublicationsById(Integer id) {
        SciEntity sci = sciMapper.getPublicationById(id);
        if (sci!=null) {
            return sci.getPublications();
        } else {
            return null;
        }
    }

    public JSONArray getSciDatasByIds(List<Integer> ids) {
        JSONArray datas = new JSONArray();
        for(int i=0; i<ids.size(); i++) {
            SciEntity sci = sciMapper.getSciEntityById(ids.get(i));
            if(sci != null) {
                JSONObject obj = new JSONObject();
                List<SciEntity.Expert> exps = sci.getExperts();
                List<SciEntity.Publication> pubs = sci.getPublications();
                obj.put("name", sci.getName_zh());
                obj.put("experts", exps);
                obj.put("expertsNums", exps.size());
                obj.put("publicationsNums", pubs.size());
                datas.add(obj);
            }
        }
        return datas;
    }

    public JSONObject getSciFields() {
        //抽取数据
        final int nums = 30;
        JSONObject result = new JSONObject();
        JSONArray fields = new JSONArray();
        List<SciEntity> scis = sciMapper.getSciEntity(nums);
        for(int i=0; i<scis.size(); i++) {
            SciEntity sci = scis.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", sci.getId());
            obj.put("fieldName", sci.getName_zh());
            fields.add(obj);
        }
        result.put("activeId", fields.getJSONObject(0).get("id"));
        result.put("data", fields);
        return result;
    }
}
