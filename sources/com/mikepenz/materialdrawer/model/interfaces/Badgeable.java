package com.mikepenz.materialdrawer.model.interfaces;

import com.mikepenz.materialdrawer.a.e;

public interface Badgeable<T> {
    e getBadge();

    T withBadge(int i);

    T withBadge(e eVar);

    T withBadge(String str);
}
