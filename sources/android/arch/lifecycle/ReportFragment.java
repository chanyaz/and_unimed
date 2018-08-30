package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle.Event;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ReportFragment extends Fragment {
    private ActivityInitializationListener a;

    interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a(Event event) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().a(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof d) {
                ((d) lifecycle).a(event);
            }
        }
    }

    private void a(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private void b(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    private void c(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.a);
        a(Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Event.ON_DESTROY);
        this.a = null;
    }

    public void onPause() {
        super.onPause();
        a(Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.a);
        a(Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        b(this.a);
        a(Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(Event.ON_STOP);
    }
}
