package com.puzzlersworld.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(new Intent(this, FullscreenActivity.class));
        finish();
    }
}
