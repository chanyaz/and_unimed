package com.mikepenz.materialdrawer.model.interfaces;

import com.mikepenz.materialdrawer.a.e;

public interface Nameable<T> {
    e getName();

    T withName(int i);

    T withName(e eVar);

    T withName(String str);
}
