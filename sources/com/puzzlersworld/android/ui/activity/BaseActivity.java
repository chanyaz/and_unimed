package com.puzzlersworld.android.ui.activity;

import android.app.Activity;
import com.puzzlersworld.android.util.InjectibleApplication;

public class BaseActivity extends Activity {
    protected void onResume() {
        InjectibleApplication.b(this);
        super.onResume();
    }
}
