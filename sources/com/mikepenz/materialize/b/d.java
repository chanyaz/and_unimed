package com.mikepenz.materialize.b;

import android.support.annotation.StringRes;
import android.widget.TextView;

public class d {
    private String a;
    private int b = -1;

    public d(@StringRes int i) {
        this.b = i;
    }

    public d(String str) {
        this.a = str;
    }

    public static void a(d dVar, TextView textView) {
        if (dVar != null && textView != null) {
            dVar.a(textView);
        }
    }

    public static boolean b(d dVar, TextView textView) {
        if (dVar != null && textView != null) {
            return dVar.b(textView);
        }
        if (textView == null) {
            return false;
        }
        textView.setVisibility(8);
        return false;
    }

    public void a(TextView textView) {
        if (this.a != null) {
            textView.setText(this.a);
        } else if (this.b != -1) {
            textView.setText(this.b);
        } else {
            textView.setText("");
        }
    }

    public boolean b(TextView textView) {
        if (this.a != null) {
            textView.setText(this.a);
            textView.setVisibility(0);
            return true;
        } else if (this.b != -1) {
            textView.setText(this.b);
            textView.setVisibility(0);
            return true;
        } else {
            textView.setVisibility(8);
            return false;
        }
    }

    public String toString() {
        return this.a;
    }
}
