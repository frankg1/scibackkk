package com.fdu.sciback.web.controller;

import com.fdu.sciback.entity.ExpertsEntity;
import com.fdu.sciback.service.ExpertsService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping("/experts")
@CrossOrigin
public class ExpertsController {

    @Autowired
    ExpertsService expertsService;

    @GetMapping("")
    public List<ExpertsEntity> getsByIds(@RequestParam("ids") List<String > ids) {
        for(int i=0; i<ids.size(); i++)
            System.out.println(ids.get(i));
        return expertsService.getExpertsEntityByIds(ids);
    }
}
