package com.fdu.sciback.web.controller;

import com.fdu.sciback.entity.All1760DataEntity;
import com.fdu.sciback.entity.Id2NameEntity;
import com.fdu.sciback.service.IId2NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/id2name")
@CrossOrigin
public class Id2NameController {
    @Autowired
    private IId2NameService id2NameService;

    @GetMapping("/list")
    public List<Id2NameEntity> queryAll(){
        List<Id2NameEntity> L=id2NameService.queryAll();
        return L;
    }

    @GetMapping(value = "/{id}")
    public Id2NameEntity getById(@PathVariable("id") Integer id) {
        return id2NameService.getId2NameById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Id2NameEntity getByName(@PathVariable("name") String name) {
        return id2NameService.getId2NameByName(name);
    }
}
