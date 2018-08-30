package com.puzzlersworld.android.util;

import android.app.Activity;
import android.app.SearchManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.wp.dto.StringConstants;
import mobi.androapp.ac.c8700.R;

public class j {
    public static void a(Menu menu, Activity activity) {
        SearchManager searchManager = (SearchManager) activity.getSystemService("search");
        MenuItem findItem = menu.findItem(R.id.search);
        if (FullscreenActivity.A() == null || (FullscreenActivity.A().getDisableSearchBox() != null && FullscreenActivity.A().getDisableSearchBox().intValue() == 1)) {
            findItem.setVisible(false);
            return;
        }
        SearchView searchView = (SearchView) findItem.getActionView();
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
            searchView.setQueryRefinementEnabled(true);
            searchView.setSubmitButtonEnabled(true);
            searchView.setQueryHint(StringConstants.SEARCH_HINT.getMessage());
        }
    }
}
