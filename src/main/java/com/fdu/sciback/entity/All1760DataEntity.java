package com.fdu.sciback.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Data
public class All1760DataEntity {

    private int id;

    private Object info;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        All1760DataEntity that = (All1760DataEntity) o;
        return id == that.id && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info);
    }
}
