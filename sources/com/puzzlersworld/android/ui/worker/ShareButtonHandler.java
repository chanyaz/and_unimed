package com.puzzlersworld.android.ui.worker;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.PermissionCallBack;
import com.puzzlersworld.android.util.i;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.dto.Post;
import com.puzzlersworld.wp.dto.StringConstants;
import com.squareup.picasso.Picasso;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;

public class ShareButtonHandler implements PermissionCallBack {
    public static final int SHARE_REQUEST_CODE = 4423;
    private PackageInfo INFO = null;
    private Activity activity;
    private ListeningScheduledExecutorService backgroundExecutor;
    private int id;
    @Inject
    i permissionCall;
    private Post post;
    private int requestCode;

    public ShareButtonHandler(ListeningScheduledExecutorService listeningScheduledExecutorService) {
        this.backgroundExecutor = listeningScheduledExecutorService;
        InjectibleApplication.a((Object) this);
    }

    private Intent createSendIntent(Post post, Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (post.getShareText() != null) {
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(post.getShareText()).toString());
        } else {
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(post.getExcerpt()).toString());
        }
        intent.putExtra("android.intent.extra.SUBJECT", StringConstants.SHARE_TITLE.getMessage());
        if (post.getShareImage() != null) {
            try {
                String saveImageFileToDisk = saveImageFileToDisk(post.getShareImage(), activity, "share_1343434423.jpg", false);
                Log.d("Androapp: Path: ", saveImageFileToDisk);
                if (saveImageFileToDisk != null) {
                    intent.putExtra("android.intent.extra.STREAM", FileProvider.a(activity, activity.getPackageName() + ".provider", new File(saveImageFileToDisk)));
                    intent.setType("image/jpeg");
                }
            } catch (Exception e) {
                e.printStackTrace();
                intent.setType("text/plain");
            }
            intent.addFlags(1);
        } else {
            intent.setType("text/plain");
        }
        return intent;
    }

    private Bitmap getImageBitMap(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            return null;
        }
    }

    private boolean isBackgroundNeeded(Activity activity, Post post) {
        return true;
    }

    private boolean onShareButtonClickHandler(final int i, final Activity activity, final Post post) {
        if (isBackgroundNeeded(activity, post)) {
            this.backgroundExecutor.execute(new Runnable() {
                public void run() {
                    Log.d("Androapp: ", "Going in background");
                    ShareButtonHandler.this.shareInBackground(i, activity, post);
                }
            });
        } else {
            Log.d("Androapp: ", "Not Going in background");
            shareInBackground(i, activity, post);
        }
        return true;
    }

    private void shareInBackground(int i, Activity activity, Post post) {
        Log.d("FeedDetail", "Clicked on share button");
        Intent createSendIntent = createSendIntent(post, activity);
        Intent createChooser = Intent.createChooser(createSendIntent, StringConstants.SELECT.getMessage());
        if (getExtraInitialIntents(post, activity, createChooser, createSendIntent).length > 0) {
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", getExtraInitialIntents(post, activity, createChooser, createSendIntent));
        }
        activity.startActivity(createChooser);
    }

    private String writeFileToDisk(Bitmap bitmap, String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + str);
        try {
            file.createNewFile();
            new FileOutputStream(file).write(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            Log.d("AndroApp:", "Error in saving file");
            e.printStackTrace();
        }
        return Environment.getExternalStorageDirectory() + File.separator + str;
    }

    public void generateHashKeyForFacebook(Context context) {
        try {
            this.INFO = context.getPackageManager().getPackageInfo("com.puzzlersworld.android", 64);
            if (this.INFO == null) {
                Toast.makeText(context.getApplicationContext(), "Invalid Package Name / Package not found", 1).show();
                return;
            }
            for (Signature signature : this.INFO.signatures) {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(signature.toByteArray());
                Log.d("KeyHash: =>", Base64.encodeToString(instance.digest(), 0));
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    public LabeledIntent[] getExtraInitialIntents(Post post, Activity activity, Intent intent, Intent intent2) {
        int i = 0;
        String obj = post.getShareText() != null ? Html.fromHtml(post.getShareText()).toString() : Html.fromHtml(post.getExcerpt()).toString();
        PackageManager packageManager = activity.getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(intent2, 0);
        List arrayList = new ArrayList();
        while (i < queryIntentActivities.size()) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str = resolveInfo.activityInfo.packageName;
            if (str.equals("com.facebook.katana")) {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                intent3.setAction("android.intent.action.SEND");
                intent3.setType("text/plain");
                intent3.putExtra("android.intent.extra.TEXT", obj);
                arrayList.add(new LabeledIntent(intent3, str, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
            }
            i++;
        }
        return (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]);
    }

    public boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public void onPermissionsDenied(int i, Object obj) {
        if (i == this.requestCode) {
            w.a("android.permission.WRITE_EXTERNAL_STORAGE".toString() + " " + StringConstants.PERMISSION_NEEDED.getMessage(), this.activity);
        }
    }

    public void onPermissionsGranted(int i, Object obj) {
        if (i == this.requestCode) {
            onShareButtonClickHandler(i, this.activity, this.post);
        }
    }

    public boolean onShareButtonClick(int i, Activity activity, Post post) {
        this.requestCode = SHARE_REQUEST_CODE;
        this.activity = activity;
        this.post = post;
        this.id = i;
        this.permissionCall.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, SHARE_REQUEST_CODE, null, this);
        return true;
    }

    public String saveImageFileToDisk(String str, Activity activity, String str2, boolean z) {
        Bitmap b = Picasso.a((Context) activity).a(str).b();
        if (b == null) {
            b = getImageBitMap(str);
        }
        Log.d("Androapp: Image:", str);
        return z ? saveImageToExternal(str2, b, activity) : writeFileToDisk(b, str2);
    }

    public String saveImageToExternal(String str, Bitmap bitmap, Activity activity) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + activity.getString(R.string.app_name));
        externalStoragePublicDirectory.mkdirs();
        File file = new File(externalStoragePublicDirectory, str + ".png");
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            MediaScannerConnection.scanFile(activity, new String[]{file.getAbsolutePath()}, null, new OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    Log.i("ExternalStorage", "Scanned " + str + ":");
                    Log.i("ExternalStorage", "-> uri=" + uri);
                }
            });
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new IOException();
        }
    }
}
