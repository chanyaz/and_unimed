package com.puzzlersworld.android.ui.a;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.ui.activity.CommentsActivity;
import com.puzzlersworld.android.ui.activity.util.a;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.Comment;
import com.puzzlersworld.wp.dto.CommentStatus;
import java.util.Date;

public class b {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    Context f;
    CommentsActivity g;
    RelativeLayout h;
    int i;
    int j;
    int k;
    int l = 3;
    CardView m;

    b(Context context) {
        this.f = context;
        this.l = FullscreenActivity.A().getMaxCommentsDepth().intValue();
    }

    public void a(int i) {
        this.i = i;
    }

    void a(final Comment comment) {
        CharSequence authorName = comment.getAuthorName();
        if (this.b != null) {
            if (authorName != null) {
                this.b.setText(authorName);
            } else {
                this.b.setText("");
            }
        }
        if (this.c != null) {
            if (comment.getDate() != null) {
                this.c.setText(a.a(new Date().getTime() - comment.getDate().getTime()));
            } else {
                this.c.setText("");
            }
        }
        if (comment.getContent() != null) {
            this.a.setText(w.d(comment.getContent()));
        } else {
            this.a.setText("");
        }
        this.d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.g.ae().setTag(comment);
                b.this.g.a();
            }
        });
        this.m.getLayoutParams().width = (int) (((double) this.k) * (1.0d - (0.05d * ((double) (comment.getLevel() - 1)))));
        if (comment.getLevel() > 1) {
            ((LayoutParams) this.m.getLayoutParams()).setMargins(15, 0, 15, 0);
        } else {
            ((LayoutParams) this.m.getLayoutParams()).setMargins(15, 15, 15, 0);
        }
        if (comment.getStatus() == CommentStatus.approved) {
            this.e.setVisibility(8);
            this.d.setVisibility(0);
        } else {
            this.e.setVisibility(0);
            this.d.setVisibility(8);
        }
        if (comment.getLevel() >= this.l) {
            this.d.setVisibility(8);
        }
    }

    public void b(int i) {
        this.j = i;
    }

    public void c(int i) {
        this.k = i;
    }
}
