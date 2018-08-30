package com.squareup.otto;

import com.appnext.ads.fullscreen.RewardedVideo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class b {
    private final ConcurrentMap<Class<?>, Set<c>> a;
    private final ConcurrentMap<Class<?>, d> b;
    private final String c;
    private final ThreadEnforcer d;
    private final HandlerFinder e;
    private final ThreadLocal<ConcurrentLinkedQueue<Object>> f;
    private final ThreadLocal<Boolean> g;
    private final Map<Class<?>, Set<Class<?>>> h;

    public b() {
        this(RewardedVideo.VIDEO_MODE_DEFAULT);
    }

    public b(ThreadEnforcer threadEnforcer) {
        this(threadEnforcer, RewardedVideo.VIDEO_MODE_DEFAULT);
    }

    public b(ThreadEnforcer threadEnforcer, String str) {
        this(threadEnforcer, str, HandlerFinder.a);
    }

    b(ThreadEnforcer threadEnforcer, String str, HandlerFinder handlerFinder) {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.f = new ThreadLocal<ConcurrentLinkedQueue<Object>>() {
            /* renamed from: a */
            protected ConcurrentLinkedQueue<Object> initialValue() {
                return new ConcurrentLinkedQueue();
            }
        };
        this.g = new ThreadLocal<Boolean>() {
            /* renamed from: a */
            protected Boolean initialValue() {
                return Boolean.valueOf(false);
            }
        };
        this.h = new HashMap();
        this.d = threadEnforcer;
        this.c = str;
        this.e = handlerFinder;
    }

    public b(String str) {
        this(ThreadEnforcer.b, str);
    }

    public String toString() {
        return "[Bus \"" + this.c + "\"]";
    }
}
