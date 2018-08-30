package com.mopub.common.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.ScribeCategory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ErrorEvent extends BaseEvent {
    @Nullable
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;
    @Nullable
    private final Integer g;

    public class Builder extends com.mopub.common.event.BaseEvent.Builder {
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private Integer g;

        public Builder(@NonNull Name name, @NonNull Category category, double d) {
            super(ScribeCategory.EXCHANGE_CLIENT_ERROR, name, category, d);
        }

        @NonNull
        public ErrorEvent build() {
            return new ErrorEvent(this);
        }

        @NonNull
        public Builder withErrorClassName(@Nullable String str) {
            this.e = str;
            return this;
        }

        @NonNull
        public Builder withErrorExceptionClassName(@Nullable String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public Builder withErrorFileName(@Nullable String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public Builder withErrorLineNumber(@Nullable Integer num) {
            this.g = num;
            return this;
        }

        @NonNull
        public Builder withErrorMessage(@Nullable String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public Builder withErrorMethodName(@Nullable String str) {
            this.f = str;
            return this;
        }

        @NonNull
        public Builder withErrorStackTrace(@Nullable String str) {
            this.c = str;
            return this;
        }

        @NonNull
        public Builder withException(@Nullable Exception exception) {
            this.a = exception.getClass().getName();
            this.b = exception.getMessage();
            Writer stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            this.c = stringWriter.toString();
            if (exception.getStackTrace().length > 0) {
                this.d = exception.getStackTrace()[0].getFileName();
                this.e = exception.getStackTrace()[0].getClassName();
                this.f = exception.getStackTrace()[0].getMethodName();
                this.g = Integer.valueOf(exception.getStackTrace()[0].getLineNumber());
            }
            return this;
        }
    }

    private ErrorEvent(@NonNull Builder builder) {
        super(builder);
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
    }

    @Nullable
    public String getErrorClassName() {
        return this.e;
    }

    @Nullable
    public String getErrorExceptionClassName() {
        return this.a;
    }

    @Nullable
    public String getErrorFileName() {
        return this.d;
    }

    @Nullable
    public Integer getErrorLineNumber() {
        return this.g;
    }

    @Nullable
    public String getErrorMessage() {
        return this.b;
    }

    @Nullable
    public String getErrorMethodName() {
        return this.f;
    }

    @Nullable
    public String getErrorStackTrace() {
        return this.c;
    }

    public String toString() {
        return super.toString() + "ErrorEvent\n" + "ErrorExceptionClassName: " + getErrorExceptionClassName() + "\n" + "ErrorMessage: " + getErrorMessage() + "\n" + "ErrorStackTrace: " + getErrorStackTrace() + "\n" + "ErrorFileName: " + getErrorFileName() + "\n" + "ErrorClassName: " + getErrorClassName() + "\n" + "ErrorMethodName: " + getErrorMethodName() + "\n" + "ErrorLineNumber: " + getErrorLineNumber() + "\n";
    }
}
