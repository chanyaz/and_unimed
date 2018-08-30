package com.puzzlersworld.android.gcm;

import android.app.NotificationManager;
import android.os.Build.VERSION;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.gson.Gson;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import com.puzzlersworld.wp.dto.Config;
import com.puzzlersworld.wp.dto.X;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class AndroAppGcmListenerService extends FirebaseMessagingService {
    @Inject
    a b;
    @Inject
    g c;
    @Inject
    RestServiceManager d;
    private NotificationManager e;
    private Gson f;
    private X g;
    private Config h;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x022b  */
    private void a(java.util.Map r15) {
        /*
        r14 = this;
        r13 = 2131230781; // 0x7f08003d float:1.8077624E38 double:1.0529679123E-314;
        r12 = 2130837654; // 0x7f020096 float:1.7280268E38 double:1.0527736817E-314;
        r3 = 0;
        r6 = 0;
        r4 = 1;
        r0 = "AndroApp:";
        r1 = "Generating notification";
        android.util.Log.d(r0, r1);
        r0 = "notification";
        r0 = r14.getSystemService(r0);
        r0 = (android.app.NotificationManager) r0;
        r14.e = r0;
        r7 = new android.content.Intent;
        r0 = com.puzzlersworld.android.FullscreenActivity.class;
        r7.<init>(r14, r0);
        r8 = java.lang.System.currentTimeMillis();
        r0 = r14.getApplication();
        com.puzzlersworld.android.gcm.b.a(r0);
        r0 = "AndroAppListenerService";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Message : ";
        r1 = r1.append(r2);
        r1 = r1.append(r15);
        r1 = r1.toString();
        android.util.Log.i(r0, r1);
        r5 = new com.puzzlersworld.wp.dto.Post;
        r5.<init>();
        r0 = "post_id";
        r0 = r15.containsKey(r0);
        if (r0 == 0) goto L_0x0061;
    L_0x0051:
        r1 = new java.lang.Long;
        r0 = "post_id";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r1.<init>(r0);
        r5.setID(r1);
    L_0x0061:
        r0 = "title";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r5.setTitle(r0);
        r0 = "link";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r5.setLink(r0);
        r0 = "excerpt";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r5.setExcerpt(r0);
        r0 = "postImage";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r5.setPostImage(r0);
        r0 = "cache";
        r0 = r15.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "postType";
        r1 = r15.get(r1);
        r1 = (java.lang.String) r1;
        if (r1 != 0) goto L_0x03db;
    L_0x009f:
        r1 = "post";
        r2 = r1;
    L_0x00a2:
        r5.setPostType(r2);
        r1 = "AndroAppListenerService";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Post ";
        r10 = r10.append(r11);
        r11 = r5.getID();
        r10 = r10.append(r11);
        r11 = " link= ";
        r10 = r10.append(r11);
        r11 = r5.getLink();
        r10 = r10.append(r11);
        r11 = " contentType ";
        r10 = r10.append(r11);
        r11 = r5.getPostContentType();
        r10 = r10.append(r11);
        r10 = r10.toString();
        android.util.Log.d(r1, r10);
        r1 = r5.getID();
        if (r1 != 0) goto L_0x00eb;
    L_0x00e3:
        r0 = "AndroApp:";
        r1 = "Returning as post id is null";
        android.util.Log.d(r0, r1);
    L_0x00ea:
        return;
    L_0x00eb:
        r1 = com.puzzlersworld.android.gcm.a.c;
        r10 = r5.getTitle();
        r1.add(r10);
        r1 = com.puzzlersworld.android.gcm.a.c;
        r1 = r1.size();
        r10 = r14.b();
        if (r1 > r10) goto L_0x0303;
    L_0x0100:
        if (r0 == 0) goto L_0x010a;
    L_0x0102:
        r1 = "yes";
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x03ce }
        if (r0 == 0) goto L_0x03d7;
    L_0x010a:
        r0 = "AndroApp:";
        r1 = "Caching the post";
        android.util.Log.d(r0, r1);	 Catch:{ Exception -> 0x03ce }
        r0 = "page";
        r0 = r2.equals(r0);	 Catch:{ Exception -> 0x03ce }
        if (r0 == 0) goto L_0x029e;
    L_0x0119:
        r0 = r14.d;	 Catch:{ Exception -> 0x03ce }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x03ce }
        r1 = new java.lang.Long;	 Catch:{ Exception -> 0x03ce }
        r10 = r5.getID();	 Catch:{ Exception -> 0x03ce }
        r10 = r10.longValue();	 Catch:{ Exception -> 0x03ce }
        r1.<init>(r10);	 Catch:{ Exception -> 0x03ce }
        r0 = r0.fetchPage(r1);	 Catch:{ Exception -> 0x03ce }
    L_0x0130:
        r0 = r0.execute();	 Catch:{ Exception -> 0x03ce }
        r0 = r0.b();	 Catch:{ Exception -> 0x03ce }
        r0 = (com.puzzlersworld.wp.dto.Post) r0;	 Catch:{ Exception -> 0x03ce }
        if (r0 != 0) goto L_0x02d8;
    L_0x013c:
        r1 = "AndroApp:";
        r3 = "Returning as post is null";
        android.util.Log.d(r1, r3);	 Catch:{ Exception -> 0x0144 }
        goto L_0x00ea;
    L_0x0144:
        r1 = move-exception;
        r3 = r4;
        r5 = r0;
        r0 = r1;
    L_0x0148:
        r0.printStackTrace();
        r0 = r3;
    L_0x014c:
        if (r0 != 0) goto L_0x0182;
    L_0x014e:
        r0 = "AndroApp";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "Notificatio post id  ";
        r1 = r1.append(r3);
        r3 = r5.getID();
        r1 = r1.append(r3);
        r3 = " post type ";
        r1 = r1.append(r3);
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
        r0 = "notificationPostId";
        r1 = r5.getID();
        r7.putExtra(r0, r1);
        r0 = "postType";
        r7.putExtra(r0, r2);
    L_0x0182:
        r0 = r5.getFeaturedImageObject();
        if (r0 == 0) goto L_0x03d4;
    L_0x0188:
        r0 = r5.getFeaturedImageObject();
        r0 = r0.getSource();
        if (r0 == 0) goto L_0x03d4;
    L_0x0192:
        r0 = r5.getFeaturedImageObject();
        r0 = r0.getSource();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x03d4;
    L_0x01a0:
        r0 = r5.getFeaturedImageObject();
        r0 = r0.getSource();
    L_0x01a8:
        r1 = com.puzzlersworld.android.util.w.f(r0);
        if (r1 == 0) goto L_0x01b2;
    L_0x01ae:
        r0 = r5.getPostImage();
    L_0x01b2:
        r1 = com.puzzlersworld.android.util.w.f(r0);
        if (r1 != 0) goto L_0x03d1;
    L_0x01b8:
        r0 = com.puzzlersworld.android.util.w.a(r0);
    L_0x01bc:
        if (r0 == 0) goto L_0x02f0;
    L_0x01be:
        r1 = new android.support.v4.app.am;
        r1.<init>();
        r0 = r1.a(r0);
        r1 = r5.getTitle();
        r1 = com.puzzlersworld.android.util.w.b(r1);
        r0 = r0.b(r1);
        r1 = r5.getTitle();
        r1 = com.puzzlersworld.android.util.w.b(r1);
        r0 = r0.a(r1);
        r0 = r0.b(r6);
    L_0x01e3:
        r1 = new android.support.v4.app.ao;
        r2 = "androapp_posts";
        r1.<init>(r14, r2);
        r2 = r14.c();
        r1 = r1.a(r2);
        r2 = r14.getDrawable(r12);
        r2 = com.puzzlersworld.android.util.w.a(r2);
        r1 = r1.a(r2);
        r2 = r5.getTitle();
        r2 = com.puzzlersworld.android.util.w.b(r2);
        r1 = r1.a(r2);
        r0 = r1.a(r0);
        r0 = r0.a(r4);
        r0 = r0.a(r8);
        r1 = "Posts";
        r0 = r0.a(r1);
        r1 = r5.getExcerpt();
        r1 = com.puzzlersworld.android.util.w.b(r1);
        r0 = r0.b(r1);
        r1 = r0;
    L_0x0229:
        if (r5 == 0) goto L_0x00ea;
    L_0x022b:
        r0 = r5.getID();
        r0 = r0.intValue();
        if (r4 != 0) goto L_0x023c;
    L_0x0235:
        r0 = 12426; // 0x308a float:1.7413E-41 double:6.1393E-320;
        r2 = "requestCode";
        r7.putExtra(r2, r0);
    L_0x023c:
        r2 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r2 = android.app.PendingIntent.getActivity(r14, r0, r7, r2);
        r1.a(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r14.getString(r13);
        r2 = r2.append(r3);
        r3 = " - ";
        r2 = r2.append(r3);
        r3 = com.puzzlersworld.wp.dto.StringConstants.NEW_POST;
        r3 = r3.getMessage();
        r2 = r2.append(r3);
        r3 = " - ";
        r2 = r2.append(r3);
        r3 = r5.getTitle();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.c(r2);
        r1 = r1.a();
        r2 = com.puzzlersworld.android.gcm.a.c;
        r2 = r2.size();
        r3 = 2;
        if (r2 > r3) goto L_0x03bd;
    L_0x0284:
        r2 = r1.defaults;
        r2 = r2 | 1;
        r1.defaults = r2;
    L_0x028a:
        r2 = r1.defaults;
        r2 = r2 | 8;
        r1.defaults = r2;
        r2 = r14.e;
        r2.notify(r0, r1);
        r0 = "AndroApp:";
        r1 = "After notify";
        android.util.Log.d(r0, r1);
        goto L_0x00ea;
    L_0x029e:
        r0 = r14.d;	 Catch:{ Exception -> 0x03ce }
        r0 = com.puzzlersworld.android.util.w.a(r0);	 Catch:{ Exception -> 0x03ce }
        if (r0 == 0) goto L_0x02bf;
    L_0x02a6:
        r0 = r14.d;	 Catch:{ Exception -> 0x03ce }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x03ce }
        r1 = new java.lang.Long;	 Catch:{ Exception -> 0x03ce }
        r10 = r5.getID();	 Catch:{ Exception -> 0x03ce }
        r10 = r10.longValue();	 Catch:{ Exception -> 0x03ce }
        r1.<init>(r10);	 Catch:{ Exception -> 0x03ce }
        r0 = r0.fetchCustomPostV2(r2, r1);	 Catch:{ Exception -> 0x03ce }
        goto L_0x0130;
    L_0x02bf:
        r0 = r14.d;	 Catch:{ Exception -> 0x03ce }
        r0 = r0.getWpCoreService();	 Catch:{ Exception -> 0x03ce }
        r1 = new java.lang.Long;	 Catch:{ Exception -> 0x03ce }
        r10 = r5.getID();	 Catch:{ Exception -> 0x03ce }
        r10 = r10.longValue();	 Catch:{ Exception -> 0x03ce }
        r1.<init>(r10);	 Catch:{ Exception -> 0x03ce }
        r0 = r0.fetchPost(r1);	 Catch:{ Exception -> 0x03ce }
        goto L_0x0130;
    L_0x02d8:
        r1 = r14.getApplication();	 Catch:{ Exception -> 0x0144 }
        r1 = (com.puzzlersworld.android.FriopinApplication) r1;	 Catch:{ Exception -> 0x0144 }
        r1 = r1.f();	 Catch:{ Exception -> 0x0144 }
        r1 = r1.toJson(r0);	 Catch:{ Exception -> 0x0144 }
        r3 = "entity";
        r7.putExtra(r3, r1);	 Catch:{ Exception -> 0x0144 }
        r1 = r0;
        r0 = r4;
    L_0x02ed:
        r5 = r1;
        goto L_0x014c;
    L_0x02f0:
        r0 = new android.support.v4.app.an;
        r0.<init>();
        r1 = r5.getExcerpt();
        r1 = com.puzzlersworld.android.util.w.b(r1);
        r0 = r0.a(r1);
        goto L_0x01e3;
    L_0x0303:
        r0 = new com.puzzlersworld.wp.dto.Menu;	 Catch:{ Exception -> 0x0332 }
        r0.<init>();	 Catch:{ Exception -> 0x0332 }
        r1 = com.puzzlersworld.wp.dto.MenuItemType.home;	 Catch:{ Exception -> 0x0332 }
        r0.setMenuItemType(r1);	 Catch:{ Exception -> 0x0332 }
        r1 = r14.b;	 Catch:{ Exception -> 0x0332 }
        r2 = 1;
        r1.a(r0, r2);	 Catch:{ Exception -> 0x0332 }
    L_0x0313:
        r1 = new android.support.v4.app.ap;
        r1.<init>();
        r0 = com.puzzlersworld.android.gcm.a.c;
        r2 = r0.iterator();
    L_0x031e:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0337;
    L_0x0324:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r0 = com.puzzlersworld.android.util.w.b(r0);
        r1.b(r0);
        goto L_0x031e;
    L_0x0332:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0313;
    L_0x0337:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.puzzlersworld.android.gcm.a.c;
        r2 = r2.size();
        r0 = r0.append(r2);
        r2 = " ";
        r0 = r0.append(r2);
        r2 = com.puzzlersworld.wp.dto.StringConstants.NEW_POSTS;
        r2 = r2.getMessage();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.a(r0);
        r0 = new android.support.v4.app.ao;
        r2 = "androapp_posts";
        r0.<init>(r14, r2);
        r2 = r14.getString(r13);
        r0 = r0.a(r2);
        r2 = r14.c();
        r0 = r0.a(r2);
        r2 = r14.getDrawable(r12);
        r2 = com.puzzlersworld.android.util.w.a(r2);
        r0 = r0.a(r2);
        r0 = r0.a(r1);
        r1 = "Posts";
        r0 = r0.a(r1);
        r0 = r0.c(r4);
        r0 = r0.a(r4);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.puzzlersworld.android.gcm.a.c;
        r2 = r2.size();
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.puzzlersworld.wp.dto.StringConstants.NEW_POSTS;
        r2 = r2.getMessage();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0 = r0.b(r1);
        r4 = r3;
        r1 = r0;
        goto L_0x0229;
    L_0x03bd:
        r2 = com.puzzlersworld.android.gcm.a.c;
        r2 = r2.size();
        r3 = 5;
        if (r2 > r3) goto L_0x028a;
    L_0x03c6:
        r2 = r1.defaults;
        r2 = r2 | 2;
        r1.defaults = r2;
        goto L_0x028a;
    L_0x03ce:
        r0 = move-exception;
        goto L_0x0148;
    L_0x03d1:
        r0 = r6;
        goto L_0x01bc;
    L_0x03d4:
        r0 = r6;
        goto L_0x01a8;
    L_0x03d7:
        r0 = r3;
        r1 = r5;
        goto L_0x02ed;
    L_0x03db:
        r2 = r1;
        goto L_0x00a2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.gcm.AndroAppGcmListenerService.a(java.util.Map):void");
    }

    private int b() {
        return (this.h == null || this.h.getPushStackThershold() == null) ? 3 : this.h.getPushStackThershold().intValue();
    }

    private int c() {
        return (VERSION.SDK_INT >= 21 ? 1 : null) != null ? R.drawable.notification_icon : R.drawable.ic_launcher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6 A:{ExcHandler: java.lang.NoSuchMethodError (r0_31 'e' java.lang.Error), Splitter: B:0:0x0000} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:20:0x00bb, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x00bc, code:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:29:0x00d6, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:30:0x00d7, code:
            com.puzzlersworld.android.FriopinApplication.a().a(r0);
     */
    /* JADX WARNING: Missing block: B:32:?, code:
            return;
     */
    public void a(com.google.firebase.messaging.RemoteMessage r7) {
        /*
        r6 = this;
        super.a(r7);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r1 = r7.a();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r2 = r7.b();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        com.puzzlersworld.android.util.InjectibleApplication.a(r6);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = new com.google.gson.Gson;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0.<init>();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r6.f = r0;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = "message";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r3 = "AndroAppListenerService";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r4.<init>();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r5 = "From: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r4 = r4.append(r1);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        android.util.Log.d(r3, r4);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r3 = "AndroAppListenerService";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r4.<init>();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r5 = "Message: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        android.util.Log.d(r3, r0);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = "/topics/";
        r0 = r1.startsWith(r0);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x0055;
    L_0x0055:
        r0 = r6.c;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0.a();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = r6.c;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = r0.e();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x0085;
    L_0x0062:
        r0 = r6.f;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r6.c;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r1.e();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r3 = com.puzzlersworld.wp.dto.Config.class;
        r0 = r0.fromJson(r1, r3);	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = (com.puzzlersworld.wp.dto.Config) r0;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r6.h = r0;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = r6.h;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x0085;
    L_0x0078:
        r0 = com.puzzlersworld.android.FriopinApplication.h();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r6.h;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r1.getStringMap();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0.setStringMap(r1);	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
    L_0x0085:
        r0 = r6.c;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = r0.f();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x009f;
    L_0x008d:
        r0 = r6.f;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r6.c;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r1 = r1.f();	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r3 = com.puzzlersworld.wp.dto.X.class;
        r0 = r0.fromJson(r1, r3);	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r0 = (com.puzzlersworld.wp.dto.X) r0;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
        r6.g = r0;	 Catch:{ Exception -> 0x00bb, NoSuchMethodError -> 0x00d6 }
    L_0x009f:
        r0 = r6.g;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x00b7;
    L_0x00a3:
        r0 = r6.g;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = r0.getP();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x00b7;
    L_0x00ab:
        r0 = r6.g;	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = r0.getP();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        if (r0 == 0) goto L_0x00ce;
    L_0x00b7:
        r6.a(r2);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
    L_0x00ba:
        return;
    L_0x00bb:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        goto L_0x009f;
    L_0x00c0:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = com.puzzlersworld.android.FriopinApplication.a();	 Catch:{ Exception -> 0x00cc }
        r1.a(r0);	 Catch:{ Exception -> 0x00cc }
        goto L_0x00ba;
    L_0x00cc:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x00ce:
        r0 = "AndroAppListenerService";
        r1 = "Not showing push notification as it is not enabled";
        android.util.Log.d(r0, r1);	 Catch:{ Exception -> 0x00c0, NoSuchMethodError -> 0x00d6 }
        goto L_0x00ba;
    L_0x00d6:
        r0 = move-exception;
        r1 = com.puzzlersworld.android.FriopinApplication.a();
        r1.a(r0);
        goto L_0x00ba;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.puzzlersworld.android.gcm.AndroAppGcmListenerService.a(com.google.firebase.messaging.RemoteMessage):void");
    }
}
