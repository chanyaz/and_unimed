package com.mopub.nativeads;

import android.support.annotation.NonNull;
import com.appnext.base.b.c;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PositioningRequest extends JsonRequest<MoPubClientPositioning> {
    public PositioningRequest(String str, Listener<MoPubClientPositioning> listener, ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    private void a(@NonNull JSONArray jSONArray, @NonNull MoPubClientPositioning moPubClientPositioning) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int optInt = jSONObject.optInt("section", 0);
            if (optInt < 0) {
                throw new JSONException("Invalid section " + optInt + " in JSON response");
            }
            if (optInt <= 0) {
                int i2 = jSONObject.getInt("position");
                if (i2 < 0 || i2 > 65536) {
                    throw new JSONException("Invalid position " + i2 + " in JSON response");
                }
                moPubClientPositioning.addFixedPosition(i2);
            }
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull MoPubClientPositioning moPubClientPositioning) {
        int i = jSONObject.getInt(c.jw);
        if (i < 2 || i > 65536) {
            throw new JSONException("Invalid interval " + i + " in JSON response");
        }
        moPubClientPositioning.enableRepeatingPositions(i);
    }

    @NonNull
    @VisibleForTesting
    MoPubClientPositioning a(@NonNull String str) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("error", null);
        if (optString == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("fixed");
            jSONObject = jSONObject.optJSONObject("repeating");
            if (optJSONArray == null && jSONObject == null) {
                throw new JSONException("Must contain fixed or repeating positions");
            }
            MoPubClientPositioning moPubClientPositioning = new MoPubClientPositioning();
            if (optJSONArray != null) {
                a(optJSONArray, moPubClientPositioning);
            }
            if (jSONObject != null) {
                a(jSONObject, moPubClientPositioning);
            }
            return moPubClientPositioning;
        } else if (optString.equalsIgnoreCase("WARMING_UP")) {
            throw new MoPubNetworkError(Reason.WARMING_UP);
        } else {
            throw new JSONException(optString);
        }
    }

    protected Response<MoPubClientPositioning> a(NetworkResponse networkResponse) {
        if (networkResponse.statusCode != 200) {
            return Response.error(new VolleyError(networkResponse));
        }
        if (networkResponse.data.length == 0) {
            return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
        }
        try {
            return Response.success(a(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable e) {
            return Response.error(new VolleyError("Couldn't parse JSON from Charset", e));
        } catch (Throwable e2) {
            return Response.error(new VolleyError("JSON Parsing Error", e2));
        } catch (VolleyError e3) {
            return Response.error(e3);
        }
    }

    /* renamed from: a */
    protected void deliverResponse(MoPubClientPositioning moPubClientPositioning) {
        super.deliverResponse(moPubClientPositioning);
    }
}
