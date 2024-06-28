package com.zerobase.user.security;

import java.util.Map;

public class KakaoUserInfo implements SocialUserInfo{
    private final Map<String, Object> attributes;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("id"));
    }


    @Override
    public String getName() {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        return (String) ((Map<String, Object>) kakaoAccount.get("profile")).get("nickname");
    }
}