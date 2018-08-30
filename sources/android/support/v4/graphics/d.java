package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;

public class d {
    @RestrictTo({Scope.LIBRARY_GROUP})
    public char a;
    @RestrictTo({Scope.LIBRARY_GROUP})
    public float[] b;

    d(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }

    d(d dVar) {
        this.a = dVar.a;
        this.b = b.a(dVar.b, 0, dVar.b.length);
    }

    private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
        double d11 = d9 / ((double) ceil);
        int i = 0;
        cos2 = (sin2 * ((-d3) * sin)) + (cos2 * (d4 * cos));
        sin2 = d10;
        while (i < ceil) {
            double d12 = d8 + d11;
            d10 = Math.sin(d12);
            double cos3 = Math.cos(d12);
            double d13 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * d10);
            double d14 = ((d4 * cos) * d10) + (((d3 * sin) * cos3) + d2);
            double d15 = (((-d3) * cos) * d10) - ((d4 * sin) * cos3);
            cos3 = (cos3 * (d4 * cos)) + (d10 * ((-d3) * sin));
            d10 = Math.tan((d12 - d8) / 2.0d);
            d10 = ((Math.sqrt((d10 * (3.0d * d10)) + 4.0d) - 1.0d) * Math.sin(d12 - d8)) / 3.0d;
            sin2 = (sin2 * d10) + d5;
            double d16 = d6 + (cos2 * d10);
            double d17 = d13 - (d10 * d15);
            d10 = d14 - (d10 * cos3);
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) sin2, (float) d16, (float) d17, (float) d10, (float) d13, (float) d14);
            i++;
            sin2 = d15;
            d8 = d12;
            d6 = d14;
            d5 = d13;
            cos2 = cos3;
        }
    }

    private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double toRadians = Math.toRadians((double) f7);
        double cos = Math.cos(toRadians);
        double sin = Math.sin(toRadians);
        double d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
        double d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
        double d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
        double d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
        double d5 = d - d3;
        double d6 = d2 - d4;
        double d7 = (d + d3) / 2.0d;
        double d8 = (d2 + d4) / 2.0d;
        double d9 = (d5 * d5) + (d6 * d6);
        if (d9 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d10 = (1.0d / d9) - 0.25d;
        if (d10 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d9);
            float sqrt = (float) (Math.sqrt(d9) / 1.99999d);
            a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
            return;
        }
        d9 = Math.sqrt(d10);
        d5 *= d9;
        d6 *= d9;
        if (z == z2) {
            d6 = d7 - d6;
            d5 += d8;
        } else {
            d6 += d7;
            d5 = d8 - d5;
        }
        d7 = Math.atan2(d2 - d5, d - d6);
        d4 = Math.atan2(d4 - d5, d3 - d6) - d7;
        if (z2 != (d4 >= 0.0d)) {
            d4 = d4 > 0.0d ? d4 - 6.283185307179586d : d4 + 6.283185307179586d;
        }
        d = ((double) f5) * d6;
        d5 *= (double) f6;
        a(path, (d * cos) - (d5 * sin), (d * sin) + (d5 * cos), (double) f5, (double) f6, (double) f, (double) f2, toRadians, d7, d4);
    }

    private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
        int i;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        switch (c2) {
            case 'A':
            case 'a':
                i = 7;
                break;
            case 'C':
            case 'c':
                i = 6;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i = 1;
                break;
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't':
                i = 2;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i = 4;
                break;
            case 'Z':
            case 'z':
                path.close();
                path.moveTo(f5, f6);
                f4 = f6;
                f3 = f5;
                f2 = f6;
                f = f5;
                i = 2;
                break;
            default:
                i = 2;
                break;
        }
        int i2 = 0;
        float f7 = f6;
        float f8 = f5;
        float f9 = f2;
        float f10 = f;
        while (i2 < fArr2.length) {
            float f11;
            switch (c2) {
                case 'A':
                    a(path, f10, f9, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f3 = fArr2[i2 + 5];
                    f4 = fArr2[i2 + 6];
                    f6 = f7;
                    f5 = f8;
                    f2 = f3;
                    f = f4;
                    f11 = f3;
                    f3 = f4;
                    break;
                case 'C':
                    path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                    f5 = fArr2[i2 + 4];
                    f6 = fArr2[i2 + 5];
                    f2 = fArr2[i2 + 2];
                    f = f6;
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = fArr2[i2 + 3];
                    break;
                case 'H':
                    path.lineTo(fArr2[i2 + 0], f9);
                    f6 = f7;
                    f2 = f3;
                    f = f9;
                    f11 = fArr2[i2 + 0];
                    f3 = f4;
                    f5 = f8;
                    break;
                case 'L':
                    path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                    f5 = fArr2[i2 + 0];
                    f2 = f3;
                    f = fArr2[i2 + 1];
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'M':
                    f5 = fArr2[i2 + 0];
                    f6 = fArr2[i2 + 1];
                    if (i2 <= 0) {
                        path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f3;
                        f = f6;
                        f11 = f5;
                        f3 = f4;
                        break;
                    }
                    path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                    f2 = f3;
                    f = f6;
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'Q':
                    path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                    f3 = fArr2[i2 + 0];
                    f4 = fArr2[i2 + 1];
                    f5 = fArr2[i2 + 2];
                    f2 = f3;
                    f = fArr2[i2 + 3];
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'S':
                    if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                        f6 = (2.0f * f10) - f3;
                        f3 = (2.0f * f9) - f4;
                    } else {
                        f3 = f9;
                        f6 = f10;
                    }
                    path.cubicTo(f6, f3, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                    f3 = fArr2[i2 + 0];
                    f4 = fArr2[i2 + 1];
                    f5 = fArr2[i2 + 2];
                    f2 = f3;
                    f = fArr2[i2 + 3];
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'T':
                    if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                        f10 = (2.0f * f10) - f3;
                        f9 = (2.0f * f9) - f4;
                    }
                    path.quadTo(f10, f9, fArr2[i2 + 0], fArr2[i2 + 1]);
                    f5 = fArr2[i2 + 0];
                    f3 = f9;
                    f2 = f10;
                    f = fArr2[i2 + 1];
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    break;
                case 'V':
                    path.lineTo(f10, fArr2[i2 + 0]);
                    f5 = f8;
                    f2 = f3;
                    f = fArr2[i2 + 0];
                    f11 = f10;
                    f3 = f4;
                    f6 = f7;
                    break;
                case 'a':
                    a(path, f10, f9, fArr2[i2 + 5] + f10, fArr2[i2 + 6] + f9, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f3 = f10 + fArr2[i2 + 5];
                    f4 = fArr2[i2 + 6] + f9;
                    f6 = f7;
                    f5 = f8;
                    f2 = f3;
                    f = f4;
                    f11 = f3;
                    f3 = f4;
                    break;
                case 'c':
                    path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                    f2 = f10 + fArr2[i2 + 2];
                    f = fArr2[i2 + 5] + f9;
                    f11 = f10 + fArr2[i2 + 4];
                    f6 = f7;
                    f5 = f8;
                    f3 = fArr2[i2 + 3] + f9;
                    break;
                case 'h':
                    path.rLineTo(fArr2[i2 + 0], 0.0f);
                    f6 = f7;
                    f2 = f3;
                    f = f9;
                    f11 = f10 + fArr2[i2 + 0];
                    f3 = f4;
                    f5 = f8;
                    break;
                case 'l':
                    path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                    f2 = f3;
                    f = fArr2[i2 + 1] + f9;
                    f11 = f10 + fArr2[i2 + 0];
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'm':
                    f5 = f10 + fArr2[i2 + 0];
                    f6 = fArr2[i2 + 1] + f9;
                    if (i2 <= 0) {
                        path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f2 = f3;
                        f = f6;
                        f11 = f5;
                        f3 = f4;
                        break;
                    }
                    path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                    f2 = f3;
                    f = f6;
                    f11 = f5;
                    f6 = f7;
                    f5 = f8;
                    f3 = f4;
                    break;
                case 'q':
                    path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                    f2 = f10 + fArr2[i2 + 0];
                    f = fArr2[i2 + 3] + f9;
                    f11 = f10 + fArr2[i2 + 2];
                    f6 = f7;
                    f5 = f8;
                    f3 = fArr2[i2 + 1] + f9;
                    break;
                case 's':
                    if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                        f6 = f10 - f3;
                        f3 = f9 - f4;
                    } else {
                        f3 = 0.0f;
                        f6 = 0.0f;
                    }
                    path.rCubicTo(f6, f3, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                    f2 = f10 + fArr2[i2 + 0];
                    f = fArr2[i2 + 3] + f9;
                    f11 = f10 + fArr2[i2 + 2];
                    f6 = f7;
                    f5 = f8;
                    f3 = fArr2[i2 + 1] + f9;
                    break;
                case 't':
                    if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                        f6 = f10 - f3;
                        f4 = f9 - f4;
                    } else {
                        f4 = 0.0f;
                        f6 = 0.0f;
                    }
                    path.rQuadTo(f6, f4, fArr2[i2 + 0], fArr2[i2 + 1]);
                    f2 = f10 + f6;
                    f = fArr2[i2 + 1] + f9;
                    f11 = f10 + fArr2[i2 + 0];
                    f6 = f7;
                    f5 = f8;
                    f3 = f4 + f9;
                    break;
                case 'v':
                    path.rLineTo(0.0f, fArr2[i2 + 0]);
                    f5 = f8;
                    f2 = f3;
                    f = fArr2[i2 + 0] + f9;
                    f11 = f10;
                    f3 = f4;
                    f6 = f7;
                    break;
                default:
                    f6 = f7;
                    f5 = f8;
                    f2 = f3;
                    f = f9;
                    f11 = f10;
                    f3 = f4;
                    break;
            }
            i2 += i;
            f7 = f6;
            f8 = f5;
            f9 = f;
            f10 = f11;
            c = c2;
            f4 = f3;
            f3 = f2;
        }
        fArr[0] = f10;
        fArr[1] = f9;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f8;
        fArr[5] = f7;
    }

    public static void a(d[] dVarArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (int i = 0; i < dVarArr.length; i++) {
            a(path, fArr, c, dVarArr[i].a, dVarArr[i].b);
            c = dVarArr[i].a;
        }
    }

    public void a(d dVar, d dVar2, float f) {
        for (int i = 0; i < dVar.b.length; i++) {
            this.b[i] = (dVar.b[i] * (1.0f - f)) + (dVar2.b[i] * f);
        }
    }
}
