package org.scribe.model;

public class c {
    private static d a = new d() {
    };
    private String b;
    private Verb c;

    public String a() {
        return this.b;
    }

    public Verb b() {
        return this.c;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{b(), a()});
    }
}
