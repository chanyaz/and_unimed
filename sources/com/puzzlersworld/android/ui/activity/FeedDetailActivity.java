package com.puzzlersworld.android.ui.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.style.StrikethroughSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.common.base.ab;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.data.c;
import com.puzzlersworld.android.exception.UiErrorHandler;
import com.puzzlersworld.android.exception.a;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.ui.activity.util.VideoEnabledWebChromeClient;
import com.puzzlersworld.android.util.AddToCartListener;
import com.puzzlersworld.android.util.FileSave;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.a.f;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.AdLocation;
import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CartItem;
import com.puzzlersworld.wp.dto.Category;
import com.puzzlersworld.wp.dto.CommentObject;
import com.puzzlersworld.wp.dto.CommentObjectType;
import com.puzzlersworld.wp.dto.Menu;
import com.puzzlersworld.wp.dto.MenuItemType;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.PostCommentStatus;
import com.puzzlersworld.wp.dto.PostContentType;
import com.puzzlersworld.wp.dto.Product;
import com.puzzlersworld.wp.dto.ProductAttribute;
import com.puzzlersworld.wp.dto.ProductType;
import com.puzzlersworld.wp.dto.StringConstants;
import com.puzzlersworld.wp.dto.Term;
import com.puzzlersworld.wp.dto.ThemeColors;
import com.puzzlersworld.wp.dto.Variation;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.ai;

public class FeedDetailActivity extends Fragment implements OnRefreshListener, ObservableScrollViewCallbacks, UiErrorHandler, AndroAppFragment, AddToCartListener {
    private static final StrikethroughSpan az = new StrikethroughSpan();
    FrameLayout a;
    private a aA;
    private OnScrollChangedListener aB = null;
    private Post aC = null;
    private String aD = null;
    private WebView aE = null;
    private View aF = null;
    private ViewPagerFragement aG;
    private int aH = 0;
    private View aI = null;
    private ImageView aJ;
    private ValueCallback<Uri> aK;
    private ValueCallback<Uri[]> aL;
    private WebView aM;
    ScrollView ae;
    LinearLayout af = null;
    Button ag = null;
    EditText ah = null;
    Integer ai = null;
    private ImageView aj;
    private View ak;
    private View al;
    private boolean am = false;
    private ObservableScrollView an;
    private FrameLayout ao;
    private FloatingActionButton ap;
    private TextView aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private String av = null;
    private SwipeRefreshLayout aw;
    private boolean ax = false;
    private Menu ay;
    @Inject
    c b;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService c;
    @ForUi
    @Inject
    ListeningExecutorService d;
    @Inject
    com.puzzlersworld.wp.controller.a e;
    @Inject
    b f;
    @Inject
    RestServiceManager g;
    @Inject
    FileSave h;
    View i;

    public FeedDetailActivity() {
        Log.d("AndroApp:", "FeedDetailActivity Default Constructor called");
        this.aA = new a(this);
    }

    private View a(String str, String str2) {
        if (str2 == null || str == null || str2.isEmpty() || str.isEmpty()) {
            return null;
        }
        View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.product_meta, null);
        TextView textView = (TextView) inflate.findViewById(R.id.descriptionTitle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.description);
        inflate.findViewById(R.id.descriptionView);
        textView.setText(w.d(str));
        textView2.setText(w.d(str2));
        return inflate;
    }

    private String a(List<ProductAttribute> list) {
        String str = "";
        for (ProductAttribute productAttribute : list) {
            if (!str.isEmpty()) {
                str = str + ", ";
            }
            str = str + productAttribute.getOption();
        }
        return str;
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            Log.d("AndroApp:", "Saved instance is null");
        } else if (this.aC == null && this.aD == null) {
            if (bundle.getSerializable("url") != null) {
                this.aD = (String) bundle.getSerializable("url");
            } else if (bundle.getSerializable("post") != null) {
                this.aC = (Post) bundle.getSerializable("post");
            }
            this.ax = ((Boolean) bundle.getSerializable("fetchURL")).booleanValue();
        }
    }

    private void a(WebView webView, String str) {
        c(null);
        this.i.setVisibility(0);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setWebViewClient(new f(this, null));
        webView.setWebChromeClient(new e(this, null));
        webView.loadUrl(f.a(str, "androapp=true"));
        webView.setMinimumHeight(200);
    }

    private void a(Object obj) {
        boolean z = false;
        this.ax = false;
        FullscreenActivity fullscreenActivity;
        if (obj instanceof Post) {
            boolean z2;
            Post post = (Post) obj;
            if (post.getID() == null || post.getID().longValue() == -1) {
                z2 = false;
            } else {
                this.aC = post;
                if (this.aG != null) {
                    List arrayList = new ArrayList();
                    arrayList.add(this.aC);
                    this.aG.b(arrayList);
                }
                this.aD = null;
                if (this.aC.getPostContentType() == null && ab.a(this.aC.getTitle())) {
                    this.aC.setTitle(this.aC.getLink());
                }
                if (this.aC.getPostContentType() == PostContentType.loadimages) {
                    fullscreenActivity = (FullscreenActivity) getLifecycleActivity();
                    fullscreenActivity.u();
                    fullscreenActivity.a(this.aC, null);
                    z2 = true;
                } else {
                    ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
                    ar();
                    ad();
                    b(this.aF);
                    z2 = true;
                }
            }
            z = z2;
        } else if ((obj instanceof Menu) && ((Menu) obj).getObjectId() != null) {
            fullscreenActivity = (FullscreenActivity) getLifecycleActivity();
            fullscreenActivity.u();
            fullscreenActivity.a((Menu) obj, -1);
            z = true;
        }
        if (!z) {
            b(this.aF);
        }
    }

    private boolean aj() {
        return this.aC != null ? ((this.aC.getCommentStatus() != null && this.aC.getCommentStatus() != PostCommentStatus.open) || FullscreenActivity.A() == null || FullscreenActivity.A().getCommentsProvider() == null || FullscreenActivity.A().getCommentsProvider().equals("disabled")) ? false : true : false;
    }

    private String ak() {
        return (this.aC == null || FullscreenActivity.A().isShowCommentsCount() == null || FullscreenActivity.A().isShowCommentsCount().intValue() != 1) ? "" : this.aC.getCommentsCount() == null ? "0" : "" + this.aC.getCommentsCount();
    }

    private void al() {
        if (aj()) {
            this.a.setVisibility(0);
            this.aq.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.aq.setVisibility(8);
    }

    private void am() {
        if (this.ap != null && FullscreenActivity.z() != null) {
            this.ap.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(FullscreenActivity.z().getActionBarBgColor())));
            this.aq.setTextColor(Color.parseColor(FullscreenActivity.z().getActionBarTitleColor()));
        }
    }

    private void an() {
        this.ap.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedDetailActivity.this.e((int) R.id.comments_notifcation_count);
            }
        });
        this.aq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedDetailActivity.this.e((int) R.id.comments_notifcation_count);
            }
        });
    }

    private void ao() {
        ((FullscreenActivity) getLifecycleActivity()).a(this.aC, this.aC.getFeaturedImage());
    }

    private void ap() {
        try {
            String str = (String) this.ag.getTag();
            com.puzzlersworld.android.util.b.a(getLifecycleActivity(), this.f, this.g.getCartService(), str, Integer.valueOf(Integer.valueOf(this.ah.getText().toString()).intValue()), this);
        } catch (NumberFormatException e) {
            w.a(this.d, StringConstants.ADDED_TO_CART.getMessage(), getLifecycleActivity());
        }
    }

    private void aq() {
        ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        getLifecycleActivity().invalidateOptionsMenu();
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).n();
        }
        ActionBar f = ((FullscreenActivity) getLifecycleActivity()).f();
        ThemeColors z = FullscreenActivity.z();
        if (z != null) {
            f.a(new ColorDrawable(com.github.ksoichiro.android.observablescrollview.c.a(0.0f, Color.parseColor(z.getActionBarBgColor()))));
            if (VERSION.SDK_INT >= 21 && z.getStatusBarBgColor() != null) {
                Window window = getLifecycleActivity().getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(Color.parseColor("#000000"));
            }
        }
    }

    private void ar() {
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
        }
        if (this.aC == null) {
            if (getLifecycleActivity() != null && ((FullscreenActivity) getLifecycleActivity()).f() != null) {
                ((FullscreenActivity) getLifecycleActivity()).b(false);
            }
        } else if (getLifecycleActivity() != null && ((FullscreenActivity) getLifecycleActivity()).f() != null) {
            ((FullscreenActivity) getLifecycleActivity()).b(false);
        }
    }

    private String b(Post post) {
        String str;
        String str2 = null;
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("<h1 class='androapptitle' >" + post.getTitle() + "</h1>");
        ThemeColors z = FullscreenActivity.z();
        if (post.getAuthor() != null) {
            stringBuffer.append("<span class='androappauthor'>");
            String name = post.getAuthor().getName();
            stringBuffer.append(StringConstants.BY.getMessage() + " <a href='" + getLifecycleActivity().getString(R.string.wp_server_base_path) + "/" + FullscreenActivity.q + "/" + post.getAuthor().getSlug() + "' ><font color='" + (z == null ? "" : z.getAuthorTextColor()) + "' >");
            stringBuffer.append(name);
            stringBuffer.append("</font></a>");
            stringBuffer.append("</span>");
            str = name;
        } else {
            str = null;
        }
        if (post.getDate() != null) {
            stringBuffer.append("<span class='androapptimeago'>");
            if (str != null) {
                stringBuffer.append(" - ");
            }
            stringBuffer.append("<font color='" + (z == null ? "" : z.getTimeTextColor()) + "' >");
            stringBuffer.append(com.puzzlersworld.android.ui.activity.util.a.a(new Date().getTime() - post.getDate().getTime()));
            stringBuffer.append("</font>");
            stringBuffer.append("</span>");
        }
        if (post.getTerms() != null) {
            if (post.getTerms().getCategories() == null || post.getTerms().getCategories().size() <= 0) {
                Term a = w.a(post.getTerms());
                if (a != null) {
                    str2 = a.getName();
                    str = getLifecycleActivity().getString(R.string.wp_server_base_path) + "/" + a.getTaxonomy() + "/" + a.getSlug();
                } else {
                    str = null;
                }
            } else {
                str2 = ((Category) post.getTerms().getCategories().get(0)).getName();
                str = getLifecycleActivity().getString(R.string.wp_server_base_path) + "/" + FullscreenActivity.p + "/" + ((Category) post.getTerms().getCategories().get(0)).getSlug();
            }
            if (str2 != null) {
                stringBuffer.append("<span class='androappcategory'>");
                stringBuffer.append(" " + StringConstants.IN.getMessage() + " <a href='" + str + "' ><font color='" + (z == null ? "" : z.getTagTextColor()) + "' >");
                stringBuffer.append(str2);
                stringBuffer.append("</font></a>");
                stringBuffer.append("</span>");
            }
        }
        return stringBuffer.toString();
    }

    private String b(Product product) {
        String str = "";
        for (ProductAttribute productAttribute : product.getAttributes()) {
            if (!str.isEmpty()) {
                str = str + " & ";
            }
            str = str + productAttribute.getName();
        }
        return str;
    }

    private void b(View view) {
        al();
        this.aE = (WebView) view.findViewById(R.id.content);
        if (this.ax) {
            d(this.aD);
        } else if (this.ay != null) {
            ac();
        } else if (this.aC != null) {
            try {
                if (this.aC.getPostContentType() == null || this.aC.getPostContentType() == PostContentType.loadurl || this.aC.getFailoverPostContentType() == PostContentType.loadurl) {
                    a(this.aE, this.aC.getLink());
                    Log.d("AndroApp", "Load url " + this.aC.getLink());
                    return;
                }
                this.i.setVisibility(8);
                if (this.aC instanceof Product) {
                    c(null);
                    View d = d((Product) this.aC);
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ContentLinearLayout);
                    View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.emptyspace, null);
                    linearLayout.removeAllViews();
                    linearLayout.addView(inflate);
                    linearLayout.addView(d);
                    ((LinearLayout) view.findViewById(R.id.feedTopLayout)).addView(c((Product) this.aC));
                    Log.d("ANDROAPP", "Added product view");
                    return;
                }
                FullscreenActivity fullscreenActivity = (FullscreenActivity) getLifecycleActivity();
                this.aE.getSettings().setJavaScriptEnabled(true);
                this.aE.getSettings().setDomStorageEnabled(true);
                this.aE.getSettings().setDatabaseEnabled(true);
                VideoEnabledWebChromeClient videoEnabledWebChromeClient = new VideoEnabledWebChromeClient(fullscreenActivity.w(), fullscreenActivity.v(), fullscreenActivity, this);
                videoEnabledWebChromeClient.a(fullscreenActivity);
                this.aE.setBackgroundColor(0);
                this.aE.setWebChromeClient(videoEnabledWebChromeClient);
                this.aE.setWebViewClient(new f(this, null));
                this.aE.addJavascriptInterface(new d(this), "androImageClick");
                fullscreenActivity.a(videoEnabledWebChromeClient);
                fullscreenActivity.a(this.aE);
                String source = (this.aC.getFeaturedImageObject() == null || !(this.aC.getFeatured_image_showhide() == null || this.aC.getFeatured_image_showhide().equals("show"))) ? null : this.aC.getFeaturedImageObject().getSource();
                c(source);
                this.aE.loadDataWithBaseURL(this.aC.getLink(), ("<html dir=\"auto\" ><head><meta name=viewport content=target-densitydpi=medium-dpi, width=device-width/>" + w.b() + w.c(this.aC) + "</head><body>") + w.e() + (source == null ? w.a(this.aC) : "") + b(this.aC) + w.g() + w.g(this.aC.getContent()) + w.f() + w.b(FullscreenActivity.A()) + "</body></html>", "text/html", "utf-8", "");
            } catch (Exception e) {
                Toast.makeText(getLifecycleActivity().getApplicationContext(), StringConstants.UNKNOWN_ERROR.getMessage(), 0);
            }
        } else if (this.aD != null) {
            Uri parse = Uri.parse(a((int) R.string.wp_server_base_path));
            Uri parse2 = Uri.parse(this.aD);
            if (parse2.getHost().equals(parse.getHost()) || ((FullscreenActivity) getLifecycleActivity()).a(parse2, this.aD)) {
                a(this.aE, this.aD);
                return;
            }
            a(new Intent("android.intent.action.VIEW", Uri.parse(this.aD)));
            getLifecycleActivity().e().c();
        }
    }

    private boolean b(WebView webView, String str) {
        if (w.a(getLifecycleActivity(), str)) {
            webView.reload();
            return true;
        }
        Uri parse = Uri.parse(str);
        try {
            Uri parse2 = Uri.parse(a((int) R.string.wp_server_base_path));
            Log.d("FeedDetailActivity", "Host '" + parse.getHost() + "' '" + a((int) R.string.wp_server_base_path));
            if (parse.getHost() == null || (parse.getHost().equals(parse2.getHost()) && ((FullscreenActivity) getLifecycleActivity()).a(str))) {
                w.a(this.e, str);
                return true;
            } else if (parse.getHost().equals(parse2.getHost()) || !((FullscreenActivity) getLifecycleActivity()).a(parse, str)) {
                a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (this.aC == null) {
                this.aD = str;
                ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
                return false;
            } else {
                w.a(this.e, str);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private View c(final Product product) {
        View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.product_buy_now, null);
        this.ag = (Button) inflate.findViewById(R.id.buynow);
        this.ag.setBackgroundColor(Color.parseColor(FullscreenActivity.z().getActionBarBgColor()));
        this.ag.setTextColor(Color.parseColor(FullscreenActivity.z().getActionBarTitleColor()));
        if (VERSION.SDK_INT >= 21) {
            this.ag.setElevation(2.0f);
        }
        if (product.getType() != ProductType.external || w.f(product.getProduct_url())) {
            this.ag.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (product.getVariations() == null || product.getVariations().size() <= 0) {
                        com.puzzlersworld.android.util.b.a(FeedDetailActivity.this.getLifecycleActivity(), FeedDetailActivity.this.f, FeedDetailActivity.this.g.getCartService(), product.getId(), null, null, FeedDetailActivity.this);
                        return;
                    }
                    FeedDetailActivity.this.a(product);
                }
            });
        } else {
            this.ag.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    d.a(FeedDetailActivity.this.getLifecycleActivity().getApplicationContext(), product.getProduct_url(), false);
                }
            });
        }
        if (!product.isInStock()) {
            this.ag.setEnabled(false);
            this.ag.setText(StringConstants.OUT_OF_STOCK.getMessage());
        } else if (w.f(product.getButton_text())) {
            this.ag.setText(StringConstants.BUY_NOW.getMessage());
        } else {
            this.ag.setText(product.getButton_text());
        }
        if (!(FullscreenActivity.E() == null || FullscreenActivity.E().getW() == null || FullscreenActivity.E().getW().booleanValue())) {
            this.ag.setEnabled(false);
            this.ag.setText(StringConstants.OUT_OF_STOCK.getMessage());
        }
        this.af = (LinearLayout) inflate.findViewById(R.id.quantitylinearlayout);
        this.af.setVisibility(0);
        this.ah = (EditText) inflate.findViewById(R.id.quantity);
        this.ah.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                FeedDetailActivity.this.ap();
                return true;
            }
        });
        Button button = (Button) inflate.findViewById(R.id.updatequantity);
        button.setBackgroundColor(Color.parseColor(FullscreenActivity.z().getActionBarBgColor()));
        button.setTextColor(Color.parseColor(FullscreenActivity.z().getActionBarTitleColor()));
        button.setText(StringConstants.UPDATE_QUANTITY.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedDetailActivity.this.ap();
            }
        });
        this.af.setVisibility(8);
        return inflate;
    }

    private void c(String str) {
        if (str == null || str.isEmpty()) {
            this.aj.getLayoutParams().height = 0;
            this.ak.getLayoutParams().height = 0;
            this.al.getLayoutParams().height = 0;
            this.aI.getLayoutParams().height = this.ar;
            return;
        }
        DisplayMetrics displayMetrics = k().getDisplayMetrics();
        if (displayMetrics != null) {
            this.aI.getLayoutParams().height = (int) (displayMetrics.density * 240.0f);
        } else {
            this.aI.getLayoutParams().height = 550;
        }
        if (FullscreenActivity.z() != null) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.parseColor(r0.getActionBarBgColor()), Color.parseColor(r0.getActionBarBgColor()), Color.parseColor(r0.getActionBarBgColor())});
            gradientDrawable.setCornerRadius(0.0f);
            this.ak.setBackgroundDrawable(gradientDrawable);
            Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#aa000000"), Color.parseColor("#00ffffff")});
            gradientDrawable2.setCornerRadius(0.0f);
            this.al.setBackgroundDrawable(gradientDrawable2);
        }
        Picasso.a(getLifecycleActivity()).a(str).a(this.aj);
        this.am = true;
    }

    private View d(Product product) {
        View a;
        View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.product_detail, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.post_image);
        TextView textView = (TextView) inflate.findViewById(R.id.mrp);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sellingprice);
        TextView textView3 = (TextView) inflate.findViewById(R.id.reviews);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.productMetaLayout);
        ((TextView) inflate.findViewById(R.id.title)).setText(product.getTitle());
        Picasso.a(getLifecycleActivity()).a(product.getPostImage()).a(imageView);
        String mrpPriceText = product.getMrpPriceText();
        if (mrpPriceText == null || mrpPriceText.isEmpty()) {
            textView.setVisibility(4);
        } else {
            textView.setText(StringConstants.MRP.getMessage() + ": " + mrpPriceText, BufferType.SPANNABLE);
            ((Spannable) textView.getText()).setSpan(az, StringConstants.MRP.getMessage().length() + 2, textView.length(), 33);
        }
        CharSequence sellingPriceText = product.getSellingPriceText();
        if (sellingPriceText == null) {
            textView.setVisibility(4);
            sellingPriceText = mrpPriceText;
        }
        textView2.setText(sellingPriceText);
        textView3.setText("x reviews");
        if (product.getAndroapp_meta() != null) {
            for (String str : product.getAndroapp_meta().keySet()) {
                String str2;
                mrpPriceText = (String) product.getAndroapp_meta().get(str2);
                try {
                    str2 = StringConstants.valueOf(str2.toUpperCase()).name();
                } catch (Exception e) {
                }
                a = a(str2, mrpPriceText);
                if (a != null) {
                    linearLayout.addView(a);
                }
            }
        }
        a = a(StringConstants.PRODUCT_DESCRIPTION.getMessage(), product.getDescription());
        if (a != null) {
            linearLayout.addView(a);
        }
        return inflate;
    }

    private void d(String str) {
        final Uri parse = Uri.parse(str);
        this.i.setVisibility(0);
        this.c.execute(new Runnable() {
            public void run() {
                final Object a = FeedDetailActivity.this.e.a(parse.getPath() + (parse.getQuery() != null ? "?" + parse.getQuery() : ""));
                FeedDetailActivity.this.d.execute(new Runnable() {
                    public void run() {
                        try {
                            FeedDetailActivity.this.a(a);
                        } catch (Exception e) {
                            Log.d("AndroApp", "error");
                        }
                    }
                });
            }
        });
    }

    private void e(String str) {
        if (Uri.parse(str).getScheme() == null) {
            StringBuilder append = new StringBuilder().append(getLifecycleActivity().getString(R.string.wp_server_base_path));
            if (!str.startsWith("/")) {
                str = "/" + str;
            }
            str = append.append(str).toString();
        }
        ((FullscreenActivity) getLifecycleActivity()).a(this.aC, str);
    }

    private boolean e(int i) {
        if (this.aC == null) {
            return false;
        }
        if (i == R.id.cart) {
            Activity j = InjectibleApplication.j();
            if (!(j instanceof FullscreenActivity)) {
                return false;
            }
            ((FullscreenActivity) j).q();
            return false;
        } else if (i == R.id.comments_notifcation_count) {
            Log.d("AndroApp: ", "Comments to be opened");
            Fragment commentsActivity = new CommentsActivity();
            if (FullscreenActivity.A().getCommentsProvider().equals("facebook")) {
                commentsActivity.a(this.aC);
            } else {
                commentsActivity.a(new CommentObject(this.aC.getID(), CommentObjectType.POST));
            }
            ((FullscreenActivity) getLifecycleActivity()).a(commentsActivity, "COMMENTS", false, -1, false);
            return true;
        } else if (i == R.id.saveforlater) {
            this.b.a(this.aC);
            getLifecycleActivity().invalidateOptionsMenu();
            return false;
        } else if (i == R.id.deleteOfflinePost) {
            this.b.a(this.aC.getID());
            getLifecycleActivity().invalidateOptionsMenu();
            return false;
        } else if (i == R.id.shareimage) {
            FriopinApplication.a().a("Share", "Share from Zoom Image Screen", "ImageView");
            Post post = new Post();
            post.setShareImage(this.av);
            post.setTitle("");
            post.setExcerpt("");
            return ((FullscreenActivity) getLifecycleActivity()).B().onShareButtonClick(i, getLifecycleActivity(), post);
        } else if (i == R.id.saveimage) {
            this.h.saveImageToDisk(this.aJ, this.aD, getLifecycleActivity());
            return false;
        } else if (i != R.id.share) {
            return false;
        } else {
            FriopinApplication.a().a("Share", "Share from Menu Icon", "postId=" + this.aC.getID());
            return ((FullscreenActivity) getLifecycleActivity()).B().onShareButtonClick(i, getLifecycleActivity(), this.aC);
        }
    }

    int a() {
        int[] iArr = new int[]{R.attr.actionBarSize};
        TypedArray obtainStyledAttributes = getLifecycleActivity().obtainStyledAttributes(new TypedValue().data, iArr);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aF = layoutInflater.inflate(R.layout.feed_detail, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        this.at = k().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        this.as = k().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        this.au = k().getDimensionPixelSize(R.dimen.margin_standard);
        this.ar = a();
        this.ao = (FrameLayout) this.aF.findViewById(R.id.webview_frame);
        this.aj = (ImageView) this.aF.findViewById(R.id.image);
        this.aJ = (ImageView) this.aF.findViewById(R.id.expanded_image);
        this.ak = this.aF.findViewById(R.id.overlay);
        this.al = this.aF.findViewById(R.id.overlay2);
        this.aI = this.aF.findViewById(R.id.emptyspace);
        this.an = (ObservableScrollView) this.aF.findViewById(R.id.scrollViewLayout);
        this.an.setScrollViewCallbacks(this);
        this.ap = (FloatingActionButton) this.aF.findViewById(R.id.fab);
        this.aq = (TextView) this.aF.findViewById(R.id.fabCount);
        am();
        an();
        this.aq.setText(ak());
        this.aw = (SwipeRefreshLayout) this.aF.findViewById(R.id.swiperefresh);
        this.a = (FrameLayout) this.aF.findViewById(R.id.fabFrameLayout);
        this.i = this.aF.findViewById(R.id.progressbar);
        this.i.setVisibility(4);
        b(this.aF);
        LinearLayout linearLayout = (LinearLayout) this.aF.findViewById(R.id.shareLayout);
        if (this.aC == null && linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) this.aF.findViewById(R.id.feedTopLayout);
        LinearLayout linearLayout2 = (LinearLayout) this.aF.findViewById(R.id.ContentLinearLayout);
        this.ae = (ScrollView) this.aF.findViewById(R.id.scrollViewLayout);
        View a = w.a(null, 10, 19493, FullscreenActivity.o.getTopAdUnitList(), AdLocation.SINGLE);
        if (a != null) {
            linearLayout2.addView(a, 1);
            a.setPadding(0, 2, 0, 2);
        }
        a = w.a(null, -1, 43353, FullscreenActivity.o.getMiddleAdUnitList(), AdLocation.SINGLE);
        if (a != null) {
            linearLayout2.addView(a);
        }
        a = w.a(null, -1, 43354, FullscreenActivity.o.getBottomAdUnitList(), AdLocation.SINGLE);
        if (a != null) {
            if (this.aC == null || !(this.aC instanceof Product)) {
                linearLayout.addView(a);
            } else {
                linearLayout2.addView(a);
            }
            a.setPadding(0, 2, 0, 2);
        }
        com.github.ksoichiro.android.observablescrollview.c.a(this.an, new Runnable() {
            public void run() {
                FeedDetailActivity.this.an.scrollTo(0, FeedDetailActivity.this.at - FeedDetailActivity.this.ar);
            }
        });
        if (this.aG == null || this.aH == this.aG.ad()) {
            ad();
        }
        if (w.a(FullscreenActivity.A())) {
            this.aI.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    FeedDetailActivity.this.ao();
                }
            });
        }
        this.aw.a(false, ((FullscreenActivity) getLifecycleActivity()).o(), ((FullscreenActivity) getLifecycleActivity()).o() + 200);
        this.aw.setOnRefreshListener(this);
        return this.aF;
    }

    public void a(int i, int i2, Intent intent) {
        if (VERSION.SDK_INT >= 21) {
            if (i == 100 && this.aL != null) {
                this.aL.onReceiveValue(FileChooserParams.parseResult(i2, intent));
                this.aL = null;
            }
        } else if (i == 1 && this.aK != null) {
            Object data = (intent == null || i2 != -1) ? null : intent.getData();
            this.aK.onReceiveValue(data);
            this.aK = null;
        }
    }

    public void a(android.view.Menu menu) {
        super.a(menu);
    }

    public void a(android.view.Menu menu, MenuInflater menuInflater) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called FeedDetailActivity");
        if (ag()) {
            menu.clear();
            menuInflater.inflate(R.menu.image_view_fragment_menu, menu);
        } else {
            c(menu, menuInflater);
        }
        super.a(menu, menuInflater);
    }

    public void a(ValueCallback<Uri[]> valueCallback) {
        this.aL = valueCallback;
    }

    public void a(ViewPagerFragement viewPagerFragement) {
        this.aG = viewPagerFragement;
    }

    public void a(Menu menu) {
        this.ay = menu;
    }

    public void a(Post post) {
        this.aC = post;
    }

    public void a(final Product product) {
        final CharSequence[] charSequenceArr = new String[product.getVariations().size()];
        final Long[] lArr = new Long[product.getVariations().size()];
        int i = 0;
        Iterator it = product.getVariations().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Variation variation = (Variation) it.next();
                charSequenceArr[i2] = a(variation.getAttributes());
                lArr[i2] = variation.getId();
                i = i2 + 1;
            } else {
                CharSequence charSequence = StringConstants.SELECT.getMessage() + " " + b(product);
                Builder builder = new Builder(getLifecycleActivity());
                builder.setTitle(charSequence).setItems(charSequenceArr, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("AndroApp", "Selected " + charSequenceArr[i]);
                        com.puzzlersworld.android.util.b.a(FeedDetailActivity.this.getLifecycleActivity(), FeedDetailActivity.this.f, FeedDetailActivity.this.g.getCartService(), product.getId(), lArr[i], com.puzzlersworld.android.util.b.a(product, lArr[i]), FeedDetailActivity.this);
                    }
                });
                builder.create().show();
                return;
            }
        }
    }

    public void a(boolean z) {
        this.ax = z;
    }

    public boolean a(MenuItem menuItem) {
        return e(menuItem.getItemId());
    }

    public void ac() {
        this.i.setVisibility(0);
        this.c.execute(new Runnable() {
            public void run() {
                Call call = null;
                try {
                    if (FeedDetailActivity.this.ay.getMenuItemType() == MenuItemType.page) {
                        call = FeedDetailActivity.this.g.getWpCoreService().fetchPage(FeedDetailActivity.this.ay.getObjectId());
                    } else if (FeedDetailActivity.this.ay.getMenuItemType() == MenuItemType.post) {
                        call = FeedDetailActivity.this.g.getWpCoreService().fetchPost(FeedDetailActivity.this.ay.getObjectId());
                    } else if (FeedDetailActivity.this.ay.getMenuItemType() == MenuItemType.custom_post_type) {
                        call = (!w.a(FeedDetailActivity.this.g) || ab.a(FeedDetailActivity.this.ay.getTaxonomy_name())) ? FeedDetailActivity.this.g.getWpCoreService().fetchPost(FeedDetailActivity.this.ay.getObjectId()) : FeedDetailActivity.this.g.getWpCoreService().fetchCustomPostV2(FeedDetailActivity.this.ay.getTaxonomy_name(), FeedDetailActivity.this.ay.getObjectId());
                    }
                    if (call != null) {
                        FeedDetailActivity.this.aC = (Post) call.execute().b();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FriopinApplication.a().a(e);
                }
                FeedDetailActivity.this.d.execute(new Runnable() {
                    public void run() {
                        try {
                            if (FeedDetailActivity.this.aC == null) {
                                w.a(StringConstants.CANT_CONNECT.getMessage(), FeedDetailActivity.this.getLifecycleActivity());
                            } else if (FeedDetailActivity.this.aC.getPostContentType() == PostContentType.loadimages) {
                                FullscreenActivity fullscreenActivity = (FullscreenActivity) FeedDetailActivity.this.getLifecycleActivity();
                                fullscreenActivity.u();
                                fullscreenActivity.a(FeedDetailActivity.this.aC, null);
                            } else {
                                List arrayList = new ArrayList();
                                arrayList.add(FeedDetailActivity.this.aC);
                                FeedDetailActivity.this.aG.b(arrayList);
                                ((FullscreenActivity) FeedDetailActivity.this.getLifecycleActivity()).a(FeedDetailActivity.this.getTitle());
                                FeedDetailActivity.this.ar();
                                FeedDetailActivity.this.ay = null;
                                FeedDetailActivity.this.b(FeedDetailActivity.this.aF);
                                FeedDetailActivity.this.ad();
                            }
                        } catch (NullPointerException e) {
                        }
                    }
                });
            }
        });
    }

    public void ad() {
        this.ai = Integer.valueOf(this.an.getCurrentScrollY());
        ((FullscreenActivity) getLifecycleActivity()).p();
        if (this.ai.intValue() != 0) {
            this.an.setScrollY(this.ai.intValue());
        }
        onScrollChanged(this.an.getCurrentScrollY(), true, false);
        if (this.aC != null) {
            FriopinApplication.a().a("post screen");
        } else {
            FriopinApplication.a().a("link screen");
        }
    }

    public void ae() {
        if (getLifecycleActivity() != null) {
            getLifecycleActivity().onBackPressed();
        }
    }

    public String af() {
        return this.aD;
    }

    public boolean ag() {
        return this.aJ != null && this.aJ.getVisibility() == 0;
    }

    public void ah() {
        this.aJ.setVisibility(4);
        ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
        ad();
        getLifecycleActivity().invalidateOptionsMenu();
    }

    public ValueCallback<Uri[]> ai() {
        return this.aL;
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        a(bundle);
        d(true);
    }

    public void b(String str) {
        this.aD = str;
    }

    public void c(android.view.Menu menu, MenuInflater menuInflater) {
        if (this.aD != null) {
            menu.clear();
        } else if (this.aC != null) {
            menu.clear();
            menuInflater.inflate(R.menu.feed_detail_menu, menu);
            MenuItem findItem = menu.findItem(R.id.saveforlater);
            MenuItem findItem2 = menu.findItem(R.id.deleteOfflinePost);
            if (FullscreenActivity.A() == null || FullscreenActivity.A().getShowSaveOption() == null || FullscreenActivity.A().getShowSaveOption().intValue() == 0) {
                findItem.setVisible(false);
                findItem2.setVisible(false);
            } else if (this.b.b(this.aC.getID()) == null) {
                findItem.setVisible(true);
                findItem2.setVisible(false);
                findItem.setTitle(StringConstants.SAVE_FOR_OFFLINE.getMessage());
            } else {
                findItem.setVisible(false);
                findItem2.setVisible(true);
                findItem2.setTitle(StringConstants.REMOVE_FROM_OFFLINE.getMessage());
            }
        }
        com.puzzlersworld.android.util.b.a(menu, this.f);
    }

    public void d(int i) {
        this.aH = i;
    }

    public void d(Bundle bundle) {
        Log.d("AndroApp:", "OnActivityCreated called");
        super.d(bundle);
    }

    public void e() {
        super.e();
    }

    public void e(Bundle bundle) {
        Log.d("AndroApp:", "OnSaveInstance calle");
        super.e(bundle);
        if (this.aD != null) {
            bundle.putSerializable("url", this.aD);
        }
        if (this.aC != null) {
            bundle.putSerializable("post", this.aC);
        }
        bundle.putSerializable("fetchURL", Boolean.valueOf(this.ax));
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.FEED_DETAIL_ACTIVITY;
    }

    public String getTitle() {
        return ag() ? "" : this.aC != null ? this.aC.getTitle() : this.aD != null ? this.aD : null;
    }

    public Object getTriggerObject() {
        return this.aC != null ? this.aC : this.aD != null ? this.aD : null;
    }

    public void onAddToCartFailure(Throwable th) {
        this.aA.a(new Exception(th));
    }

    public void onAddToCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem) {
        if (cart == null) {
            w.a(getLifecycleActivity(), (ai) aiVar);
            return;
        }
        w.a(this.d, StringConstants.ADDED_TO_CART.getMessage(), getLifecycleActivity());
        this.ag.setTag(cartItem.getCart_item_key());
        this.ah.setText("" + cartItem.getQuantity());
        this.af.setVisibility(0);
        this.ag.setVisibility(8);
        getLifecycleActivity().invalidateOptionsMenu();
    }

    public void onConnectionTimeout() {
        w.a(this.d, StringConstants.CONNECTION_TIMEOUT.getMessage(), getLifecycleActivity());
    }

    public void onDownMotionEvent() {
    }

    public void onError(Exception exception) {
        w.a(this.d, StringConstants.UNKNOWN_ERROR.getMessage(), getLifecycleActivity());
    }

    public void onNoNetwork() {
        w.a(this.d, StringConstants.CANT_CONNECT.getMessage(), getLifecycleActivity());
    }

    public void onRefresh() {
        if (VERSION.SDK_INT >= 23) {
            this.aE.reload();
        }
    }

    public void onScrollChanged(int i, boolean z, boolean z2) {
        if (ag()) {
            aq();
            return;
        }
        int height;
        float f;
        float f2;
        float f3 = (float) (this.at - this.ar);
        if (this.am) {
            height = 0 - this.ak.getHeight();
            com.nineoldandroids.a.a.j(this.ak, com.github.ksoichiro.android.observablescrollview.c.a((float) ((-i) / 2), (float) height, 0.0f));
            com.nineoldandroids.a.a.j(this.aj, com.github.ksoichiro.android.observablescrollview.c.a((float) ((-i) / 2), (float) height, 0.0f));
            com.nineoldandroids.a.a.j(this.al, com.github.ksoichiro.android.observablescrollview.c.a((float) ((-i) / 2), (float) height, 0.0f));
            if (i * 2 > this.at) {
                f = (float) (this.at - this.ar);
                f = com.github.ksoichiro.android.observablescrollview.c.a(((float) (i - (this.at / 2))) / (f3 - ((float) (this.at / 2))), 0.0f, 1.0f);
            } else {
                f = 0.0f;
            }
            com.nineoldandroids.a.a.a(this.ak, f);
            f2 = f3;
            f3 = f;
        } else {
            f3 = 1.0f;
            f2 = 0.0f;
        }
        ActionBar f4 = ((FullscreenActivity) getLifecycleActivity()).f();
        ThemeColors z3 = FullscreenActivity.z();
        if (z3 != null) {
            if (f3 < 1.0f) {
                f3 = 0.0f;
            }
            f4.a(new ColorDrawable(com.github.ksoichiro.android.observablescrollview.c.a(f3, Color.parseColor(z3.getActionBarBgColor()))));
        }
        View F = ((FullscreenActivity) getLifecycleActivity()).F();
        if (this.ai != null) {
            f = com.github.ksoichiro.android.observablescrollview.c.a((F.getTranslationY() + ((float) this.ai.intValue())) - ((float) i), (float) (-this.ar), 0.0f);
            if (((float) i) < f2) {
                f = 0.0f;
            }
            com.nineoldandroids.a.a.j(F, f);
        }
        if (!(this.ai == null || this.aC == null)) {
            height = (-this.a.getHeight()) * 2;
            f3 = com.github.ksoichiro.android.observablescrollview.c.a((this.a.getTranslationY() + ((float) this.ai.intValue())) - ((float) i), (float) height, 0.0f);
            f = 1.0f - com.github.ksoichiro.android.observablescrollview.c.a(f3 / ((float) height), 0.0f, 1.0f);
            com.nineoldandroids.a.a.j(this.a, f3);
            com.nineoldandroids.a.a.a(this.a, f);
            if (aj()) {
                if (f <= 0.0f) {
                    this.a.setVisibility(4);
                } else {
                    this.a.setVisibility(0);
                }
            }
        }
        this.ai = Integer.valueOf(i);
    }

    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    public void onUpdateCartFailure(Throwable th) {
        this.aA.a(new Exception(th));
    }

    public void onUpdateCartSuccess(Cart cart, ai<Cart> aiVar, CartItem cartItem) {
        if (cart == null) {
            w.a(getLifecycleActivity(), (ai) aiVar);
            return;
        }
        w.a(this.d, StringConstants.CART_UPDATED.getMessage(), getLifecycleActivity());
        this.af.setVisibility(8);
        this.ag.setVisibility(0);
        getLifecycleActivity().invalidateOptionsMenu();
    }

    public void t() {
        super.t();
        if (this.aE != null) {
            this.aE.onResume();
        }
        ar();
    }

    public void u() {
        super.u();
        if (this.aE != null && VERSION.SDK_INT >= 11) {
            this.aE.onPause();
        }
    }

    public void v() {
        super.v();
        if (this.aE != null && VERSION.SDK_INT >= 11) {
            this.aE.stopLoading();
            this.aE.destroy();
            if (getLifecycleActivity() != null) {
                ((FullscreenActivity) getLifecycleActivity()).a(null);
            }
            this.aE = null;
        }
    }
}
