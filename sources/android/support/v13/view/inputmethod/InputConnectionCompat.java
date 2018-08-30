package android.support.v13.view.inputmethod;

import android.os.Bundle;

public final class InputConnectionCompat {
    public static int a = 1;

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle);
    }
}
