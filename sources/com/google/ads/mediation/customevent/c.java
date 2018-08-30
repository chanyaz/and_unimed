package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public final class c extends MediationServerParameters {
    @Parameter(name = "label", required = true)
    public String a;
    @Parameter(name = "class_name", required = true)
    public String b;
    @Parameter(name = "parameter", required = false)
    public String c = null;
}
