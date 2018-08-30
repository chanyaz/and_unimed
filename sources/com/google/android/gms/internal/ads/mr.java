package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzadh
@TargetApi(14)
public final class mr extends Thread implements OnFrameAvailableListener, zzapt {
    private static final float[] a = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean A;
    private volatile boolean B;
    private final mp b;
    private final float[] c;
    private final float[] d;
    private final float[] e;
    private final float[] f;
    private final float[] g;
    private final float[] h;
    private final float[] i;
    private float j;
    private float k;
    private float l;
    private int m;
    private int n;
    private SurfaceTexture o;
    private SurfaceTexture p;
    private int q;
    private int r;
    private int s;
    private FloatBuffer t = ByteBuffer.allocateDirect(a.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch u;
    private final Object v;
    private EGL10 w;
    private EGLDisplay x;
    private EGLContext y;
    private EGLSurface z;

    public mr(Context context) {
        super("SphericalVideoProcessor");
        this.t.put(a).position(0);
        this.c = new float[9];
        this.d = new float[9];
        this.e = new float[9];
        this.f = new float[9];
        this.g = new float[9];
        this.h = new float[9];
        this.i = new float[9];
        this.j = Float.NaN;
        this.b = new mp(context);
        this.b.a((zzapt) this);
        this.u = new CountDownLatch(1);
        this.v = new Object();
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            a("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            a("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            a("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                a("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private static void a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    private static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    private static void b(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    @VisibleForTesting
    private final boolean c() {
        boolean z = false;
        if (!(this.z == null || this.z == EGL10.EGL_NO_SURFACE)) {
            z = (this.w.eglMakeCurrent(this.x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0) | this.w.eglDestroySurface(this.x, this.z);
            this.z = null;
        }
        if (this.y != null) {
            z |= this.w.eglDestroyContext(this.x, this.y);
            this.y = null;
        }
        if (this.x == null) {
            return z;
        }
        z |= this.w.eglTerminate(this.x);
        this.x = null;
        return z;
    }

    public final void a() {
        synchronized (this.v) {
            this.B = true;
            this.p = null;
            this.v.notifyAll();
        }
    }

    public final void a(float f, float f2) {
        float f3;
        float f4;
        if (this.n > this.m) {
            f3 = (1.7453293f * f) / ((float) this.n);
            f4 = (1.7453293f * f2) / ((float) this.n);
        } else {
            f3 = (1.7453293f * f) / ((float) this.m);
            f4 = (1.7453293f * f2) / ((float) this.m);
        }
        this.k -= f3;
        this.l -= f4;
        if (this.l < -1.5707964f) {
            this.l = -1.5707964f;
        }
        if (this.l > 1.5707964f) {
            this.l = 1.5707964f;
        }
    }

    public final void a(int i, int i2) {
        synchronized (this.v) {
            this.n = i;
            this.m = i2;
            this.A = true;
            this.v.notifyAll();
        }
    }

    public final void a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.n = i;
        this.m = i2;
        this.p = surfaceTexture;
    }

    public final SurfaceTexture b() {
        if (this.p == null) {
            return null;
        }
        try {
            this.u.await();
        } catch (InterruptedException e) {
        }
        return this.o;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.s++;
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }

    public final void run() {
        int i = 1;
        if (this.p == null) {
            kk.c("SphericalVideoProcessor started with no output texture.");
            this.u.countDown();
            return;
        }
        boolean z;
        int i2;
        this.w = (EGL10) EGLContext.getEGL();
        this.x = this.w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.x == EGL10.EGL_NO_DISPLAY) {
            z = false;
        } else {
            if (this.w.eglInitialize(this.x, new int[2])) {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGLConfig eGLConfig = (!this.w.eglChooseConfig(this.x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
                if (eGLConfig == null) {
                    z = false;
                } else {
                    this.y = this.w.eglCreateContext(this.x, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    if (this.y == null || this.y == EGL10.EGL_NO_CONTEXT) {
                        z = false;
                    } else {
                        this.z = this.w.eglCreateWindowSurface(this.x, eGLConfig, this.p, null);
                        z = (this.z == null || this.z == EGL10.EGL_NO_SURFACE) ? false : this.w.eglMakeCurrent(this.x, this.z, this.z, this.y);
                    }
                }
            } else {
                z = false;
            }
        }
        amd amd = amn.bj;
        int a = a(35633, !((String) akc.f().a(amd)).equals(amd.b()) ? (String) akc.f().a(amd) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (a == 0) {
            i2 = 0;
        } else {
            amd amd2 = amn.bk;
            int a2 = a(35632, !((String) akc.f().a(amd2)).equals(amd2.b()) ? (String) akc.f().a(amd2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (a2 == 0) {
                i2 = 0;
            } else {
                i2 = GLES20.glCreateProgram();
                a("createProgram");
                if (i2 != 0) {
                    GLES20.glAttachShader(i2, a);
                    a("attachShader");
                    GLES20.glAttachShader(i2, a2);
                    a("attachShader");
                    GLES20.glLinkProgram(i2);
                    a("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(i2, 35714, iArr2, 0);
                    a("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(i2));
                        GLES20.glDeleteProgram(i2);
                        a("deleteProgram");
                        i2 = 0;
                    } else {
                        GLES20.glValidateProgram(i2);
                        a("validateProgram");
                    }
                }
            }
        }
        this.q = i2;
        GLES20.glUseProgram(this.q);
        a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.t);
        a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        a("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        a("genTextures");
        i2 = iArr3[0];
        GLES20.glBindTexture(36197, i2);
        a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("texParameteri");
        this.r = GLES20.glGetUniformLocation(this.q, "uVMat");
        GLES20.glUniformMatrix3fv(this.r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        if (this.q == 0) {
            i = 0;
        }
        if (!z || i == 0) {
            String str = "EGL initialization failed: ";
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.w.eglGetError()));
            valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
            kk.c(valueOf);
            au.i().a(new Throwable(valueOf), "SphericalVideoProcessor.run.1");
            c();
            this.u.countDown();
            return;
        }
        this.o = new SurfaceTexture(i2);
        this.o.setOnFrameAvailableListener(this);
        this.u.countDown();
        this.b.a();
        try {
            this.A = true;
            while (!this.B) {
                while (this.s > 0) {
                    this.o.updateTexImage();
                    this.s--;
                }
                if (this.b.a(this.c)) {
                    if (Float.isNaN(this.j)) {
                        float[] fArr = this.c;
                        float[] fArr2 = new float[]{0.0f, 1.0f, 0.0f};
                        float[] fArr3 = new float[3];
                        fArr3[0] = ((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1])) + (fArr[2] * fArr2[2]);
                        fArr3[1] = ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[5] * fArr2[2]);
                        fArr3[2] = (fArr[8] * fArr2[2]) + ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]));
                        this.j = -(((float) Math.atan2((double) fArr3[1], (double) fArr3[0])) - 1.5707964f);
                    }
                    b(this.h, this.j + this.k);
                } else {
                    a(this.c, -1.5707964f);
                    b(this.h, this.k);
                }
                a(this.d, 1.5707964f);
                a(this.e, this.h, this.d);
                a(this.f, this.c, this.e);
                a(this.g, this.l);
                a(this.i, this.g, this.f);
                GLES20.glUniformMatrix3fv(this.r, 1, false, this.i, 0);
                GLES20.glDrawArrays(5, 0, 4);
                a("drawArrays");
                GLES20.glFinish();
                this.w.eglSwapBuffers(this.x, this.z);
                if (this.A) {
                    GLES20.glViewport(0, 0, this.n, this.m);
                    a("viewport");
                    i2 = GLES20.glGetUniformLocation(this.q, "uFOVx");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.q, "uFOVy");
                    if (this.n > this.m) {
                        GLES20.glUniform1f(i2, 0.87266463f);
                        GLES20.glUniform1f(glGetUniformLocation, (0.87266463f * ((float) this.m)) / ((float) this.n));
                    } else {
                        GLES20.glUniform1f(i2, (0.87266463f * ((float) this.n)) / ((float) this.m));
                        GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
                    }
                    this.A = false;
                }
                try {
                    synchronized (this.v) {
                        if (!(this.B || this.A || this.s != 0)) {
                            this.v.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            kk.e("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            kk.b("SphericalVideoProcessor died.", th);
            au.i().a(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.b.b();
            this.o.setOnFrameAvailableListener(null);
            this.o = null;
            c();
        }
    }

    public final void zznn() {
        synchronized (this.v) {
            this.v.notifyAll();
        }
    }
}
