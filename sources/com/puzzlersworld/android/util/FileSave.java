package com.puzzlersworld.android.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.wp.dto.StringConstants;
import java.io.IOException;
import javax.inject.Inject;

public class FileSave implements PermissionCallBack {
    public static final int SAVE_IMAGE_TO_DISK = 3323;
    private Activity activity;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService backgroundExecutor;
    private ImageView expandedImageView;
    @Inject
    i permissionCall;
    @ForUi
    @Inject
    ListeningExecutorService uiExecutor;
    private String url;

    private void saveImageToDiskHelper(final ImageView imageView, final String str, final Activity activity) {
        this.backgroundExecutor.execute(new Runnable() {
            public void run() {
                try {
                    Drawable drawable = imageView.getDrawable();
                    Bitmap bitmap = null;
                    if (drawable != null && (drawable instanceof BitmapDrawable)) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    }
                    if (bitmap != null) {
                        ((FullscreenActivity) activity).B().saveImageToExternal(w.a(), bitmap, activity);
                    } else {
                        ((FullscreenActivity) activity).B().saveImageFileToDisk(str, activity, w.a(), true);
                    }
                    w.a(FileSave.this.uiExecutor, "✓", activity);
                } catch (IOException e) {
                    w.a(FileSave.this.uiExecutor, StringConstants.UNKNOWN_ERROR.getMessage(), activity);
                }
            }
        });
    }

    public void onPermissionsDenied(int i, Object obj) {
        w.a("android.permission.WRITE_EXTERNAL_STORAGE".toString() + " " + StringConstants.PERMISSION_NEEDED.getMessage(), this.activity);
    }

    public void onPermissionsGranted(int i, Object obj) {
        saveImageToDiskHelper(this.expandedImageView, this.url, this.activity);
    }

    public void saveImageToDisk(ImageView imageView, String str, Activity activity) {
        InjectibleApplication.a((Object) this);
        this.url = str;
        this.activity = activity;
        this.expandedImageView = imageView;
        this.permissionCall.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, SAVE_IMAGE_TO_DISK, null, this);
    }
}
