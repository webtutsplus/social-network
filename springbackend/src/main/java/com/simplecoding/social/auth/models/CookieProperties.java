package com.simplecoding.social.auth.models;

import lombok.Data;

@Data
public class CookieProperties {
	String domain;
	String path;
	boolean httpOnly;
	boolean secure;
	int maxAgeInMinutes;
}
