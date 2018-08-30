package com.google.android.exoplayer.hls;

import java.io.BufferedReader;
import java.util.Queue;

class k {
    private final BufferedReader a;
    private final Queue<String> b;
    private String c;

    public k(Queue<String> queue, BufferedReader bufferedReader) {
        this.b = queue;
        this.a = bufferedReader;
    }

    public boolean a() {
        if (this.c != null) {
            return true;
        }
        if (this.b.isEmpty()) {
            do {
                String readLine = this.a.readLine();
                this.c = readLine;
                if (readLine == null) {
                    return false;
                }
                this.c = this.c.trim();
            } while (this.c.isEmpty());
            return true;
        }
        this.c = (String) this.b.poll();
        return true;
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = this.c;
        this.c = null;
        return str;
    }
}
