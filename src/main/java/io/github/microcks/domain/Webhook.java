package io.github.microcks.domain;

import org.springframework.data.annotation.Id;

public class Webhook {

	@Id
    private String id;
    private String secret;
    private WebhookType type;

    public final String getId() {
        return this.id;
    }
    
    public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
    }
    
	public WebhookType getType() {
		return type;
	}

	public void setType(WebhookType type) {
		this.type = type;
	}

}