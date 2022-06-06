package com.fdu.sciback.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.fdu.sciback.entity.DblpEntity;
import com.fdu.sciback.service.IDblpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/dblp")
@CrossOrigin
public class DblpController {

    @Autowired
    private IDblpService dblpService;

    @GetMapping("/list")
    public List<DblpEntity> queryAll(){
        List<DblpEntity> L=dblpService.queryAll();
        return L;
    }

    @GetMapping(value = "/{id}")
    public DblpEntity getById(@PathVariable("id") String id) {
        return dblpService.getPaperById(id);
    }

    @GetMapping("/authors")
    public JSONArray getAuthors() {
        return dblpService.getAuthors();
    }

    @GetMapping("/keyword/{keyword}")
    public List<DblpEntity> getDblpByKeyword(@PathVariable("keyword") String keyword) {
        return dblpService.getDblpBykeyword(keyword);
    }
}
