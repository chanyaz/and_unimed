package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class CommentObject implements Serializable {
    private Long ID;
    private CommentObjectType commentObjectType;

    public CommentObject(Long l, CommentObjectType commentObjectType) {
        this.ID = l;
        this.commentObjectType = commentObjectType;
    }

    public CommentObjectType getCommentObjectType() {
        return this.commentObjectType;
    }

    public Long getID() {
        return this.ID;
    }

    public void setCommentObjectType(CommentObjectType commentObjectType) {
        this.commentObjectType = commentObjectType;
    }

    public void setID(Long l) {
        this.ID = l;
    }
}
