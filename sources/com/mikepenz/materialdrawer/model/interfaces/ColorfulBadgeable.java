package com.mikepenz.materialdrawer.model.interfaces;

import com.mikepenz.materialdrawer.a.a;

public interface ColorfulBadgeable<T> extends Badgeable<T> {
    a getBadgeStyle();

    T withBadgeStyle(a aVar);
}
