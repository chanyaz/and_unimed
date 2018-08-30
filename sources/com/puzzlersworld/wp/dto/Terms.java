package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Terms implements Serializable {
    @JsonProperty("category")
    private List<Category> categories;
    @JsonProperty("post_tag")
    private Set<PostTag> tags;
    @JsonProperty("taxonomies")
    private HashMap<String, Term> taxonomies;

    public List<Category> getCategories() {
        return this.categories;
    }

    public Set<PostTag> getTags() {
        if (this.tags != null) {
            Iterator it = this.tags.iterator();
            while (it.hasNext()) {
                PostTag postTag = (PostTag) it.next();
                if (postTag == null || postTag.getID() == null) {
                    it.remove();
                }
            }
        }
        return this.tags;
    }

    public HashMap<String, Term> getTaxonomies() {
        return this.taxonomies;
    }

    public void setCategories(List<Category> list) {
        this.categories = list;
    }

    public void setTags(Set<PostTag> set) {
        this.tags = set;
    }

    public void setTaxonomies(HashMap<String, Term> hashMap) {
        this.taxonomies = hashMap;
    }
}
