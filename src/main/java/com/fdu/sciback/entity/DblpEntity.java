package com.fdu.sciback.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class DblpEntity {

    private String id;

    private String title;

    private Object authors;

    private Object venue;

    private Object year;

    private Object keywords;

    private String fos;

    private Object references1;

    private String n_citation;

    private String page_start;

    private String page_end;

    private String doc_type;

    private String lang;

    private String publisher;

    private String volume;

    private String issue;

    private String issn;

    private String isbn;

    private String doi;

    private String pdf;

    private Object url;

    private String abstract1;

    private Object indexed_abstract;

}
