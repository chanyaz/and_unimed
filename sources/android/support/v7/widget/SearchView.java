package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.k;
import android.support.v7.a.b;
import android.support.v7.a.e;
import android.support.v7.a.g;
import android.support.v7.a.h;
import android.support.v7.a.i;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final cp i = new cp();
    private OnQueryTextListener A;
    private OnCloseListener B;
    private OnSuggestionListener C;
    private OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, ConstantState> T;
    private final OnClickListener U;
    private final OnEditorActionListener V;
    private final OnItemClickListener W;
    final SearchAutoComplete a;
    private final OnItemSelectedListener aa;
    private TextWatcher ab;
    final ImageView b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    OnFocusChangeListener f;
    k g;
    SearchableInfo h;
    OnKeyListener j;
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private cq o;
    private Rect p;
    private Rect q;
    private int[] r;
    private int[] s;
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        final Runnable a;
        private int b;
        private SearchView c;
        private boolean d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, b.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.b = getThreshold();
        }

        private boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        private void b() {
            if (this.d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.d = false;
            }
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            return (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160 : 256;
        }

        private void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.d = true;
            }
        }

        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                removeCallbacks(this.a);
                post(this.a);
            }
            return onCreateInputConnection;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.c.g();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(getContext())) {
                    SearchView.i.a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new Rect();
        this.q = new Rect();
        this.r = new int[2];
        this.s = new int[2];
        this.R = new Runnable() {
            public void run() {
                SearchView.this.b();
            }
        };
        this.S = new Runnable() {
            public void run() {
                if (SearchView.this.g != null && (SearchView.this.g instanceof cv)) {
                    SearchView.this.g.changeCursor(null);
                }
            }
        };
        this.T = new WeakHashMap();
        this.U = new OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.b) {
                    SearchView.this.e();
                } else if (view == SearchView.this.d) {
                    SearchView.this.d();
                } else if (view == SearchView.this.c) {
                    SearchView.this.c();
                } else if (view == SearchView.this.e) {
                    SearchView.this.f();
                } else if (view == SearchView.this.a) {
                    SearchView.this.i();
                }
            }
        };
        this.j = new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.h == null) {
                    return false;
                }
                if (SearchView.this.a.isPopupShowing() && SearchView.this.a.getListSelection() != -1) {
                    return SearchView.this.a(view, i, keyEvent);
                }
                if (SearchView.this.a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.a(0, null, SearchView.this.a.getText().toString());
                return true;
            }
        };
        this.V = new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.c();
                return true;
            }
        };
        this.W = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.a(i, 0, null);
            }
        };
        this.aa = new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.a(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.ab = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.b(charSequence);
            }
        };
        db a = db.a(context, attributeSet, android.support.v7.a.k.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.g(android.support.v7.a.k.SearchView_layout, h.abc_search_view), this, true);
        this.a = (SearchAutoComplete) findViewById(g.search_src_text);
        this.a.setSearchView(this);
        this.k = findViewById(g.search_edit_frame);
        this.l = findViewById(g.search_plate);
        this.m = findViewById(g.submit_area);
        this.b = (ImageView) findViewById(g.search_button);
        this.c = (ImageView) findViewById(g.search_go_btn);
        this.d = (ImageView) findViewById(g.search_close_btn);
        this.e = (ImageView) findViewById(g.search_voice_btn);
        this.t = (ImageView) findViewById(g.search_mag_icon);
        ViewCompat.a(this.l, a.a(android.support.v7.a.k.SearchView_queryBackground));
        ViewCompat.a(this.m, a.a(android.support.v7.a.k.SearchView_submitBackground));
        this.b.setImageDrawable(a.a(android.support.v7.a.k.SearchView_searchIcon));
        this.c.setImageDrawable(a.a(android.support.v7.a.k.SearchView_goIcon));
        this.d.setImageDrawable(a.a(android.support.v7.a.k.SearchView_closeIcon));
        this.e.setImageDrawable(a.a(android.support.v7.a.k.SearchView_voiceIcon));
        this.t.setImageDrawable(a.a(android.support.v7.a.k.SearchView_searchIcon));
        this.u = a.a(android.support.v7.a.k.SearchView_searchHintIcon);
        de.a(this.b, getResources().getString(i.abc_searchview_description_search));
        this.v = a.g(android.support.v7.a.k.SearchView_suggestionRowLayout, h.abc_search_dropdown_item_icons_2line);
        this.w = a.g(android.support.v7.a.k.SearchView_commitIcon, 0);
        this.b.setOnClickListener(this.U);
        this.d.setOnClickListener(this.U);
        this.c.setOnClickListener(this.U);
        this.e.setOnClickListener(this.U);
        this.a.setOnClickListener(this.U);
        this.a.addTextChangedListener(this.ab);
        this.a.setOnEditorActionListener(this.V);
        this.a.setOnItemClickListener(this.W);
        this.a.setOnItemSelectedListener(this.aa);
        this.a.setOnKeyListener(this.j);
        this.a.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a.a(android.support.v7.a.k.SearchView_iconifiedByDefault, true));
        int e = a.e(android.support.v7.a.k.SearchView_android_maxWidth, -1);
        if (e != -1) {
            setMaxWidth(e);
        }
        this.z = a.c(android.support.v7.a.k.SearchView_defaultQueryHint);
        this.H = a.c(android.support.v7.a.k.SearchView_queryHint);
        e = a.a(android.support.v7.a.k.SearchView_android_imeOptions, -1);
        if (e != -1) {
            setImeOptions(e);
        }
        e = a.a(android.support.v7.a.k.SearchView_android_inputType, -1);
        if (e != -1) {
            setInputType(e);
        }
        setFocusable(a.a(android.support.v7.a.k.SearchView_android_focusable, true));
        a.a();
        this.x = new Intent("android.speech.action.WEB_SEARCH");
        this.x.addFlags(268435456);
        this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.y.addFlags(268435456);
        this.n = findViewById(this.a.getDropDownAnchor());
        if (this.n != null) {
            this.n.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.h();
                }
            });
        }
        a(this.E);
        p();
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent a(Cursor cursor, int i, String str) {
        try {
            String a = cv.a(cursor, "suggest_intent_action");
            if (a == null) {
                a = this.h.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = cv.a(cursor, "suggest_intent_data");
            if (a2 == null) {
                a2 = this.h.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = cv.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return a(a, a2 == null ? null : Uri.parse(a2), cv.a(cursor, "suggest_intent_extra_data"), cv.a(cursor, "suggest_intent_query"), i, str);
        } catch (Throwable e) {
            int position;
            Throwable th = e;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", th);
            return null;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.Q != null) {
            intent.putExtra("app_data", this.Q);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private void a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (Throwable e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        getLocationInWindow(this.s);
        int i = this.r[1] - this.s[1];
        int i2 = this.r[0] - this.s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private void a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.F = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.a.getText());
        this.b.setVisibility(i2);
        b(z3);
        this.k.setVisibility(z ? 8 : 0);
        if (!(this.t.getDrawable() == null || this.E)) {
            i = 0;
        }
        this.t.setVisibility(i);
        n();
        if (z3) {
            z2 = false;
        }
        c(z2);
        m();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        String str = null;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Parcelable activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.Q != null) {
            bundle.putParcelable("app_data", this.Q);
        }
        Intent intent3 = new Intent(intent);
        String str2 = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str2 = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str2);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        str2 = "calling_package";
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra(str2, str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private void b(boolean z) {
        int i = 8;
        if (this.G && l() && hasFocus() && (z || !this.L)) {
            i = 0;
        }
        this.c.setVisibility(i);
    }

    private boolean b(int i, int i2, String str) {
        Cursor cursor = this.g.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        a(a(cursor, i2, str));
        return true;
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.E || this.u == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.a.getTextSize()) * 1.25d);
        this.u.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void c(boolean z) {
        int i;
        if (this.L && !a() && z) {
            i = 0;
            this.c.setVisibility(8);
        } else {
            i = 8;
        }
        this.e.setVisibility(i);
    }

    private void e(int i) {
        CharSequence text = this.a.getText();
        Cursor cursor = this.g.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.g.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(e.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(e.abc_search_view_preferred_width);
    }

    private boolean k() {
        if (this.h == null || !this.h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
            intent = this.x;
        } else if (this.h.getVoiceSearchLaunchRecognizer()) {
            intent = this.y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean l() {
        return (this.G || this.L) && !a();
    }

    private void m() {
        int i = 8;
        if (l() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) {
            i = 0;
        }
        this.m.setVisibility(i);
    }

    private void n() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.a.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.E || this.O)) {
            i = 0;
        }
        ImageView imageView = this.d;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.d.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void o() {
        post(this.R);
    }

    private void p() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void q() {
        int i = 1;
        this.a.setThreshold(this.h.getSuggestThreshold());
        this.a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.a.setInputType(inputType);
        if (this.g != null) {
            this.g.changeCursor(null);
        }
        if (this.h.getSuggestAuthority() != null) {
            this.g = new cv(getContext(), this, this.h, this.T);
            this.a.setAdapter(this.g);
            cv cvVar = (cv) this.g;
            if (this.I) {
                i = 2;
            }
            cvVar.a(i);
        }
    }

    private void r() {
        this.a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.a.setText(charSequence);
        this.a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z) {
        this.a.setText(charSequence);
        if (charSequence != null) {
            this.a.setSelection(this.a.length());
            this.N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            c();
        }
    }

    public boolean a() {
        return this.F;
    }

    boolean a(int i) {
        if (this.C != null && this.C.onSuggestionSelect(i)) {
            return false;
        }
        e(i);
        return true;
    }

    boolean a(int i, int i2, String str) {
        if (this.C != null && this.C.onSuggestionClick(i)) {
            return false;
        }
        b(i, 0, null);
        this.a.setImeVisibility(false);
        r();
        return true;
    }

    boolean a(View view, int i, KeyEvent keyEvent) {
        if (this.h == null || this.g == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return a(this.a.getListSelection(), 0, null);
        }
        if (i == 21 || i == 22) {
            this.a.setSelection(i == 21 ? 0 : this.a.length());
            this.a.setListSelection(0);
            this.a.clearListSelection();
            i.a(this.a, true);
            return true;
        }
        if (!(i == 19 && this.a.getListSelection() == 0)) {
        }
        return false;
    }

    void b() {
        int[] iArr = this.a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = this.m.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        invalidate();
    }

    void b(CharSequence charSequence) {
        boolean z = true;
        CharSequence text = this.a.getText();
        this.N = text;
        boolean z2 = !TextUtils.isEmpty(text);
        b(z2);
        if (z2) {
            z = false;
        }
        c(z);
        n();
        m();
        if (!(this.A == null || TextUtils.equals(charSequence, this.M))) {
            this.A.onQueryTextChange(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    void c() {
        CharSequence text = this.a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.A == null || !this.A.onQueryTextSubmit(text.toString())) {
                if (this.h != null) {
                    a(0, null, text.toString());
                }
                this.a.setImeVisibility(false);
                r();
            }
        }
    }

    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.a.clearFocus();
        this.a.setImeVisibility(false);
        this.J = false;
    }

    void d() {
        if (!TextUtils.isEmpty(this.a.getText())) {
            this.a.setText("");
            this.a.requestFocus();
            this.a.setImeVisibility(true);
        } else if (!this.E) {
        } else {
            if (this.B == null || !this.B.onClose()) {
                clearFocus();
                a(true);
            }
        }
    }

    void e() {
        a(false);
        this.a.requestFocus();
        this.a.setImeVisibility(true);
        if (this.D != null) {
            this.D.onClick(this);
        }
    }

    void f() {
        if (this.h != null) {
            SearchableInfo searchableInfo = this.h;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(a(this.x, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(b(this.y, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void g() {
        a(a());
        o();
        if (this.a.hasFocus()) {
            i();
        }
    }

    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public int getMaxWidth() {
        return this.K;
    }

    public CharSequence getQuery() {
        return this.a.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        return this.H != null ? this.H : (this.h == null || this.h.getHintId() == 0) ? this.z : getContext().getText(this.h.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.w;
    }

    int getSuggestionRowLayout() {
        return this.v;
    }

    public k getSuggestionsAdapter() {
        return this.g;
    }

    void h() {
        if (this.n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = dk.a(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(e.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(e.abc_dropdownitem_icon_width) : 0;
            this.a.getDropDownBackground().getPadding(rect);
            this.a.setDropDownHorizontalOffset(a ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.a.setDropDownWidth((dimensionPixelSize + ((this.n.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    void i() {
        i.a(this.a);
        i.b(this.a);
    }

    public void onActionViewCollapsed() {
        a((CharSequence) "", false);
        clearFocus();
        a(true);
        this.a.setImeOptions(this.P);
        this.O = false;
    }

    public void onActionViewExpanded() {
        if (!this.O) {
            this.O = true;
            this.P = this.a.getImeOptions();
            this.a.setImeOptions(this.P | 33554432);
            this.a.setText("");
            setIconified(false);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.a, this.p);
            this.q.set(this.p.left, 0, this.p.right, i4 - i2);
            if (this.o == null) {
                this.o = new cq(this.q, this.p, this.a);
                setTouchDelegate(this.o);
                return;
            }
            this.o.a(this.q, this.p);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (a()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.K <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.K, size);
                    break;
                }
            case 0:
                if (this.K <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.K;
                    break;
                }
            case 1073741824:
                if (this.K > 0) {
                    size = Math.min(this.K, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                mode = Math.min(getPreferredHeight(), mode);
                break;
            case 0:
                mode = getPreferredHeight();
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            a(savedState.a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = a();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        o();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.J || !isFocusable()) {
            return false;
        }
        if (a()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.a.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            d();
        } else {
            e();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.E != z) {
            this.E = z;
            a(z);
            p();
        }
    }

    public void setImeOptions(int i) {
        this.a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.K = i;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.B = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.A = onQueryTextListener;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.C = onSuggestionListener;
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.H = charSequence;
        p();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.I = z;
        if (this.g instanceof cv) {
            ((cv) this.g).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (this.h != null) {
            q();
            p();
        }
        this.L = k();
        if (this.L) {
            this.a.setPrivateImeOptions("nm");
        }
        a(a());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.G = z;
        a(a());
    }

    public void setSuggestionsAdapter(k kVar) {
        this.g = kVar;
        this.a.setAdapter(this.g);
    }
}
