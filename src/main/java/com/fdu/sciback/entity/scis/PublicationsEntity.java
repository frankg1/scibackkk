package com.fdu.sciback.entity.scis;

import lombok.Data;

import java.util.List;

@Data
public class PublicationsEntity {
    private String id;
    private String title;
    private List<SciEntity.Publication.Author> authors;

    public static class Author {
        private String id;
        private String name;
    }
}
