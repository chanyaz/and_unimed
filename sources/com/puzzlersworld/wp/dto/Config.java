package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Config {
    private String blogurl = null;
    private String category_base;
    private ThemeColors colors;
    @JsonProperty("comments_provider")
    private String commentsProvider;
    @JsonProperty("custom_post_types")
    private Set<String> customPostTypes;
    @JsonProperty("custom_taxonomies")
    private Set<String> customTaxonomies;
    @JsonProperty("disable_image_zoom")
    private String disableImageClick;
    @JsonProperty("search_box_status")
    private Integer disableSearchBox;
    private String fontName = null;
    private String homepage;
    private Boolean iswoo;
    private Layout layout;
    @JsonProperty("comments_depth")
    private Integer maxCommentsDepth;
    @JsonProperty("menulist")
    private List<Menu> menuList;
    private Monetise monetise;
    @JsonProperty("push_stack_thershold")
    private Integer pushStackThershold;
    @JsonProperty("regex_open_browser")
    private String regexOpenInBrowser;
    @JsonProperty("regex_open_webview")
    private String regexOpenInWebview;
    @JsonProperty("show_cart_icon")
    private Integer showCartIcon;
    @JsonProperty("show_comments_count")
    private Integer showCommentsCount;
    @JsonProperty("show_save_option")
    private Integer showSaveOption;
    @JsonProperty("slidermenu")
    private List<Menu> sliderMenu;
    private Map<String, String> stringMap = new HashMap();
    private String tag_base;
    private UrlHandle urlHandle = new UrlHandle();

    public String getBlogurl() {
        return this.blogurl;
    }

    public String getCategory_base() {
        return this.category_base;
    }

    public ThemeColors getColors() {
        return this.colors;
    }

    public String getCommentsProvider() {
        return this.commentsProvider;
    }

    public Set<String> getCustomPostTypes() {
        if (this.customPostTypes == null) {
            this.customPostTypes = new HashSet();
        }
        return this.customPostTypes;
    }

    public Set<String> getCustomTaxonomies() {
        if (this.customTaxonomies == null) {
            this.customTaxonomies = new HashSet();
        }
        return this.customTaxonomies;
    }

    public String getDisableImageClick() {
        return this.disableImageClick;
    }

    public Integer getDisableSearchBox() {
        return this.disableSearchBox;
    }

    public String getFontName() {
        return this.fontName;
    }

    public String getHomepage() {
        return this.homepage;
    }

    public Boolean getIswoo() {
        return this.iswoo;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public Integer getMaxCommentsDepth() {
        return this.maxCommentsDepth;
    }

    public List<Menu> getMenuList() {
        return this.menuList;
    }

    public Monetise getMonetise() {
        return this.monetise;
    }

    public Integer getPushStackThershold() {
        return this.pushStackThershold;
    }

    public String getRegexOpenInBrowser() {
        return this.regexOpenInBrowser;
    }

    public String getRegexOpenInWebview() {
        return this.regexOpenInWebview;
    }

    public Integer getShowCartIcon() {
        return this.showCartIcon;
    }

    public Integer getShowSaveOption() {
        return this.showSaveOption;
    }

    public List<Menu> getSliderMenu() {
        if (this.sliderMenu == null) {
            this.sliderMenu = new ArrayList();
        }
        return this.sliderMenu;
    }

    public Map<String, String> getStringMap() {
        return this.stringMap;
    }

    public String getTag_base() {
        return this.tag_base;
    }

    public UrlHandle getUrlHandle() {
        return this.urlHandle;
    }

    public Integer isShowCommentsCount() {
        return this.showCommentsCount;
    }

    public void setBlogurl(String str) {
        this.blogurl = str;
    }

    public void setCategory_base(String str) {
        this.category_base = str;
    }

    public void setColors(ThemeColors themeColors) {
        this.colors = themeColors;
    }

    public void setCommentsProvider(String str) {
        this.commentsProvider = str;
    }

    public void setCustomPostTypes(Set<String> set) {
        this.customPostTypes = set;
    }

    public void setCustomTaxonomies(Set<String> set) {
        this.customTaxonomies = set;
    }

    public void setDisableImageClick(String str) {
        this.disableImageClick = str;
    }

    public void setDisableSearchBox(Integer num) {
        this.disableSearchBox = num;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }

    public void setHomepage(String str) {
        this.homepage = str;
    }

    public void setIswoo(Boolean bool) {
        this.iswoo = bool;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setMaxCommentsDepth(Integer num) {
        this.maxCommentsDepth = num;
    }

    public void setMenuList(List<Menu> list) {
        this.menuList = list;
    }

    public void setMonetise(Monetise monetise) {
        this.monetise = monetise;
    }

    public void setPushStackThershold(Integer num) {
        this.pushStackThershold = num;
    }

    public void setRegexOpenInBrowser(String str) {
        this.regexOpenInBrowser = str;
    }

    public void setRegexOpenInWebview(String str) {
        this.regexOpenInWebview = str;
    }

    public void setShowCartIcon(Integer num) {
        this.showCartIcon = num;
    }

    public void setShowCommentsCount(Integer num) {
        this.showCommentsCount = num;
    }

    public void setShowSaveOption(Integer num) {
        this.showSaveOption = num;
    }

    public void setSliderMenu(List<Menu> list) {
        this.sliderMenu = list;
    }

    public void setStringMap(Map<String, String> map) {
        this.stringMap = map;
    }

    public void setTag_base(String str) {
        this.tag_base = str;
    }

    public void setUrlHandle(UrlHandle urlHandle) {
        this.urlHandle = urlHandle;
    }
}
