package com.mx.bbva.util;

import java.sql.Blob;
import java.sql.Date;

public class Document {

    private String filename;
    private Blob content;
    private String contentType;
    private Date created;


    public String getFilename() {
        return filename;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }


    public Blob getContent() {
        return content;
    }


    public void setContent(Blob content) {
        this.content = content;
    }


    public String getContentType() {
        return contentType;
    }


    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public Date getCreated() {
        return created;
    }


    public void setCreated(Date created) {
        this.created = created;
    }


}