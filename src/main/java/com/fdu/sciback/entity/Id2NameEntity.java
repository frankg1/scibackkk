package com.fdu.sciback.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Id2NameEntity {

    private Integer id;

    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id2NameEntity that = (Id2NameEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
