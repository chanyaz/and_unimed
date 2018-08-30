package com.puzzlersworld.wp.dto;

import com.puzzlersworld.android.util.w;

public class ThemeColors {
    private String actionBarBgColor;
    private String actionBarTitleColor;
    private String authorTextColor;
    private String feedBgColor;
    private String feedContentTextColor;
    private String feedTitleColor;
    private String screenBgColor;
    private String statusBarBgColor;
    private String tagBgColor;
    private String tagTextColor;
    private String timeTextColor;

    public String getActionBarBgColor() {
        return !w.i(this.actionBarBgColor) ? ColorConstants.actionBarBgColor : this.actionBarBgColor;
    }

    public String getActionBarTitleColor() {
        return !w.i(this.actionBarTitleColor) ? ColorConstants.actionBarTitleColor : this.actionBarTitleColor;
    }

    public String getAuthorTextColor() {
        return !w.i(this.authorTextColor) ? ColorConstants.authorTextColor : this.authorTextColor;
    }

    public String getFeedBgColor() {
        return !w.i(this.feedBgColor) ? ColorConstants.feedBgColor : this.feedBgColor;
    }

    public String getFeedContentTextColor() {
        return !w.i(this.feedContentTextColor) ? ColorConstants.feedContentTextColor : this.feedContentTextColor;
    }

    public String getFeedTitleColor() {
        return !w.i(this.feedTitleColor) ? ColorConstants.feedTitleColor : this.feedTitleColor;
    }

    public String getScreenBgColor() {
        return !w.i(this.screenBgColor) ? ColorConstants.screenBgColor : this.screenBgColor;
    }

    public String getStatusBarBgColor() {
        return !w.i(this.statusBarBgColor) ? ColorConstants.statusBarBgColor : this.statusBarBgColor;
    }

    public String getTagBgColor() {
        return !w.i(this.tagBgColor) ? ColorConstants.tagBgColor : this.tagBgColor;
    }

    public String getTagTextColor() {
        return !w.i(this.tagTextColor) ? ColorConstants.tagTextColor : this.tagTextColor;
    }

    public String getTimeTextColor() {
        return !w.i(this.timeTextColor) ? ColorConstants.timeTextColor : this.timeTextColor;
    }

    public void setActionBarBgColor(String str) {
        this.actionBarBgColor = str;
    }

    public void setActionBarTitleColor(String str) {
        this.actionBarTitleColor = str;
    }

    public void setAuthorTextColor(String str) {
        this.authorTextColor = str;
    }

    public void setFeedBgColor(String str) {
        this.feedBgColor = str;
    }

    public void setFeedContentTextColor(String str) {
        this.feedContentTextColor = str;
    }

    public void setFeedTitleColor(String str) {
        this.feedTitleColor = str;
    }

    public void setScreenBgColor(String str) {
        this.screenBgColor = str;
    }

    public void setStatusBarBgColor(String str) {
        this.statusBarBgColor = str;
    }

    public void setTagBgColor(String str) {
        this.tagBgColor = str;
    }

    public void setTagTextColor(String str) {
        this.tagTextColor = str;
    }

    public void setTimeTextColor(String str) {
        this.timeTextColor = str;
    }
}
