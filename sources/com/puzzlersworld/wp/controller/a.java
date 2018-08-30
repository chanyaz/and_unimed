package com.puzzlersworld.wp.controller;

import android.util.Log;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.gson.Gson;
import com.puzzlersworld.android.FriopinAppModule;
import com.puzzlersworld.android.data.c;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Post;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import retrofit2.ai;

public class a {
    public static int e = 10;
    @Inject
    RestServiceManager a;
    @Inject
    c b;
    @Inject
    g c;
    Gson d = new Gson();
    private ListeningScheduledExecutorService f;

    @Inject
    public a(@ForBackground ListeningScheduledExecutorService listeningScheduledExecutorService) {
        this.f = listeningScheduledExecutorService;
        a();
    }

    private List<Post> a(ai<List<Post>> aiVar) {
        if (!aiVar.a()) {
            return aiVar.c().f().contains("rest_post_invalid_page_number") ? new ArrayList() : null;
        } else {
            List list = (List) aiVar.b();
            a(list);
            return list;
        }
    }

    private void a(List<Post> list) {
        if (list != null) {
            for (Post post : list) {
                if (post.getContent() != null && post.getContent().isEmpty()) {
                }
            }
        }
    }

    public Object a(String str) {
        Log.d("FeedDataController", "Fetching url " + str);
        try {
            Object b = this.a.getWpApiService().fetchUrl(str).execute().b();
            if (b instanceof LinkedHashMap) {
                LinkedHashMap linkedHashMap = (LinkedHashMap) b;
                return (linkedHashMap.get("object_type") == null || !linkedHashMap.get("object_type").equals(MenuItemType.category.name())) ? FriopinAppModule.getMapper().convertValue((LinkedHashMap) b, Post.class) : FriopinAppModule.getMapper().convertValue((LinkedHashMap) b, Menu.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x04dd A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019e A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x04a4 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011e A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x04dd A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019e A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011e A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x04a4 A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x04dd A:{Catch:{ Exception -> 0x055b }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123 A:{Catch:{ Exception -> 0x055b }} */
    public java.util.List<com.puzzlersworld.wp.dto.Post> a(com.puzzlersworld.wp.dto.Menu r11, int r12) {
        /*
        r10 = this;
        r0 = 0;
        r1 = 1;
        r3 = "post";
        r2 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r4 = com.puzzlersworld.wp.dto.MenuItemType.save_for_later;	 Catch:{ Exception -> 0x055b }
        if (r2 != r4) goto L_0x0035;
    L_0x000c:
        r0 = r10.b;	 Catch:{ Exception -> 0x055b }
        r2 = e;	 Catch:{ Exception -> 0x055b }
        r0 = r0.a(r12, r2);	 Catch:{ Exception -> 0x055b }
    L_0x0014:
        r2 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r3 = com.puzzlersworld.wp.dto.MenuItemType.home;	 Catch:{ Exception -> 0x055b }
        if (r2 == r3) goto L_0x0026;
    L_0x001c:
        r2 = r11.getIsHome();	 Catch:{ Exception -> 0x055b }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x055b }
        if (r2 == 0) goto L_0x0034;
    L_0x0026:
        if (r0 == 0) goto L_0x0034;
    L_0x0028:
        if (r12 != r1) goto L_0x0034;
    L_0x002a:
        r1 = r10.f;	 Catch:{ Exception -> 0x055b }
        r2 = new com.puzzlersworld.wp.controller.a$1;	 Catch:{ Exception -> 0x055b }
        r2.<init>(r0);	 Catch:{ Exception -> 0x055b }
        r1.execute(r2);	 Catch:{ Exception -> 0x055b }
    L_0x0034:
        return r0;
    L_0x0035:
        r7 = new java.util.HashMap;	 Catch:{ Exception -> 0x055b }
        r7.<init>();	 Catch:{ Exception -> 0x055b }
        r2 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r4 = com.puzzlersworld.wp.dto.MenuItemType.search;	 Catch:{ Exception -> 0x055b }
        if (r2 != r4) goto L_0x017a;
    L_0x0042:
        r2 = "products";
        r4 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r4 = r4.getHomepage();	 Catch:{ Exception -> 0x055b }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x055b }
        if (r2 != 0) goto L_0x0060;
    L_0x0052:
        r2 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r2 = r2.getIswoo();	 Catch:{ Exception -> 0x055b }
        r2 = com.puzzlersworld.android.util.w.a(r2);	 Catch:{ Exception -> 0x055b }
        if (r2 == 0) goto L_0x0139;
    L_0x0060:
        r2 = "filter[q]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r1;
    L_0x007d:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.product_cat;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x019e;
    L_0x0085:
        r2 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        if (r2 == 0) goto L_0x017d;
    L_0x008b:
        r2 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r2 = r2.length();	 Catch:{ Exception -> 0x055b }
        if (r2 <= 0) goto L_0x017d;
    L_0x0095:
        r2 = "filter[category]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r1;
        r5 = r0;
        r6 = r0;
    L_0x00b4:
        r4 = "page";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r8.<init>();	 Catch:{ Exception -> 0x055b }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x055b }
        r8 = r8.append(r12);	 Catch:{ Exception -> 0x055b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r8);	 Catch:{ Exception -> 0x055b }
        r4 = "filter[posts_per_page]";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r8.<init>();	 Catch:{ Exception -> 0x055b }
        r9 = e;	 Catch:{ Exception -> 0x055b }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x055b }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x055b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r8);	 Catch:{ Exception -> 0x055b }
        r4 = "per_page";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r8.<init>();	 Catch:{ Exception -> 0x055b }
        r9 = e;	 Catch:{ Exception -> 0x055b }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x055b }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x055b }
        r8 = r8.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r8);	 Catch:{ Exception -> 0x055b }
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r8 = com.puzzlersworld.wp.dto.MenuItemType.home;	 Catch:{ Exception -> 0x055b }
        if (r4 != r8) goto L_0x0560;
    L_0x0108:
        r4 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0560;
    L_0x010e:
        r4 = "products";
        r8 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r8 = r8.getHomepage();	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r8);	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x04a4;
    L_0x011e:
        r2 = r0;
        r4 = r3;
        r3 = r1;
    L_0x0121:
        if (r3 == 0) goto L_0x04dd;
    L_0x0123:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpApiService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchProducts(r7);	 Catch:{ Exception -> 0x055b }
        r0 = r0.execute();	 Catch:{ Exception -> 0x055b }
        r0 = r0.b();	 Catch:{ Exception -> 0x055b }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x055b }
        goto L_0x0014;
    L_0x0139:
        r2 = r10.b();	 Catch:{ Exception -> 0x055b }
        if (r2 == 0) goto L_0x015e;
    L_0x013f:
        r2 = "search";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r0;
        goto L_0x007d;
    L_0x015e:
        r2 = "filter[s]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
    L_0x017a:
        r2 = r0;
        goto L_0x007d;
    L_0x017d:
        r2 = "filter[category]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r1;
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x019e:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.product_tag;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x01f8;
    L_0x01a6:
        r2 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        if (r2 == 0) goto L_0x01d7;
    L_0x01ac:
        r2 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r2 = r2.length();	 Catch:{ Exception -> 0x055b }
        if (r2 <= 0) goto L_0x01d7;
    L_0x01b6:
        r2 = "filter[tag]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r1;
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x01d7:
        r2 = "filter[tag]";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r4.<init>();	 Catch:{ Exception -> 0x055b }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r5 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x055b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r2, r4);	 Catch:{ Exception -> 0x055b }
        r2 = r1;
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x01f8:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.custom_taxonomy;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x0220;
    L_0x0200:
        r4 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = com.google.common.base.ab.a(r4);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0565;
    L_0x020a:
        r4 = "filter[taxonomy_name]";
        r5 = r11.getTaxonomy_name();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "filter[taxonomy_slug]";
        r5 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r1;
        r6 = r1;
        goto L_0x00b4;
    L_0x0220:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.category;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x02fc;
    L_0x0228:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x027a;
    L_0x022e:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x027a;
    L_0x023e:
        r4 = "filter[cat]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "categories";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x027a:
        r4 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x02aa;
    L_0x0280:
        r4 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.length();	 Catch:{ Exception -> 0x055b }
        if (r4 <= 0) goto L_0x02aa;
    L_0x028a:
        r4 = "filter[category_name]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r1;
        goto L_0x00b4;
    L_0x02aa:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0565;
    L_0x02b0:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0565;
    L_0x02c0:
        r4 = "filter[cat]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "categories";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x02fc:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.tag;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x03d8;
    L_0x0304:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0356;
    L_0x030a:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0356;
    L_0x031a:
        r4 = "filter[tag]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "tags";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x0356:
        r4 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0386;
    L_0x035c:
        r4 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r4 = r4.length();	 Catch:{ Exception -> 0x055b }
        if (r4 <= 0) goto L_0x0386;
    L_0x0366:
        r4 = "filter[tag]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r1;
        goto L_0x00b4;
    L_0x0386:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0565;
    L_0x038c:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0565;
    L_0x039c:
        r4 = "filter[tag]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "tags";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x03d8:
        r4 = r11.getMenuItemType();	 Catch:{ Exception -> 0x055b }
        r5 = com.puzzlersworld.wp.dto.MenuItemType.author;	 Catch:{ Exception -> 0x055b }
        if (r4 != r5) goto L_0x0565;
    L_0x03e0:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0432;
    L_0x03e6:
        r4 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0432;
    L_0x03f6:
        r4 = "filter[author_name]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "author";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getObjectId();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x0432:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0484;
    L_0x0438:
        r4 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r8 = -1;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x055b }
        if (r4 != 0) goto L_0x0484;
    L_0x0448:
        r4 = "filter[author_name]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r4 = "author";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getID();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
    L_0x0484:
        r4 = "filter[author_name]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x055b }
        r5.<init>();	 Catch:{ Exception -> 0x055b }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r6 = r11.getSlug();	 Catch:{ Exception -> 0x055b }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x055b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x055b }
        r7.put(r4, r5);	 Catch:{ Exception -> 0x055b }
        r5 = r0;
        r6 = r1;
        goto L_0x00b4;
    L_0x04a4:
        r4 = "pages";
        r8 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r8 = r8.getHomepage();	 Catch:{ Exception -> 0x055b }
        r4 = r4.equals(r8);	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x04b9;
    L_0x04b4:
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x0121;
    L_0x04b9:
        r4 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r4 = r4.getCustomPostTypes();	 Catch:{ Exception -> 0x055b }
        r8 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r8 = r8.getHomepage();	 Catch:{ Exception -> 0x055b }
        r4 = r4.contains(r8);	 Catch:{ Exception -> 0x055b }
        if (r4 == 0) goto L_0x0560;
    L_0x04cf:
        r3 = com.puzzlersworld.android.FullscreenActivity.A();	 Catch:{ Exception -> 0x055b }
        r3 = r3.getHomepage();	 Catch:{ Exception -> 0x055b }
        r4 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        goto L_0x0121;
    L_0x04dd:
        if (r2 == 0) goto L_0x04f3;
    L_0x04df:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchPages(r7);	 Catch:{ Exception -> 0x055b }
        r0 = r0.execute();	 Catch:{ Exception -> 0x055b }
        r0 = r10.a(r0);	 Catch:{ Exception -> 0x055b }
        goto L_0x0014;
    L_0x04f3:
        if (r0 == 0) goto L_0x051f;
    L_0x04f5:
        r0 = r10.b();	 Catch:{ Exception -> 0x055b }
        if (r0 == 0) goto L_0x050f;
    L_0x04fb:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchCustomPostsV2(r4, r7);	 Catch:{ Exception -> 0x055b }
    L_0x0505:
        r0 = r0.execute();	 Catch:{ Exception -> 0x055b }
        r0 = r10.a(r0);	 Catch:{ Exception -> 0x055b }
        goto L_0x0014;
    L_0x050f:
        r0 = "type";
        r7.put(r0, r4);	 Catch:{ Exception -> 0x055b }
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchPosts(r7);	 Catch:{ Exception -> 0x055b }
        goto L_0x0505;
    L_0x051f:
        if (r6 != 0) goto L_0x0523;
    L_0x0521:
        if (r5 == 0) goto L_0x053d;
    L_0x0523:
        r0 = r10.b();	 Catch:{ Exception -> 0x055b }
        if (r0 == 0) goto L_0x053d;
    L_0x0529:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpApiService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchPosts(r7);	 Catch:{ Exception -> 0x055b }
    L_0x0533:
        r0 = r0.execute();	 Catch:{ Exception -> 0x055b }
        r0 = r10.a(r0);	 Catch:{ Exception -> 0x055b }
        goto L_0x0014;
    L_0x053d:
        if (r5 == 0) goto L_0x0550;
    L_0x053f:
        r0 = r10.b();	 Catch:{ Exception -> 0x055b }
        if (r0 != 0) goto L_0x0550;
    L_0x0545:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpApiService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchAndroAppPosts(r7);	 Catch:{ Exception -> 0x055b }
        goto L_0x0533;
    L_0x0550:
        r0 = r10.a;	 Catch:{ Exception -> 0x055b }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x055b }
        r0 = r0.fetchPosts(r7);	 Catch:{ Exception -> 0x055b }
        goto L_0x0533;
    L_0x055b:
        r0 = move-exception;
        r0.printStackTrace();
        throw r0;
    L_0x0560:
        r4 = r3;
        r3 = r2;
        r2 = r0;
        goto L_0x0121;
    L_0x0565:
        r5 = r0;
        r6 = r0;
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.wp.controller.a.a(com.puzzlersworld.wp.dto.Menu, int):java.util.List<com.puzzlersworld.wp.dto.Post>");
    }

    public void a() {
    }

    public boolean b() {
        return w.a(this.a);
    }
}
