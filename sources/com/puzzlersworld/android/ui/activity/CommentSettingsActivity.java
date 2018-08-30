package com.puzzlersworld.android.ui.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.wp.dto.StringConstants;
import mobi.androapp.ac.c8700.R;

public class CommentSettingsActivity extends AppCompatActivity {
    private EditText n;
    private EditText o;
    private Button p;
    private SharedPreferences q;

    private void k() {
        if (FullscreenActivity.z() != null && f() != null) {
            f().a(new ColorDrawable(Color.parseColor(FullscreenActivity.z().getActionBarBgColor())));
        }
    }

    private boolean l() {
        boolean z;
        String obj = this.n.getText().toString();
        if (obj == null || obj.isEmpty()) {
            this.n.setError(StringConstants.VALID_NAME.getMessage());
            z = true;
        } else if (obj.length() < 3) {
            this.n.setError(StringConstants.ATLEAST_THREE_CHARS.getMessage());
            z = true;
        } else {
            z = false;
        }
        CharSequence obj2 = this.o.getText().toString();
        if (obj2 == null || obj2.isEmpty()) {
            this.o.setError(StringConstants.EMAIL_EMPTY.getMessage());
            z = true;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(obj2).matches()) {
            this.o.setError(StringConstants.VALID_EMAIL.getMessage());
            z = true;
        }
        return !z;
    }

    public void j() {
        if (l()) {
            FullscreenActivity.D = this.n.getText().toString();
            FullscreenActivity.E = this.o.getText().toString();
            Editor edit = this.q.edit();
            edit.putString("commentNameKey", FullscreenActivity.D);
            edit.putString("commentEmailKey", FullscreenActivity.E);
            edit.commit();
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_comment_settings);
        a((Toolbar) findViewById(R.id.toolbar));
        k();
        this.n = (EditText) findViewById(R.id.nameTextBox);
        this.o = (EditText) findViewById(R.id.emailTextBox);
        ((TextView) findViewById(R.id.name)).setText(StringConstants.NAME.getMessage());
        ((TextView) findViewById(R.id.email)).setText(StringConstants.EMAIL.getMessage());
        ((TextView) findViewById(R.id.enter)).setText(StringConstants.SUBMIT.getMessage());
        this.q = getApplication().getSharedPreferences(getString(R.string.user_details_file), 0);
        this.n.setText(this.q.getString("commentNameKey", ""));
        this.o.setText(this.q.getString("commentEmailKey", ""));
        this.p = (Button) findViewById(R.id.enter);
        this.p.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentSettingsActivity.this.j();
            }
        });
        setTitle(StringConstants.COMMENT_SETTINGS.getMessage());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        finish();
        return false;
    }

    protected void onResume() {
        super.onResume();
        FriopinApplication.a().a("Comments Settings Screen");
    }

    public void setTitle(CharSequence charSequence) {
        if (f() == null) {
            return;
        }
        if (FullscreenActivity.z() != null) {
            f().a(Html.fromHtml("<font color=\"" + FullscreenActivity.z().getActionBarTitleColor() + "\">" + charSequence + "</font>"));
            return;
        }
        f().a(Html.fromHtml("" + charSequence));
    }
}
