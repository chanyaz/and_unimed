package org.scribe.oauth;

import org.scribe.model.Token;
import org.scribe.model.b;
import org.scribe.model.e;

public interface OAuthService {
    Token getAccessToken(Token token, e eVar);

    String getAuthorizationUrl(Token token);

    Token getRequestToken();

    String getVersion();

    void signRequest(Token token, b bVar);
}
