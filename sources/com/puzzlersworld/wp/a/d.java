package com.puzzlersworld.wp.a;

import android.content.Context;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.StringConstants;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;

public class d implements Interceptor {
    private ExecutorService a;

    public d(ExecutorService executorService) {
        this.a = executorService;
    }

    public ag intercept(Chain chain) {
        ad request = chain.request();
        Context j = InjectibleApplication.j();
        try {
            return chain.proceed(request);
        } catch (SocketTimeoutException e) {
            w.b(this.a, StringConstants.CONNECTION_TIMEOUT.getMessage(), j);
            throw e;
        } catch (IOException e2) {
            w.b(this.a, StringConstants.CANT_CONNECT.getMessage(), j);
            throw e2;
        } catch (Exception e3) {
            w.b(this.a, StringConstants.UNKNOWN_ERROR.getMessage(), j);
            throw e3;
        }
    }
}
