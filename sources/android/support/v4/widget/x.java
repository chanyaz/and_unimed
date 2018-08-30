package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

public final class x {
    private x() {
    }

    public static void a(@NonNull ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }

    public static boolean b(@NonNull ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            return childCount + firstVisiblePosition < listView.getCount() || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
        } else {
            return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
        }
    }
}
