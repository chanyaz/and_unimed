package com.mikepenz.materialdrawer.model.interfaces;

import android.graphics.drawable.Drawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.a.d;

public interface Iconable<T> {
    d getIcon();

    T withIcon(Drawable drawable);

    T withIcon(IIcon iIcon);

    T withIcon(d dVar);
}
