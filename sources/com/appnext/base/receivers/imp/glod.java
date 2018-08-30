package com.appnext.base.receivers.imp;

import android.os.Handler;
import android.os.HandlerThread;
import com.appnext.base.a.a;
import com.appnext.base.a.b.b;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.receivers.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;

public class glod implements c {
    private static final String KEY = glod.class.getSimpleName();
    private static final int SECOND = 1000;
    private static final String hV = "threshold";
    private static final String il = "last_playing_detected";
    private static final String im = "load_file";
    private static final int in = 25;
    private static final int io = 30000;
    private static final int ip = 5;
    private static final String iq = "scan";
    private static final String ir = "sample";
    private HandlerThread hS;
    private int if;
    private int is;
    private int it;
    private List<Float> iu;
    private String[] iv = new String[]{"/sys/devices/platform/gpusysfs/gpu_busy", "/sys/class/kgsl/kgsl-3d0/gpubusy", "/sys/module/ged/parameters/gpu_loading"};
    private PLAYING_STATE iw = PLAYING_STATE.NoPlaying;
    private Timer ix;
    private Handler mHandler;

    enum PLAYING_STATE {
        Playing,
        NoPlaying
    }

    private float ap(String str) {
        try {
            InputStream fileInputStream = new FileInputStream(new File(str));
            if (fileInputStream == null) {
                return 0.0f;
            }
            Reader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            String[] split = str2.trim().replaceAll("\\s+", " ").split(" ");
            int[] iArr = new int[split.length];
            if (iArr.length == 0) {
                return 0.0f;
            }
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i].trim());
            }
            return iArr.length > 1 ? (iArr[0] == 0 || iArr[1] == 0) ? 0.0f : (((float) iArr[0]) / ((float) iArr[1])) * 100.0f : (float) iArr[0];
        } catch (Exception e) {
            return 0.0f;
        }
    }

    private double cd() {
        try {
            if (this.iu == null || this.iu.size() == 0) {
                return 0.0d;
            }
            ArrayList arrayList = new ArrayList(this.iu);
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (((Float) listIterator.next()) == null) {
                    listIterator.set(Float.valueOf(0.0f));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() % 2 != 0) {
                return (double) ((Float) arrayList.get(arrayList.size() / 2)).floatValue();
            }
            return (((double) ((Float) arrayList.get((arrayList.size() / 2) - 1)).floatValue()) + ((double) ((Float) arrayList.get(arrayList.size() / 2)).floatValue())) / 2.0d;
        } catch (Throwable th) {
            return 0.0d;
        }
    }

    private String ce() {
        if (this.iv == null) {
            return null;
        }
        try {
            for (String str : this.iv) {
                if (new File(str).exists()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private void cf() {
        if (this.iu != null && this.iu.size() > 0) {
            a.aM().aP().a(new b(KEY, this.iu.toString(), com.appnext.base.b.c.a.Integer.getType()));
        }
    }

    private void cg() {
        try {
            List ae = a.aM().aP().ae(KEY);
            if (ae != null && ae.size() > 0) {
                b bVar = (b) ae.get(0);
                if (System.currentTimeMillis() - bVar.aZ().getTime() < 10000) {
                    String replaceAll = bVar.aY().replaceAll("[^0-9,.]", "");
                    if (replaceAll != null && replaceAll.length() > 1) {
                        List asList = Arrays.asList(replaceAll.split("\\s*,\\s*"));
                        if (asList != null) {
                            int size = asList.size();
                            for (int i = 0; i < size; i++) {
                                this.iu.add(Float.valueOf((String) asList.get(i)));
                            }
                        }
                        if (this.iu.size() >= this.is && cd() > ((double) this.if)) {
                            this.iw = PLAYING_STATE.Playing;
                        }
                    }
                }
                if (this.iw == PLAYING_STATE.Playing && k.aF(KEY) < i.cE().getLong(il, 0)) {
                    f((int) cd());
                }
            }
        } catch (Throwable th) {
        }
        a.aM().aP().ad(KEY);
    }

    private void f(int i) {
        k.d(KEY, String.valueOf(i), com.appnext.base.b.c.a.Integer);
    }

    public boolean hasPermission() {
        return true;
    }

    public boolean register() {
        com.appnext.base.a.b.c ac = a.aM().aR().ac(KEY);
        if (ac == null) {
            return false;
        }
        this.hS = new HandlerThread("glodThread");
        this.hS.start();
        this.mHandler = new Handler(this.hS.getLooper());
        try {
            this.if = ac.bh().getInt(hV);
        } catch (JSONException e) {
            this.if = 25;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return false;
        }
        try {
            this.it = ac.bh().getInt(iq);
        } catch (JSONException e2) {
            this.it = 30000;
        }
        try {
            this.is = ac.bh().getInt(ir);
        } catch (JSONException e3) {
            this.is = 5;
        }
        String string = i.cE().getString(im, null);
        if (string == null) {
            string = ce();
            if (string == null) {
                return false;
            }
            i.cE().putString(im, string);
        }
        final String str = string;
        this.iu = new ArrayList();
        cg();
        this.ix = new Timer();
        this.ix.schedule(new TimerTask() {
            public void run() {
                glod.this.mHandler.post(new Runnable() {
                    public void run() {
                        try {
                            glod.this.iu.add(Float.valueOf(glod.this.ap(str)));
                            int size = glod.this.iu.size();
                            while (glod.this.iu.size() > glod.this.is) {
                                glod.this.iu.remove(0);
                            }
                            if (size >= glod.this.is) {
                                double c = glod.this.cd();
                                if (c <= ((double) glod.this.if)) {
                                    glod.this.iw = PLAYING_STATE.NoPlaying;
                                } else if (glod.this.iw == PLAYING_STATE.NoPlaying) {
                                    i.cE().putLong(glod.il, System.currentTimeMillis());
                                    glod.this.f((int) c);
                                    glod.this.iw = PLAYING_STATE.Playing;
                                }
                            }
                        } catch (Throwable th) {
                            com.appnext.base.b.a(th);
                        }
                    }
                });
            }
        }, 0, (long) (this.it / this.is));
        return true;
    }

    public void unregister() {
        try {
            if (this.ix != null) {
                this.ix.cancel();
            }
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            if (this.hS != null) {
                this.hS.quit();
            }
            cf();
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }
}
