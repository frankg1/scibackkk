package com.fdu.sciback.entity.scis;

import lombok.Data;

import java.util.List;

@Data
public class FieldsEntity {
    private int id;
    private int level;
    private String name_zh;
    private List<Integer> childnodes;
}
