package com.appnext.core;

import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.ResultReceiver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class AdsService extends IntentService {
    public static final int ADD_PACK = 8348;
    public static final int START_APP = 8346;
    private static HashMap<String, p> kP = new HashMap();
    private Runnable kQ = new Runnable() {
        public void run() {
            try {
                for (Entry entry : AdsService.kP.entrySet()) {
                    p pVar = (p) entry.getValue();
                    if (AdsService.this.aI(pVar.bj)) {
                        new Bundle().putAll(pVar.mm);
                        AdsService.this.a(pVar);
                        AdsService.kP.remove(entry.getKey());
                        AdsService.this.startActivity(AdsService.this.getPackageManager().getLaunchIntentForPackage(pVar.bj));
                    }
                }
                if (AdsService.this.mHandler == null) {
                    AdsService.this.stopSelf();
                } else if (AdsService.kP.entrySet().size() > 0) {
                    AdsService.this.mHandler.postDelayed(AdsService.this.kQ, 10000);
                } else {
                    AdsService.this.mHandler.removeCallbacksAndMessages(null);
                    AdsService.this.mHandler = null;
                    AdsService.this.stopSelf();
                }
            } catch (Throwable th) {
                AdsService.this.stopSelf();
            }
        }
    };
    private Handler mHandler;
    Messenger mMessenger = new Messenger(new a());

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case AdsService.ADD_PACK /*8348*/:
                    Bundle data = message.getData();
                    AdsService.this.addPack(data.getString("package"), data, (ResultReceiver) data.getParcelable("receiver"));
                    g.X("Package added: " + data.getString("package"));
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public AdsService() {
        super("AdsService");
    }

    private void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
        p pVar = (p) kP.get(str);
        if (pVar == null) {
            addPack(str, bundle, resultReceiver);
            return;
        }
        pVar.mm = bundle;
        kP.put(str, pVar);
    }

    private boolean aI(String str) {
        try {
            getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    protected synchronized void a(p pVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("guid", pVar.mm.getString("guid"));
        hashMap.put("zone", pVar.mm.getString("zone") == null ? "" : pVar.mm.getString("zone"));
        hashMap.put("adsID", g.u(this));
        hashMap.put("isApk", "0");
        hashMap.put("bannerid", pVar.mm.getString("bannerid"));
        hashMap.put("placementid", pVar.mm.getString("placementid"));
        hashMap.put("vid", pVar.mm.getString("vid"));
        hashMap.put("tid", pVar.mm.getString("tid", ""));
        hashMap.put("osid", "100");
        hashMap.put("auid", pVar.mm.getString("auid", ""));
        Object installerPackageName = getPackageManager().getInstallerPackageName(pVar.bj);
        String str = "installer";
        if (installerPackageName == null) {
            installerPackageName = "";
        }
        hashMap.put(str, installerPackageName);
        try {
            g.a("https://admin.appnext.com/AdminService.asmx/SetOpenV1", hashMap);
        } catch (IOException e) {
        }
    }

    public void addPack(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (kP == null) {
            kP = new HashMap();
        }
        if (kP.containsKey(str)) {
            a(str, bundle, resultReceiver);
            return;
        }
        p pVar = new p();
        pVar.bj = str;
        pVar.mm = bundle;
        kP.put(str, pVar);
        if (this.mHandler == null) {
            this.mHandler = new Handler();
            this.mHandler.postDelayed(this.kQ, 10000);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
        kP.clear();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
    }

    protected void onHandleIntent(Intent intent) {
        if (intent.getIntExtra("added_info", 0) == ADD_PACK) {
            addPack(intent.getStringExtra("package"), intent.getExtras(), (ResultReceiver) intent.getParcelableExtra("receiver"));
            g.X("Package added: " + intent.getStringExtra("package"));
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }
}
