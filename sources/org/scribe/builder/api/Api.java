package org.scribe.builder.api;

import org.scribe.model.a;
import org.scribe.oauth.OAuthService;

public interface Api {
    OAuthService createService(a aVar);
}
