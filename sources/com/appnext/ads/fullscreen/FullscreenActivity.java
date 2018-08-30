package com.appnext.ads.fullscreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.appnext.R;
import com.appnext.ads.b;
import com.appnext.base.b.c;
import com.appnext.core.Ad;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.e.a;
import com.appnext.core.g;
import com.appnext.core.l;
import com.appnext.core.r;
import com.appnext.core.s;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;

public class FullscreenActivity extends AppnextActivity implements h, i, j, a {
    private ArrayList<AppnextAd> aL;
    private boolean dA = true;
    private AppnextAd dB;
    private AppnextAd dC;
    b dD;
    private HashMap<String, Integer> dE;
    private Video dF;
    Runnable dG = new Runnable() {
        public void run() {
            g.X("impression");
            if (FullscreenActivity.this.userAction != null) {
                FullscreenActivity.this.userAction.e(FullscreenActivity.this.dB);
            }
            if (Boolean.parseBoolean(FullscreenActivity.this.getConfig().get("fq_control")) && FullscreenActivity.this.ab() != null && FullscreenActivity.this.ab().fq_status) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            g.a("https://www.fqtag.com/pixel.cgi?org=TkBXEI5C3FBIr4zXwnmK&p=" + FullscreenActivity.this.placementID + "&a=" + FullscreenActivity.this.dB.getBannerID() + "&cmp=" + FullscreenActivity.this.dB.getCampaignID() + "&fmt=banner&dmn=" + FullscreenActivity.this.dB.getAdPackage() + "&ad=&rt=displayImg&gid=" + g.u(FullscreenActivity.this) + "&aid=&applng=" + Locale.getDefault().toString() + "&app=" + FullscreenActivity.this.getPackageName() + "&c1=100&c2=" + FullscreenActivity.this.ab().getTID() + "&c3=" + FullscreenActivity.this.ab().getAUID() + "&c4=" + FullscreenActivity.this.ab().getVID() + "&sl=1&fq=1", null);
                        } catch (Throwable th) {
                            g.c(th);
                        }
                    }
                }).start();
            }
            FullscreenActivity.this.report(com.appnext.ads.a.cL, "S2");
        }
    };
    Runnable dH = new Runnable() {
        public void run() {
            g.X("postview");
            FullscreenActivity.this.a(FullscreenActivity.this.dB, null);
            FullscreenActivity.this.report(com.appnext.ads.a.cM, "S2");
        }
    };
    private r dz;
    private boolean finished = false;
    private Handler mHandler;
    private int state = 0;
    private int type;

    private Uri Y() {
        String videoUrl = b.getVideoUrl(this.dB, ab().getVideoLength());
        String O = b.O(videoUrl);
        String str = Video.getCacheVideo() ? getFilesDir().getAbsolutePath() + c.jf + c.jg : getFilesDir().getAbsolutePath() + c.jf + c.jg + "tmp/vid" + ab().rnd + "/";
        File file = new File(str + O);
        Uri parse;
        if (file.exists()) {
            parse = Uri.parse(str + O);
            g.X("playing video " + parse.getPath());
            return parse;
        }
        parse = Uri.parse(videoUrl);
        g.X("playing video from web: " + videoUrl);
        g.X("file not found: " + file.getAbsolutePath());
        return parse;
    }

    private boolean Z() {
        return (ab() instanceof FullScreenVideo) && ((FullScreenVideo) ab()).isBackButtonCanClose();
    }

    private void a(AppnextAd appnextAd) {
        b(appnextAd, this);
    }

    private void aa() {
    }

    private Video ab() {
        return Video.currentAd != null ? Video.currentAd : this.dF;
    }

    private boolean b(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    private void d(String str, String str2) {
        try {
            g.a(ab().getTID(), ab().getVID(), ab().getAUID(), this.placementID, ab().getSessionId(), str, str2, this.dB != null ? this.dB.getBannerID() : "", this.dB != null ? this.dB.getCampaignID() : "");
        } catch (Throwable th) {
        }
    }

    private void onClose() {
        try {
            b.ag().a(this.dB.getBannerID(), ab());
            if (!(ab() == null || ab().getOnAdClosedCallback() == null)) {
                ab().getOnAdClosedCallback().onAdClosed();
            }
            Video.currentAd = null;
        } catch (Throwable th) {
        }
    }

    private void report(String str) {
        d(str, getResources().getResourceEntryName(getTemplate("S" + (this.state + 1))));
    }

    protected AppnextAd a(ArrayList<AppnextAd> arrayList, String str, String str2) {
        AppnextAd appnextAd;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            appnextAd = (AppnextAd) it.next();
            if (b(appnextAd) && !c(appnextAd.getBannerID(), str) && !appnextAd.getBannerID().equals(str2)) {
                return appnextAd;
            }
        }
        l.dg().aR(str);
        it = arrayList.iterator();
        while (it.hasNext()) {
            appnextAd = (AppnextAd) it.next();
            if (b(appnextAd) && !c(appnextAd.getBannerID(), str)) {
                return appnextAd;
            }
        }
        return null;
    }

    protected void a(AppnextAd appnextAd, a aVar) {
        super.a(appnextAd, new a() {
            public void error(String str) {
            }

            public void onMarket(String str) {
            }
        });
    }

    protected void b(AppnextAd appnextAd, a aVar) {
        if (appnextAd != null) {
            this.dC = appnextAd;
            if (ab().getOnAdClickedCallback() != null) {
                ab().getOnAdClickedCallback().adClicked();
            }
            if (this.finished || !(ab() instanceof RewardedVideo)) {
                super.b(appnextAd, aVar);
            }
        }
    }

    protected boolean c(String str, String str2) {
        return l.dg().r(str, str2);
    }

    public void closeClicked() {
        onClose();
        finish();
    }

    public long closeDelay() {
        return ab() instanceof FullScreenVideo ? ((FullScreenVideo) ab()).getCloseDelay() : 0;
    }

    public void error(String str) {
        cV();
        report(com.appnext.ads.a.cF);
    }

    public int getCaptionTextTime() {
        return ab().getRollCaptionTime();
    }

    protected r getConfig() {
        if (this.dz == null) {
            if (this.type == 1) {
                this.dz = c.aj();
            } else {
                this.dz = f.al();
            }
        }
        return this.dz;
    }

    public r getConfigManager() {
        return getConfig();
    }

    public String getCtaText() {
        String buttonText = new FullscreenAd(this.dB).getButtonText();
        return (this.dB == null || !buttonText.equals("")) ? buttonText : isInstalled() ? "Open" : "Install";
    }

    public boolean getMute() {
        return ab().getMute();
    }

    public ArrayList<AppnextAd> getPostRollAds() {
        return this.aL;
    }

    public ArrayList<AppnextAd> getPreRollAds() {
        if (this.aL == null) {
            this.aL = b.ag().f(ab());
        }
        ArrayList<AppnextAd> arrayList = new ArrayList();
        AppnextAd a = a(this.aL, this.placementID, "");
        arrayList.add(a);
        AppnextAd a2 = a(this.aL, this.placementID, a.getBannerID());
        if (!(a2 == null || a2.getBannerID().equals(((AppnextAd) arrayList.get(0)).getBannerID()))) {
            arrayList.add(a2);
        }
        return arrayList;
    }

    public AppnextAd getSelectedAd() {
        return this.dB;
    }

    public Uri getSelectedVideoUri() {
        return Y();
    }

    public int getTemplate(String str) {
        if (this.dE == null) {
            this.dE = new HashMap();
        }
        if (!this.dE.containsKey(str)) {
            int identifier = getResources().getIdentifier("apnxt_" + com.appnext.ads.c.M(getConfig().get(str)), "layout", getPackageName());
            if (identifier == 0) {
                identifier = getResources().getIdentifier("apnxt_" + str.toLowerCase() + "t1", "layout", getPackageName());
            }
            this.dE.put(str, Integer.valueOf(identifier));
        }
        return ((Integer) this.dE.get(str)).intValue();
    }

    public void installClicked() {
        a(this.dB);
    }

    public void installClicked(AppnextAd appnextAd) {
        a(this.kU, getResources().getDrawable(R.drawable.apnxt_loader));
        a(appnextAd);
    }

    public boolean isInstalled() {
        try {
            return g.h(this, this.dB.getAdPackage());
        } catch (Throwable th) {
            return false;
        }
    }

    public void onBackPressed() {
        if ((this.state == 1 && Z()) || this.state == 2) {
            onClose();
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.dE = (HashMap) bundle.getSerializable("templates");
            this.state = bundle.getInt("state");
        }
        if (VERSION.SDK_INT >= 17) {
            Configuration configuration = getResources().getConfiguration();
            configuration.setLayoutDirection(new Locale("en"));
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        super.onCreate(bundle);
        aa();
        if (Video.currentAd == null) {
            g.X("null currentAd");
            onError(AppnextError.NO_ADS);
            finish();
            return;
        }
        if (Video.currentAd instanceof RewardedVideo) {
            this.dF = new RewardedVideo((Context) this, (RewardedVideo) Video.currentAd);
        } else {
            this.dF = new FullScreenVideo((Context) this, (FullScreenVideo) Video.currentAd);
        }
        String orientation = ab().getOrientation();
        boolean z = true;
        switch (orientation.hashCode()) {
            case 729267099:
                if (orientation.equals(Ad.ORIENTATION_PORTRAIT)) {
                    z = true;
                    break;
                }
                break;
            case 1430647483:
                if (orientation.equals(Ad.ORIENTATION_LANDSCAPE)) {
                    z = true;
                    break;
                }
                break;
            case 1673671211:
                if (orientation.equals(Ad.ORIENTATION_AUTO)) {
                    z = true;
                    break;
                }
                break;
            case 2129065206:
                if (orientation.equals(Ad.ORIENTATION_DEFAULT)) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                if (getResources().getConfiguration().orientation != 2) {
                    setRequestedOrientation(7);
                    break;
                } else {
                    setRequestedOrientation(6);
                    break;
                }
            case true:
                setRequestedOrientation(6);
                break;
            case true:
                setRequestedOrientation(7);
                break;
        }
        this.mHandler = new Handler();
        this.placementID = getIntent().getExtras().getString("id");
        this.type = getIntent().getExtras().getInt("type");
        if (this.type == 1) {
            this.dz = c.aj();
        } else {
            this.dz = f.al();
        }
        this.dA = Boolean.parseBoolean(this.dz.get("can_close"));
        if (ab() instanceof FullScreenVideo) {
            this.dA = ((FullScreenVideo) ab()).isBackButtonCanClose();
        }
        if (bundle == null) {
            this.aL = b.ag().f(ab());
            if (this.aL == null) {
                onError(AppnextError.NO_ADS);
                finish();
                return;
            }
            this.dB = a(this.aL, this.placementID, "");
        } else {
            this.aL = (ArrayList) bundle.getSerializable("ads");
            this.dB = (AppnextAd) bundle.getSerializable("currentAd");
        }
        if (this.dB == null) {
            onError(AppnextError.NO_ADS);
            finish();
            return;
        }
        setContentView(R.layout.apnxt_video_activity);
        if (bundle == null) {
            Fragment fragment;
            Bundle bundle2 = new Bundle();
            String mode = ab() instanceof RewardedVideo ? ((RewardedVideo) ab()).getMode() : "";
            if (mode.equals(RewardedVideo.VIDEO_MODE_DEFAULT)) {
                mode = getConfig().get("default_mode");
            }
            if (this.type == 2 && mode.equals("multi")) {
                Fragment eVar = new e();
                bundle2.putInt(c.ju, ((RewardedVideo) ab()).getMultiTimerLength());
                report("multi");
                fragment = eVar;
            } else {
                if (this.type == 2) {
                    report("normal");
                }
                fragment = new g();
                bundle2.putBoolean("showCta", ab().isShowCta());
                this.state = 1;
            }
            fragment.setArguments(bundle2);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(R.id.ll, fragment, "fragment");
            try {
                beginTransaction.commit();
            } catch (Exception e) {
                finish();
                return;
            }
        }
        this.finished = bundle.getBoolean("finished", true);
        this.kU = (RelativeLayout) findViewById(R.id.ll);
        this.userAction = new s(this, new s.a() {
            public Ad ac() {
                return Video.currentAd;
            }

            public AppnextAd ad() {
                return FullscreenActivity.this.dC;
            }

            public r ae() {
                return FullscreenActivity.this.getConfig();
            }

            public void report(String str) {
                FullscreenActivity.this.report(str);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        aa();
        try {
            g.b(new File(getFilesDir().getAbsolutePath() + c.jf + c.jg + "tmp/vid" + ab().rnd + "/"));
        } catch (Throwable th) {
        }
        try {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mHandler = null;
            this.dC = null;
            this.dB = null;
        } catch (Throwable th2) {
        }
        try {
            if (this.dD != null) {
                this.dD.d(this);
            }
            this.dD = null;
        } catch (Throwable th3) {
        }
    }

    protected void onError(String str) {
        if (ab() != null && ab().getOnAdErrorCallback() != null) {
            ab().getOnAdErrorCallback().adError(str);
        }
    }

    public void onMarket(String str) {
        cV();
        this.finished = true;
        Collections.shuffle(this.aL, new Random(System.nanoTime()));
        this.aL.remove(this.dB);
        this.aL.add(0, this.dB);
        Fragment dVar = new d();
        this.state = 2;
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll, dVar, "fragment");
        try {
            beginTransaction.commit();
        } catch (Exception e) {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        aa();
        this.mHandler.removeCallbacks(this.dG);
        this.mHandler.removeCallbacks(this.dH);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.finished = bundle.getBoolean("finished", true);
        this.type = bundle.getInt("type");
        this.dE = (HashMap) bundle.getSerializable("templates");
    }

    protected void onResume() {
        super.onResume();
        aa();
        cU();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("finished", this.finished);
        bundle.putInt("type", this.type);
        bundle.putSerializable("templates", this.dE);
        bundle.putSerializable("ads", this.aL);
        bundle.putInt("state", this.state);
        bundle.putSerializable("currentAd", this.dB);
        super.onSaveInstanceState(bundle);
    }

    public void privacyClicked() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(g.f(this.dB)));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Throwable th) {
        }
    }

    public void report(String str, String str2) {
        d(str, getResources().getResourceEntryName(getTemplate(str2)));
    }

    public boolean showClose() {
        return (ab() instanceof FullScreenVideo) && ((FullScreenVideo) ab()).isShowClose();
    }

    public void videoEnded() {
        this.state = 2;
        this.finished = true;
        if (!(ab() == null || ab().getOnVideoEndedCallback() == null)) {
            ab().getOnVideoEndedCallback().videoEnded();
        }
        new Thread(new Runnable() {
            public void run() {
                if (FullscreenActivity.this.ab() instanceof RewardedVideo) {
                    RewardedServerSidePostback rewardedServerSidePostback = ((RewardedVideo) FullscreenActivity.this.ab()).getRewardedServerSidePostback();
                    if (rewardedServerSidePostback != null) {
                        HashMap ak = rewardedServerSidePostback.ak();
                        ak.put("placementId", FullscreenActivity.this.placementID);
                        try {
                            g.a("https://admin.appnext.com/adminService.asmx/SetRewards", ak);
                        } catch (IOException e) {
                        }
                    }
                }
            }
        }).start();
        Collections.shuffle(this.aL, new Random(System.nanoTime()));
        this.aL.remove(this.dB);
        this.aL.add(0, this.dB);
        Fragment dVar = new d();
        this.state = 2;
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll, dVar, "fragment");
        try {
            beginTransaction.commit();
            if (this.dC != null) {
                super.b(this.dC, this);
                report(com.appnext.ads.a.cV);
                return;
            }
            report(com.appnext.ads.a.cU);
        } catch (Exception e) {
            finish();
        }
    }

    public void videoSelected(AppnextAd appnextAd) {
        this.dB = appnextAd;
        Fragment gVar = new g();
        FragmentManager fragmentManager = getFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putBoolean("showCta", ab().isShowCta());
        gVar.setArguments(bundle);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.ll, gVar, "fragment");
        try {
            beginTransaction.commit();
        } catch (Exception e) {
            finish();
        }
    }

    public void videoStarted() {
        this.mHandler.postDelayed(this.dG, Long.parseLong(this.dz.get("postpone_impression_sec")) * 1000);
        if (Boolean.parseBoolean(this.dz.get("pview"))) {
            this.mHandler.postDelayed(this.dH, Long.parseLong(this.dz.get("postpone_vta_sec")) * 1000);
        }
        if (ab() != null && ab().getOnAdOpenedCallback() != null) {
            ab().getOnAdOpenedCallback().adOpened();
        }
    }
}
