package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class bk {
    public static bl<Long> A = bl.a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static bl<Long> B = bl.a("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static bl<Long> C = bl.a("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static bl<Long> D = bl.a("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static bl<Long> E = bl.a("analytics.initialization_warning_threshold", 5000, 5000);
    private static bl<Boolean> F = bl.a("analytics.service_enabled", false, false);
    private static bl<Long> G = bl.a("analytics.max_tokens", 60, 60);
    private static bl<Float> H = bl.a("analytics.tokens_per_sec", 0.5f, 0.5f);
    private static bl<Integer> I = bl.a("analytics.max_stored_hits_per_app", 2000, 2000);
    private static bl<Long> J = bl.a("analytics.min_local_dispatch_millis", 120000, 120000);
    private static bl<Long> K = bl.a("analytics.max_local_dispatch_millis", 7200000, 7200000);
    private static bl<Integer> L = bl.a("analytics.max_hits_per_request.k", 20, 20);
    private static bl<Long> M = bl.a("analytics.service_monitor_interval", 86400000, 86400000);
    private static bl<String> N;
    private static bl<Integer> O = bl.a("analytics.first_party_experiment_variant", 0, 0);
    private static bl<Long> P = bl.a("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    private static bl<Long> Q = bl.a("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static bl<Boolean> a = bl.a("analytics.service_client_enabled", true, true);
    public static bl<String> b = bl.a("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static bl<Integer> c = bl.a("analytics.max_stored_hits", 2000, 20000);
    public static bl<Integer> d = bl.a("analytics.max_stored_properties_per_app", 100, 100);
    public static bl<Long> e = bl.a("analytics.local_dispatch_millis", 1800000, 120000);
    public static bl<Long> f = bl.a("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static bl<Long> g = bl.a("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static bl<Long> h = bl.a("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static bl<Integer> i = bl.a("analytics.max_hits_per_dispatch", 20, 20);
    public static bl<Integer> j = bl.a("analytics.max_hits_per_batch", 20, 20);
    public static bl<String> k;
    public static bl<String> l;
    public static bl<String> m;
    public static bl<String> n;
    public static bl<Integer> o = bl.a("analytics.max_get_length", 2036, 2036);
    public static bl<String> p = bl.a("analytics.batching_strategy.k", zzbk.b.name(), zzbk.b.name());
    public static bl<String> q;
    public static bl<Integer> r = bl.a("analytics.max_hit_length.k", 8192, 8192);
    public static bl<Integer> s = bl.a("analytics.max_post_length.k", 8192, 8192);
    public static bl<Integer> t = bl.a("analytics.max_batch_post_length", 8192, 8192);
    public static bl<String> u;
    public static bl<Integer> v = bl.a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    public static bl<Integer> w = bl.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static bl<Integer> x = bl.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static bl<Long> y = bl.a("analytics.campaigns.time_limit", 86400000, 86400000);
    public static bl<Boolean> z = bl.a("analytics.test.disable_receiver", false, false);

    static {
        String str = "http://www.google-analytics.com";
        k = bl.a("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        l = bl.a("analytics.secure_host", str, str);
        str = "/collect";
        m = bl.a("analytics.simple_endpoint", str, str);
        str = "/batch";
        n = bl.a("analytics.batching_endpoint", str, str);
        str = zzbq.GZIP.name();
        q = bl.a("analytics.compression_strategy.k", str, str);
        str = "404,502";
        u = bl.a("analytics.fallback_responses.k", str, str);
        str = "";
        N = bl.a("analytics.first_party_experiment_id", str, str);
    }
}
