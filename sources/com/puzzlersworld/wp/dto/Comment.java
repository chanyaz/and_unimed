package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    @JsonProperty("androapp_author_name")
    private String authorName;
    private List<Comment> childs;
    @JsonProperty("androapp_content")
    private String content;
    @JsonProperty("date_gmt")
    private Date date;
    private int level = 0;
    private Long parent;
    @JsonProperty("status")
    private CommentStatus status;
    @JsonProperty("type")
    private CommentType type;

    public String getAuthorName() {
        return this.authorName;
    }

    public List<Comment> getChilds() {
        if (this.childs == null) {
            this.childs = new ArrayList();
        }
        return this.childs;
    }

    public String getContent() {
        return this.content;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getID() {
        return this.ID;
    }

    public int getLevel() {
        return this.level;
    }

    public Long getParent() {
        return this.parent;
    }

    public CommentStatus getStatus() {
        return this.status;
    }

    public CommentType getType() {
        return this.type;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setChilds(List<Comment> list) {
        this.childs = list;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setParent(Long l) {
        this.parent = l;
    }

    public void setStatus(CommentStatus commentStatus) {
        this.status = commentStatus;
    }

    public void setType(CommentType commentType) {
        this.type = commentType;
    }
}
