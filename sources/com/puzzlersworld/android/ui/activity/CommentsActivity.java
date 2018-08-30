package com.puzzlersworld.android.ui.activity;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinAppModule;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.exception.UiErrorHandler;
import com.puzzlersworld.android.exception.a;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.util.EditTextBackEvent;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.EditTextImeBackListener;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.Comment;
import com.puzzlersworld.wp.dto.CommentObject;
import com.puzzlersworld.wp.dto.CommentStatus;
import com.puzzlersworld.wp.dto.CommentType;
import com.puzzlersworld.wp.dto.CreateCommentRequest;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.StringConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class CommentsActivity extends Fragment implements UiErrorHandler, AndroAppFragment, EditTextImeBackListener {
    FrameLayout a;
    private WebView ae;
    private WebView af;
    private ListView ag;
    private d ah;
    private EditText ai;
    private EditText aj;
    private LinearLayout ak;
    private LinearLayout al;
    private View am;
    private View an;
    private TextView ao;
    private TextView ap;
    private boolean aq = false;
    private String ar = null;
    private Long as = null;
    private a at = new a(this);
    ProgressBar b;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService c;
    @ForUi
    @Inject
    ListeningExecutorService d;
    @Inject
    com.puzzlersworld.wp.controller.a e;
    @Inject
    SoundPool f;
    @Inject
    RestServiceManager g;
    private CommentObject h;
    private Post i;

    private int a(List<Comment> list, Comment comment) {
        if (comment.getParent().longValue() == 0) {
            list.add(comment);
            return list.size();
        }
        int i = 0;
        for (Comment comment2 : list) {
            if (comment2.getID() == comment.getParent()) {
                comment.setLevel(comment2.getLevel() + 1);
                list.add(i + 1, comment);
                return this.ah.a((Object) comment);
            }
            i++;
        }
        list.add(0, comment);
        return this.ah.a((Object) comment);
    }

    private View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.facebook_comments, viewGroup, false);
        this.a = (FrameLayout) inflate.findViewById(R.id.webview_frame);
        this.b = (ProgressBar) inflate.findViewById(R.id.progressbar);
        this.af = (WebView) inflate.findViewById(R.id.commentsView);
        a(true);
        af();
        return inflate;
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            Log.d("AndroApp:", "Saved instance is null");
        } else if (this.h != null || this.i != null) {
        } else {
            if (bundle.getSerializable("commentObject") != null) {
                this.h = (CommentObject) bundle.getSerializable("commentObject");
            } else if (bundle.getSerializable("post") != null) {
                this.i = (Post) bundle.getSerializable("post");
            }
        }
    }

    private void a(List<Comment> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Comment) it.next()).getStatus() != CommentStatus.approved) {
                it.remove();
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    private void af() {
        this.af.setWebViewClient(new c(this, null));
        this.af.setWebChromeClient(new b(this));
        this.af.getSettings().setJavaScriptEnabled(true);
        this.af.getSettings().setAppCacheEnabled(true);
        this.af.getSettings().setDomStorageEnabled(true);
        this.af.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.af.getSettings().setSupportMultipleWindows(true);
        this.af.getSettings().setSupportZoom(false);
        this.af.getSettings().setBuiltInZoomControls(false);
        CookieManager.getInstance().setAcceptCookie(true);
        if (VERSION.SDK_INT >= 21) {
            this.af.getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.af, true);
        }
        String b = w.b(this.i);
        a(true);
        this.af.loadDataWithBaseURL("http://www.nothing.com", b, "text/html", "UTF-8", null);
        this.af.setMinimumHeight(200);
    }

    private void ag() {
        Handler handler = new Handler();
        final int lastVisiblePosition = this.ag.getLastVisiblePosition();
        handler.postDelayed(new Runnable() {
            public void run() {
                CommentsActivity.this.ag.setSelection(lastVisiblePosition);
            }
        }, 400);
    }

    private void ah() {
        startActivityForResult(new Intent(getLifecycleActivity().getApplicationContext(), CommentSettingsActivity.class), 12424);
    }

    private void ai() {
        this.am = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.feed_loading, null);
        this.ag.addFooterView(this.am);
        this.am.setVisibility(4);
        this.an = this.am.findViewById(R.id.retryLayout);
        this.an.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentsActivity.this.b(view);
            }
        });
        this.an.setVisibility(8);
        this.ao = (TextView) this.am.findViewById(R.id.loading);
        this.ao.setText(StringConstants.LOADING.getMessage());
        this.ao.setVisibility(8);
        this.ap = (TextView) this.am.findViewById(R.id.retry);
    }

    private void aj() {
        this.am.setVisibility(0);
        this.ao.setVisibility(0);
    }

    private View b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.activity_comments, viewGroup, false);
        this.ag = (ListView) inflate.findViewById(R.id.FeedsList);
        b(new ArrayList());
        ai();
        aj();
        this.c.execute(new Runnable() {
            public void run() {
                try {
                    CommentsActivity.this.d(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    FriopinApplication.a().a(e);
                }
            }
        });
        this.al = (LinearLayout) inflate.findViewById(R.id.addCommentLayout);
        this.ak = (LinearLayout) inflate.findViewById(R.id.hiddenaddCommentLayout);
        this.ai = (EditText) inflate.findViewById(R.id.commentBox);
        this.aj = (EditText) inflate.findViewById(R.id.hiddencommentBox);
        this.aj.setHint(StringConstants.TYPE_REPLY_MESSAGE.getMessage());
        this.ai.setHint(StringConstants.TYPE_MESSAGE.getMessage());
        this.ai.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    CommentsActivity.this.ag();
                }
            }
        });
        this.ai.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentsActivity.this.ag();
            }
        });
        ((EditTextBackEvent) this.aj).setOnEditTextImeBackListener(this);
        ((ImageView) inflate.findViewById(R.id.sendComment)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentsActivity.this.ad();
            }
        });
        ((ImageView) inflate.findViewById(R.id.hiddensendComment)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentsActivity.this.ac();
            }
        });
        return inflate;
    }

    private void b(final String str) {
        this.d.execute(new Runnable() {
            public void run() {
                CommentsActivity.this.ap.setText(str + "\n " + StringConstants.RETRY.getMessage());
                CommentsActivity.this.an.setVisibility(0);
                CommentsActivity.this.ao.setVisibility(8);
            }
        });
    }

    private void b(List<Comment> list) {
        this.ah = new d(list, getLifecycleActivity(), this.c, this, null);
        this.d.execute(new Runnable() {
            public void run() {
                CommentsActivity.this.ag.setAdapter(CommentsActivity.this.ah);
            }
        });
    }

    private void d(int i) {
        try {
            List list = (List) (this.g.getNamespace().equals("wp-json/") ? this.g.getWpCoreService().fetchComments(this.h.getID()) : this.g.getWpCoreService().fetchCommentsV2(this.h.getID())).execute().b();
            a(list);
            list = com.puzzlersworld.wp.a.a.a(list);
            this.d.execute(new Runnable() {
                public void run() {
                    CommentsActivity.this.am.setVisibility(4);
                    CommentsActivity.this.ah.a(list);
                    if (list.size() == 0) {
                        w.b(StringConstants.NO_COMMENTS.getMessage(), CommentsActivity.this.getLifecycleActivity());
                    }
                }
            });
        } catch (Exception e) {
            Log.d("FeedActivity", "Retrofit error");
            e.printStackTrace();
            this.at.a(e);
            FriopinApplication.a().a(e);
        }
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InjectibleApplication.a((Fragment) this);
        ((FullscreenActivity) getLifecycleActivity()).n();
        return this.i != null ? a(layoutInflater, viewGroup) : b(layoutInflater, viewGroup);
    }

    public void a() {
        Object obj = (Comment) this.aj.getTag();
        this.ak.setVisibility(0);
        this.al.setVisibility(4);
        this.aj.requestFocusFromTouch();
        ((InputMethodManager) getLifecycleActivity().getSystemService("input_method")).showSoftInput(this.aj, 0);
        this.ag.setSelection(this.ah.a(obj));
    }

    public void a(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        if (this.h != null) {
            menuInflater.inflate(R.menu.comment_activity_menu, menu);
        }
        super.a(menu, menuInflater);
    }

    public void a(CommentObject commentObject) {
        this.h = commentObject;
    }

    public void a(CreateCommentRequest createCommentRequest, Comment comment) {
        Comment comment2 = new Comment();
        comment2.setID(comment.getID());
        comment2.setStatus(comment.getStatus());
        comment2.setContent(createCommentRequest.getContent());
        comment2.setDate(new Date());
        comment2.setType(CommentType.comment);
        comment2.setParent(createCommentRequest.getParent());
        comment2.setAuthorName(createCommentRequest.getAuthor());
        int a = a(this.ah.b(), comment2);
        this.ah.notifyDataSetInvalidated();
        w.a(this.f, FriopinAppModule.SELECT_SOUND_ID);
        this.ag.setSelection(a);
        w.a(getLifecycleActivity());
        this.aj.setText("");
        this.aj.clearFocus();
        this.ak.setVisibility(8);
        this.ai.setText("");
    }

    public void a(Post post) {
        this.i = post;
    }

    public void a(String str, final Long l, boolean z) {
        if (str.isEmpty()) {
            w.a(StringConstants.COMMENT_EMPTY.getMessage(), getLifecycleActivity());
        } else if (FullscreenActivity.D != null && !FullscreenActivity.D.isEmpty()) {
            w.b(StringConstants.SENDING_COMMENT.getMessage(), getLifecycleActivity());
            final CreateCommentRequest createCommentRequest = new CreateCommentRequest(FullscreenActivity.D, FullscreenActivity.E, "http://", str, l);
            this.g.getWpApiService().addCommentNew(this.h.getID(), createCommentRequest).enqueue(new Callback<Comment>() {
                public void onFailure(Call<Comment> call, Throwable th) {
                    Log.d("ERROR", th.getMessage());
                    w.a(StringConstants.UNKNOWN_ERROR.getMessage(), CommentsActivity.this.getLifecycleActivity());
                }

                public void onResponse(Call<Comment> call, ai<Comment> aiVar) {
                    final Comment comment = (Comment) aiVar.b();
                    if (comment != null) {
                        CommentsActivity.this.d.execute(new Runnable() {
                            public void run() {
                                CommentsActivity.this.a(createCommentRequest, comment);
                            }
                        });
                        FriopinApplication.a().a("Comment", l.longValue() == 0 ? "New Comment" : "Reply", null);
                        return;
                    }
                    w.a(CommentsActivity.this.getLifecycleActivity(), (ai) aiVar);
                }
            });
        } else if (z) {
            this.aq = true;
            this.ar = str;
            this.as = l;
            ah();
        } else {
            w.a(StringConstants.PROVIDE_EMAIL.getMessage(), getLifecycleActivity());
        }
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.comment_settings) {
            return false;
        }
        this.aq = false;
        ah();
        return true;
    }

    public void ac() {
        a(this.aj.getText().toString(), ((Comment) this.aj.getTag()).getID(), true);
    }

    public void ad() {
        a(this.ai.getText().toString(), Long.valueOf(0), true);
    }

    public EditText ae() {
        return this.aj;
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        a(bundle);
        d(true);
    }

    public void b(View view) {
        this.an.setVisibility(8);
        this.ao.setVisibility(0);
        aj();
        this.c.execute(new Runnable() {
            public void run() {
                try {
                    CommentsActivity.this.d(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    FriopinApplication.a().a(e);
                }
            }
        });
    }

    public void d(Bundle bundle) {
        Log.d("AndroApp:", "OnActivityCreated called");
        super.d(bundle);
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        }
    }

    public void e(Bundle bundle) {
        Log.d("AndroApp:", "Feed Activity OnSaveInstance called");
        super.e(bundle);
        if (this.h != null) {
            bundle.putSerializable("commentObject", this.h);
        }
        if (this.i != null) {
            bundle.putSerializable("post", this.i);
        }
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.COMMENTS_ACTIVITY;
    }

    public String getTitle() {
        return StringConstants.COMMENTS_TITLE.getMessage();
    }

    public Object getTriggerObject() {
        return this.h;
    }

    public void onConnectionTimeout() {
        b(StringConstants.CONNECTION_TIMEOUT.getMessage());
    }

    public void onError(Exception exception) {
        b(StringConstants.UNKNOWN_ERROR.getMessage());
    }

    public void onImeBack(EditTextBackEvent editTextBackEvent, String str) {
        this.ak.setVisibility(8);
        this.al.setVisibility(0);
    }

    public void onNoNetwork() {
        b(StringConstants.CANT_CONNECT.getMessage());
    }

    public void t() {
        super.t();
        if (this.aq) {
            this.aq = false;
            a(this.ar, this.as, false);
        }
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        }
        FriopinApplication.a().a("comments screen");
    }
}
