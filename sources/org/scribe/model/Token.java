package org.scribe.model;

import java.io.Serializable;

public class Token implements Serializable {
    private static final long serialVersionUID = 715000866082812683L;
    private final String a;
    private final String b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        return this.a.equals(token.a) && this.b.equals(token.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.a, this.b});
    }
}
