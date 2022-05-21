package com.fdu.sciback.entity.scis;



import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SciEntity {
    private int id;
    private String name;
    private String name_zh;
    private int level;
    private String definition;
    private String definition_zh;
    private String parent;
    private List<Integer> childnodes;
    private List<Expert> experts;
    private List<Publication> publications;

    public static class Expert {
        private String id;
        private String name;
        private String name_zh;
        private String position;
        private int h_index;
        private List<String> interests;
    }
    public static class Publication {
        private String id;
        private String title;
        private List<Author> authors;

        public static class Author {
            private String id;
            private String name;
        }
    }

}
