package com.puzzlersworld.android.ui.activity;

import com.puzzlersworld.android.common.AndroAppFragmentType;

public interface AndroAppFragment {
    AndroAppFragmentType getFragmentType();

    String getTitle();

    Object getTriggerObject();
}
