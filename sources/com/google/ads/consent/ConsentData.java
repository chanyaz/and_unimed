package com.google.ads.consent;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;

class ConsentData {
    private static final String SDK_PLATFORM = "android";
    private static final String SDK_VERSION = "1.0.4";
    @SerializedName("providers")
    private HashSet<AdProvider> adProviders = new HashSet();
    @SerializedName("consent_source")
    private String consentSource;
    @SerializedName("consent_state")
    private ConsentStatus consentStatus = ConsentStatus.UNKNOWN;
    @SerializedName("consented_providers")
    private HashSet<AdProvider> consentedAdProviders = new HashSet();
    @SerializedName("has_any_npa_pub_id")
    private boolean hasNonPersonalizedPublisherId = false;
    @SerializedName("is_request_in_eea_or_unknown")
    private boolean isRequestLocationInEeaOrUnknown = false;
    @SerializedName("pub_ids")
    private HashSet<String> publisherIds = new HashSet();
    @SerializedName("raw_response")
    private String rawResponse = "";
    @SerializedName("plat")
    private final String sdkPlatformString = SDK_PLATFORM;
    @SerializedName("version")
    private final String sdkVersionString = SDK_VERSION;
    @SerializedName("tag_for_under_age_of_consent")
    private Boolean underAgeOfConsent = Boolean.valueOf(false);

    ConsentData() {
    }

    HashSet<AdProvider> a() {
        return this.adProviders;
    }

    void a(ConsentStatus consentStatus) {
        this.consentStatus = consentStatus;
    }

    public void a(String str) {
        this.consentSource = str;
    }

    void a(HashSet<AdProvider> hashSet) {
        this.adProviders = hashSet;
    }

    void a(boolean z) {
        this.isRequestLocationInEeaOrUnknown = z;
    }

    ConsentStatus b() {
        return this.consentStatus;
    }

    void b(String str) {
        this.rawResponse = str;
    }

    void b(HashSet<String> hashSet) {
        this.publisherIds = hashSet;
    }

    void b(boolean z) {
        this.hasNonPersonalizedPublisherId = z;
    }

    void c(HashSet<AdProvider> hashSet) {
        this.consentedAdProviders = hashSet;
    }

    boolean c() {
        return this.isRequestLocationInEeaOrUnknown;
    }

    HashSet<AdProvider> d() {
        return this.consentedAdProviders;
    }

    boolean e() {
        return this.hasNonPersonalizedPublisherId;
    }

    public String f() {
        return this.sdkVersionString;
    }

    public String g() {
        return this.sdkPlatformString;
    }
}
