package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.puzzlersworld.a.c;
import com.puzzlersworld.android.util.w;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Post implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    @JsonProperty("pwapp_author")
    private Author author;
    @JsonProperty("comment_status")
    private PostCommentStatus commentStatus;
    @JsonProperty("androapp_comments_count")
    private Long commentsCount;
    @JsonProperty("pwapp_post_content")
    private String content;
    @JsonProperty("date_gmt")
    private Date date;
    @JsonProperty("pwapp_excerpt")
    private String excerpt;
    @JsonProperty("androapp_failover_post_content_type")
    private PostContentType failoverPostContentType;
    @JsonProperty("featuredimage")
    private String featuredImage;
    @JsonProperty("featured_image")
    private FeaturedImage featuredImageObject;
    @JsonProperty("featured_image_showhide")
    private String featured_image_showhide;
    private Boolean fetchUrl;
    @JsonProperty("androapp_header")
    private String header;
    @JsonProperty("pwapp_feed_image_dimension_type")
    private ImageDimensionType imageDimensionType;
    @JsonProperty("link")
    private String link;
    private Menu menuItem;
    private String origTitle;
    @JsonProperty("pwapp_post_content_type")
    private PostContentType postContentType;
    @JsonProperty("pwapp_post_image")
    private String postImage;
    @JsonProperty("androapp_image_list")
    private List<PostImage> postImages;
    @JsonProperty("type")
    private String postType;
    @JsonProperty("pwapp_preview_type")
    private PreviewType previewType;
    @JsonProperty("share_image")
    private String shareImage;
    @JsonProperty("share_text")
    private String shareText;
    @JsonProperty("status")
    private PostStatus status;
    @JsonProperty("pwapp_terms")
    @JsonDeserialize(using = c.class)
    private Terms terms;
    @JsonProperty("pwapp_title")
    private String title;

    public Author getAuthor() {
        return (this.author == null || this.author.getID() == null) ? null : this.author;
    }

    public PostCommentStatus getCommentStatus() {
        return this.commentStatus;
    }

    public Long getCommentsCount() {
        return this.commentsCount;
    }

    public String getContent() {
        return this.content;
    }

    public Date getDate() {
        return this.date;
    }

    public String getExcerpt() {
        return this.excerpt == null ? "" : this.excerpt;
    }

    public PostContentType getFailoverPostContentType() {
        return this.failoverPostContentType;
    }

    public String getFeaturedImage() {
        return this.featuredImage;
    }

    public FeaturedImage getFeaturedImageObject() {
        return this.featuredImageObject;
    }

    public String getFeatured_image_showhide() {
        return this.featured_image_showhide;
    }

    public Boolean getFetchUrl() {
        return this.fetchUrl;
    }

    public String getHeader() {
        return this.header;
    }

    public Long getID() {
        return this.ID;
    }

    public ImageDimensionType getImageDimensionType() {
        return this.imageDimensionType;
    }

    public String getLink() {
        return this.link;
    }

    public Menu getMenuItem() {
        return this.menuItem;
    }

    public String getOrigTitle() {
        return this.origTitle;
    }

    public PostContentType getPostContentType() {
        return this.postContentType;
    }

    public String getPostImage() {
        return this.postImage;
    }

    public List<PostImage> getPostImages() {
        return this.postImages;
    }

    public String getPostType() {
        return this.postType;
    }

    public PreviewType getPreviewType() {
        return this.previewType;
    }

    public String getShareImage() {
        return this.shareImage;
    }

    public String getShareText() {
        return this.shareText;
    }

    public PostStatus getStatus() {
        return this.status;
    }

    public Terms getTerms() {
        return this.terms;
    }

    public String getTitle() {
        return (!w.f(this.title) || w.f(this.origTitle)) ? this.title : this.origTitle;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCommentStatus(PostCommentStatus postCommentStatus) {
        this.commentStatus = postCommentStatus;
    }

    public void setCommentsCount(Long l) {
        this.commentsCount = l;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setExcerpt(String str) {
        this.excerpt = str;
    }

    public void setFailoverPostContentType(PostContentType postContentType) {
        this.failoverPostContentType = postContentType;
    }

    public void setFeaturedImage(String str) {
        this.featuredImage = w.h(str);
    }

    public void setFeaturedImageObject(FeaturedImage featuredImage) {
        this.featuredImageObject = featuredImage;
    }

    public void setFeatured_image_showhide(String str) {
        this.featured_image_showhide = str;
    }

    public void setFetchUrl(Boolean bool) {
        this.fetchUrl = bool;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setImageDimensionType(ImageDimensionType imageDimensionType) {
        this.imageDimensionType = imageDimensionType;
    }

    public void setLink(String str) {
        this.link = w.h(str);
    }

    public void setMenuItem(Menu menu) {
        this.menuItem = menu;
    }

    public void setOrigTitle(String str) {
        this.origTitle = str;
    }

    public void setPostContentType(PostContentType postContentType) {
        this.postContentType = postContentType;
    }

    public void setPostImage(String str) {
        this.postImage = w.h(str);
    }

    public void setPostImages(List<PostImage> list) {
        if (list != null) {
            for (PostImage postImage : list) {
                postImage.setSrc(w.h(postImage.getSrc()));
            }
        }
        this.postImages = list;
    }

    public void setPostType(String str) {
        this.postType = str;
    }

    public void setPreviewType(PreviewType previewType) {
        this.previewType = previewType;
    }

    public void setShareImage(String str) {
        this.shareImage = w.h(str);
    }

    public void setShareText(String str) {
        this.shareText = str;
    }

    public void setStatus(PostStatus postStatus) {
        this.status = postStatus;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
