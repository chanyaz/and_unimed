package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.util.m;

abstract class a {
    public static final int A = m.c("esds");
    public static final int B = m.c("moof");
    public static final int C = m.c("traf");
    public static final int D = m.c("mvex");
    public static final int E = m.c("tkhd");
    public static final int F = m.c("mdhd");
    public static final int G = m.c("hdlr");
    public static final int H = m.c("stsd");
    public static final int I = m.c("pssh");
    public static final int J = m.c("sinf");
    public static final int K = m.c("schm");
    public static final int L = m.c("schi");
    public static final int M = m.c("tenc");
    public static final int N = m.c("encv");
    public static final int O = m.c("enca");
    public static final int P = m.c("frma");
    public static final int Q = m.c("saiz");
    public static final int R = m.c("uuid");
    public static final int S = m.c("senc");
    public static final int T = m.c("pasp");
    public static final int U = m.c("TTML");
    public static final int V = m.c("vmhd");
    public static final int W = m.c("smhd");
    public static final int X = m.c("mp4v");
    public static final int Y = m.c("stts");
    public static final int Z = m.c("stss");
    public static final int a = m.c("ftyp");
    public static final int aa = m.c("ctts");
    public static final int ab = m.c("stsc");
    public static final int ac = m.c("stsz");
    public static final int ad = m.c("stco");
    public static final int ae = m.c("co64");
    public static final int af = m.c("tx3g");
    public static final int b = m.c("avc1");
    public static final int c = m.c("avc3");
    public static final int d = m.c("hvc1");
    public static final int e = m.c("hev1");
    public static final int f = m.c("s263");
    public static final int g = m.c("d263");
    public static final int h = m.c("mdat");
    public static final int i = m.c("mp4a");
    public static final int j = m.c("ac-3");
    public static final int k = m.c("dac3");
    public static final int l = m.c("ec-3");
    public static final int m = m.c("dec3");
    public static final int n = m.c("tfdt");
    public static final int o = m.c("tfhd");
    public static final int p = m.c("trex");
    public static final int q = m.c("trun");
    public static final int r = m.c("sidx");
    public static final int s = m.c("moov");
    public static final int t = m.c("mvhd");
    public static final int u = m.c("trak");
    public static final int v = m.c("mdia");
    public static final int w = m.c("minf");
    public static final int x = m.c("stbl");
    public static final int y = m.c("avcC");
    public static final int z = m.c("hvcC");
    public final int ag;

    public a(int i) {
        this.ag = i;
    }

    public static int a(int i) {
        return (i >> 24) & 255;
    }

    public static int b(int i) {
        return 16777215 & i;
    }

    public static String c(int i) {
        return "" + ((char) (i >> 24)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public String toString() {
        return c(this.ag);
    }
}
