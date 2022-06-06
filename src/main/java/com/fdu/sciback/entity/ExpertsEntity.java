package com.fdu.sciback.entity;

import lombok.Data;

import java.util.List;

@Data
public class ExpertsEntity {
    private String id;
    private String name;
    private String name_zh;
    private String position;
    private String affiliation;
    private String h_index;
    private List<String> interests;
    private int paper_nums;
    private int paper_yinyong_nums;
}
