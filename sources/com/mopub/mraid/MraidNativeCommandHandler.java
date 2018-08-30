package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.appnext.base.b.c;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MraidNativeCommandHandler {
    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";
    private static final String[] a = new String[]{"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    interface MraidCommandFailureListener {
        void onFailure(a aVar);
    }

    @VisibleForTesting
    class DownloadImageAsyncTask extends AsyncTask<String, Void, Boolean> {
        private final Context a;
        private final DownloadImageAsyncTaskListener b;

        interface DownloadImageAsyncTaskListener {
            void onFailure();

            void onSuccess();
        }

        public DownloadImageAsyncTask(@NonNull Context context, @NonNull DownloadImageAsyncTaskListener downloadImageAsyncTaskListener) {
            this.a = context.getApplicationContext();
            this.b = downloadImageAsyncTaskListener;
        }

        private File a() {
            return new File(Environment.getExternalStorageDirectory(), "Pictures");
        }

        @Nullable
        private String a(@NonNull URI uri, @Nullable Map<String, List<String>> map) {
            Preconditions.checkNotNull(uri);
            String path = uri.getPath();
            if (path == null || map == null) {
                return null;
            }
            String name = new File(path).getName();
            List list = (List) map.get("Content-Type");
            if (list == null || list.isEmpty() || list.get(0) == null) {
                return name;
            }
            for (String str : ((String) list.get(0)).split(";")) {
                if (str.contains("image/")) {
                    path = "." + str.split("/")[1];
                    if (!name.endsWith(path)) {
                        return name + path;
                    }
                    return name;
                }
            }
            return name;
        }

        private void a(String str) {
            Object eVar = new e(str, null, null);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.a, eVar);
            eVar.a(mediaScannerConnection);
            mediaScannerConnection.connect();
        }

        /* renamed from: a */
        protected Boolean doInBackground(@NonNull String[] strArr) {
            Closeable bufferedInputStream;
            Closeable fileOutputStream;
            Boolean valueOf;
            Throwable th;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return Boolean.valueOf(false);
            }
            File a = a();
            a.mkdirs();
            String str = strArr[0];
            URI create = URI.create(str);
            try {
                File file;
                HttpURLConnection httpUrlConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                bufferedInputStream = new BufferedInputStream(httpUrlConnection.getInputStream());
                try {
                    Object headerField = httpUrlConnection.getHeaderField(ResponseHeader.LOCATION.getKey());
                    if (!TextUtils.isEmpty(headerField)) {
                        create = URI.create(headerField);
                    }
                    file = new File(a, a(create, httpUrlConnection.getHeaderFields()));
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    fileOutputStream = null;
                    try {
                        valueOf = Boolean.valueOf(false);
                        Streams.closeStream(bufferedInputStream);
                        Streams.closeStream(fileOutputStream);
                        return valueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        Streams.closeStream(bufferedInputStream);
                        Streams.closeStream(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileOutputStream = null;
                    th = th4;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(fileOutputStream);
                    throw th;
                }
                try {
                    Streams.copyContent(bufferedInputStream, fileOutputStream);
                    a(file.toString());
                    valueOf = Boolean.valueOf(true);
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(fileOutputStream);
                    return valueOf;
                } catch (Exception e2) {
                    valueOf = Boolean.valueOf(false);
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(fileOutputStream);
                    return valueOf;
                }
            } catch (Exception e3) {
                fileOutputStream = null;
                bufferedInputStream = null;
                valueOf = Boolean.valueOf(false);
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(fileOutputStream);
                return valueOf;
            } catch (Throwable th32) {
                bufferedInputStream = null;
                th = th32;
                fileOutputStream = null;
                Streams.closeStream(bufferedInputStream);
                Streams.closeStream(fileOutputStream);
                throw th;
            }
        }

        /* renamed from: a */
        protected void onPostExecute(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                this.b.onFailure();
            } else {
                this.b.onSuccess();
            }
        }
    }

    private String a(int i) {
        switch (i) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + i);
        }
    }

    private Date a(String str) {
        String[] strArr = a;
        int length = strArr.length;
        Date date = null;
        int i = 0;
        while (i < length) {
            try {
                date = new SimpleDateFormat(strArr[i], Locale.US).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException e) {
            }
        }
        return date;
    }

    @TargetApi(14)
    private Map<String, Object> a(Map<String, String> map) {
        Map<String, Object> hashMap = new HashMap();
        if (map.containsKey("description") && map.containsKey("start")) {
            hashMap.put("title", map.get("description"));
            if (!map.containsKey("start") || map.get("start") == null) {
                throw new IllegalArgumentException("Invalid calendar event: start is null.");
            }
            Date a = a((String) map.get("start"));
            if (a != null) {
                hashMap.put("beginTime", Long.valueOf(a.getTime()));
                if (map.containsKey("end") && map.get("end") != null) {
                    a = a((String) map.get("end"));
                    if (a != null) {
                        hashMap.put("endTime", Long.valueOf(a.getTime()));
                    } else {
                        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                    }
                }
                if (map.containsKey("location")) {
                    hashMap.put("eventLocation", map.get("location"));
                }
                if (map.containsKey("summary")) {
                    hashMap.put("description", map.get("summary"));
                }
                if (map.containsKey("transparency")) {
                    hashMap.put("availability", Integer.valueOf(((String) map.get("transparency")).equals("transparent") ? 1 : 0));
                }
                hashMap.put("rrule", b((Map) map));
                return hashMap;
            }
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    private String b(int i) {
        if (i != 0 && i >= -31 && i <= 31) {
            return "" + i;
        }
        throw new IllegalArgumentException("invalid day of month " + i);
    }

    private String b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (parseInt2 == 7) {
                parseInt2 = 0;
            }
            if (!zArr[parseInt2]) {
                stringBuilder.append(a(parseInt2) + ",");
                zArr[parseInt2] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String b(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.containsKey("frequency")) {
            String str = (String) map.get("frequency");
            int parseInt = map.containsKey(c.jw) ? Integer.parseInt((String) map.get(c.jw)) : -1;
            if ("daily".equals(str)) {
                stringBuilder.append("FREQ=DAILY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
            } else if ("weekly".equals(str)) {
                stringBuilder.append("FREQ=WEEKLY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
                if (map.containsKey("daysInWeek")) {
                    str = b((String) map.get("daysInWeek"));
                    if (str == null) {
                        throw new IllegalArgumentException("invalid ");
                    }
                    stringBuilder.append("BYDAY=" + str + ";");
                }
            } else if ("monthly".equals(str)) {
                stringBuilder.append("FREQ=MONTHLY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
                if (map.containsKey("daysInMonth")) {
                    str = c((String) map.get("daysInMonth"));
                    if (str == null) {
                        throw new IllegalArgumentException();
                    }
                    stringBuilder.append("BYMONTHDAY=" + str + ";");
                }
            } else {
                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
            }
        }
        return stringBuilder.toString();
    }

    private String c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (!zArr[parseInt2 + 31]) {
                stringBuilder.append(b(parseInt2) + ",");
                zArr[parseInt2 + 31] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void c(final Context context, final String str, final MraidCommandFailureListener mraidCommandFailureListener) {
        new Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MraidNativeCommandHandler.this.b(context, str, mraidCommandFailureListener);
            }
        }).setCancelable(true).show();
    }

    static boolean c(Context context) {
        return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Intents.deviceCanHandleIntent(context, new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE));
    }

    public static boolean isStorePictureSupported(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && DeviceUtils.isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    void a(@NonNull Context context, @NonNull String str, @NonNull MraidCommandFailureListener mraidCommandFailureListener) {
        if (!isStorePictureSupported(context)) {
            MoPubLog.d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            throw new a("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
        } else if (context instanceof Activity) {
            c(context, str, mraidCommandFailureListener);
        } else {
            Toast.makeText(context, "Downloading image to Picture gallery...", 0).show();
            b(context, str, mraidCommandFailureListener);
        }
    }

    void a(Context context, Map<String, String> map) {
        if (c(context)) {
            try {
                Map a = a((Map) map);
                Intent type = new Intent("android.intent.action.INSERT").setType(ANDROID_CALENDAR_CONTENT_TYPE);
                for (String str : a.keySet()) {
                    Object obj = a.get(str);
                    if (obj instanceof Long) {
                        type.putExtra(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        type.putExtra(str, ((Integer) obj).intValue());
                    } else {
                        type.putExtra(str, (String) obj);
                    }
                }
                type.setFlags(268435456);
                context.startActivity(type);
                return;
            } catch (ActivityNotFoundException e) {
                MoPubLog.d("no calendar app installed");
                throw new a("Action is unsupported on this device - no calendar app installed");
            } catch (Throwable e2) {
                MoPubLog.d("create calendar: invalid parameters " + e2.getMessage());
                throw new a(e2);
            } catch (Throwable e22) {
                MoPubLog.d("could not create calendar event");
                throw new a(e22);
            }
        }
        MoPubLog.d("unsupported action createCalendarEvent for devices pre-ICS");
        throw new a("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    @TargetApi(11)
    boolean a(@NonNull Activity activity, @NonNull View view) {
        if (VersionCode.currentApiLevel().isBelow(VersionCode.HONEYCOMB_MR1)) {
            return false;
        }
        while (view.isHardwareAccelerated() && !Utils.bitMaskContainsFlag(view.getLayerType(), 1)) {
            if (view.getParent() instanceof View) {
                view = (View) view.getParent();
            } else {
                Window window = activity.getWindow();
                return window != null && Utils.bitMaskContainsFlag(window.getAttributes().flags, 16777216);
            }
        }
        return false;
    }

    boolean a(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }

    void b(final Context context, String str, final MraidCommandFailureListener mraidCommandFailureListener) {
        AsyncTasks.safeExecuteOnExecutor(new DownloadImageAsyncTask(context, new DownloadImageAsyncTaskListener() {
            public void onFailure() {
                Toast.makeText(context, "Image failed to download.", 0).show();
                MoPubLog.d("Error downloading and saving image file.");
                mraidCommandFailureListener.onFailure(new a("Error downloading and saving image file."));
            }

            public void onSuccess() {
                MoPubLog.d("Image successfully saved.");
            }
        }), str);
    }

    boolean b(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Intents.deviceCanHandleIntent(context, intent);
    }
}
