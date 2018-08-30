package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.Constants;

@VisibleForTesting
public final class dg {
    public static dh<Long> A = dh.a("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static dh<Long> B = dh.a("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static dh<Long> C = dh.a("measurement.upload.retry_time", 1800000, 1800000);
    public static dh<Integer> D = dh.a("measurement.upload.retry_count", 6, 6);
    public static dh<Long> E = dh.a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static dh<Integer> F = dh.a("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static dh<Integer> G = dh.a("measurement.audience.filter_result_max_count", 200, 200);
    public static dh<Long> H = dh.a("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    public static dh<Boolean> I = dh.a("measurement.test.boolean_flag", false, false);
    public static dh<String> J;
    public static dh<Long> K = dh.a("measurement.test.long_flag", -1, -1);
    public static dh<Integer> L = dh.a("measurement.test.int_flag", -2, -2);
    public static dh<Double> M = dh.a("measurement.test.double_flag", -3.0d, -3.0d);
    public static dh<Boolean> N = dh.a("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
    public static dh<Boolean> O = dh.a("measurement.audience.complex_param_evaluation", false, false);
    public static dh<Boolean> P = dh.a("measurement.validation.internal_limits_internal_event_params", false, false);
    public static dh<Boolean> Q = dh.a("measurement.quality.unsuccessful_update_retry_counter", false, false);
    public static dh<Boolean> R = dh.a("measurement.iid.disable_on_collection_disabled", true, true);
    public static dh<Boolean> S = dh.a("measurement.app_launch.call_only_when_enabled", true, true);
    public static dh<Boolean> T = dh.a("measurement.run_on_worker_inline", true, false);
    public static dh<Boolean> U = dh.a("measurement.reset_analytics.persist_time", false, false);
    private static final jt V;
    private static dh<Boolean> W = dh.a("measurement.log_third_party_store_events_enabled", false, false);
    private static dh<Boolean> X = dh.a("measurement.log_installs_enabled", false, false);
    private static dh<Boolean> Y = dh.a("measurement.log_upgrades_enabled", false, false);
    private static dh<Boolean> Z = dh.a("measurement.log_androidId_enabled", false, false);
    public static dh<Boolean> a = dh.a("measurement.upload_dsid_enabled", false, false);
    private static dh<Boolean> aa = dh.a("measurement.audience.dynamic_filters", false, false);
    public static dh<String> b = dh.a("measurement.log_tag", "FA", "FA-SVC");
    public static dh<Long> c = dh.a("measurement.ad_id_cache_time", 10000, 10000);
    public static dh<Long> d = dh.a("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static dh<Long> e = dh.a("measurement.config.cache_time", 86400000, 3600000);
    public static dh<String> f;
    public static dh<String> g;
    public static dh<Integer> h = dh.a("measurement.upload.max_bundles", 100, 100);
    public static dh<Integer> i = dh.a("measurement.upload.max_batch_size", 65536, 65536);
    public static dh<Integer> j = dh.a("measurement.upload.max_bundle_size", 65536, 65536);
    public static dh<Integer> k = dh.a("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static dh<Integer> l = dh.a("measurement.upload.max_events_per_day", 100000, 100000);
    public static dh<Integer> m = dh.a("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static dh<Integer> n = dh.a("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static dh<Integer> o = dh.a("measurement.upload.max_conversions_per_day", 500, 500);
    public static dh<Integer> p = dh.a("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static dh<Integer> q = dh.a("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static dh<String> r;
    public static dh<Long> s = dh.a("measurement.upload.backoff_period", 43200000, 43200000);
    public static dh<Long> t = dh.a("measurement.upload.window_interval", 3600000, 3600000);
    public static dh<Long> u = dh.a("measurement.upload.interval", 3600000, 3600000);
    public static dh<Long> v = dh.a("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static dh<Long> w = dh.a("measurement.upload.debug_upload_interval", 1000, 1000);
    public static dh<Long> x = dh.a("measurement.upload.minimum_delay", 500, 500);
    public static dh<Long> y = dh.a("measurement.alarm_manager.minimum_interval", 60000, 60000);
    public static dh<Long> z = dh.a("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);

    static {
        String str = "content://com.google.android.gms.phenotype/";
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        V = new jt(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        String str2 = Constants.HTTPS;
        f = dh.a("measurement.config.url_scheme", str2, str2);
        str2 = "app-measurement.com";
        g = dh.a("measurement.config.url_authority", str2, str2);
        str2 = "https://app-measurement.com/a";
        r = dh.a("measurement.upload.url", str2, str2);
        str2 = "---";
        J = dh.a("measurement.test.string_flag", str2, str2);
    }
}
