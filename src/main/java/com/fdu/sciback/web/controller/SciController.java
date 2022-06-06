package com.fdu.sciback.web.controller;

import com.fdu.sciback.entity.scis.SciEntity;
import com.fdu.sciback.service.ISciService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/sci")
@CrossOrigin
public class SciController {

    @Autowired
    private ISciService sciService;

//    @GetMapping("/fields")
//    public JSONObject getFields(){
//        return sciService.getFields();
//    }

    @GetMapping("/publications/{id}")
    public List<SciEntity.Publication> getNumsOfPublicationsById(@PathVariable("id") Integer id) {
        return sciService.getPublicationsById(id);
    }

    @GetMapping("/experts")
    public JSONArray getDatasByIds(@RequestParam("ids") List<Integer> ids) {
        return sciService.getSciDatasByIds(ids);
    }

    @GetMapping("/fields")
    public JSONObject getFields() {
        return sciService.getSciFields();
    }
}
