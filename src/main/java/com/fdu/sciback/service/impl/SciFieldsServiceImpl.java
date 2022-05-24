package com.fdu.sciback.service.impl;

import com.fdu.sciback.entity.scis.FieldsEntity;
import com.fdu.sciback.mapper.SciMapper;
import com.fdu.sciback.service.ISciFieldsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SciFieldsServiceImpl implements ISciFieldsService {
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

    public List<FieldsEntity> getFieldByLevel(Integer level, Integer nums) {
        return sciMapper.getFieldByLevel(level, nums);
    }

    public FieldsEntity getFieldById(Integer id) {
        return sciMapper.getFieldById(id);
    }

    public JSONObject getFields() {
        this.fieldTotalNums = 0;
        this.fieldCheckedId = -1;
        this.result = new JSONObject();

        List<FieldsEntity> level1 = this.getFieldByLevel(1, this.levelNums);
        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<level1.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("sci_id", level1.get(i).getId());
            obj.put("label", level1.get(i).getName_zh());

            List<Integer> ChildNodes = level1.get(i).getChildnodes();
            if(ChildNodes.size() > this.levelNums) {
                ChildNodes = ChildNodes.subList(0, this.levelNums);
            }
            obj.put("children", this.getFieldChildByDfs(2, ChildNodes));

            lists.add(obj);
        }

        this.result.put("name", "fields");
        this.result.put("data", lists);
        this.result.put("dataNums", this.fieldTotalNums);

        for(int i=1; i<=this.levelDepth; i++) {
            this.indexFields(this.result.getJSONArray("data"), 1, i);
        }

        return this.result;
    }

    public List<JSONObject> getFieldChildByDfs(int level, List<Integer> children) {
        if(level > this.levelDepth) { return null; }

        List<JSONObject> lists = new ArrayList<>();
        for(int i=0; i<children.size(); i++) {
            JSONObject obj = new JSONObject();
            FieldsEntity node = this.getFieldById(children.get(i));
            obj.put("sci_id", node.getId());
            obj.put("label", node.getName_zh());

            List<Integer> ChildNodes = node.getChildnodes();
            if(ChildNodes.size() > this.levelNums) {
                ChildNodes = ChildNodes.subList(0, this.levelNums);
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
                row.put("id", ++this.fieldTotalNums);
            } else {
                indexFields(row.getJSONArray("children"), cur+1, max);
            }
        }
    }

}
