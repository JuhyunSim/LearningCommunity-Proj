package com.zerobase.apigateway.dto;

import com.zerobase.apigateway.enums.Provider;
import com.zerobase.apigateway.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class OAuth2UserDto {

    private Provider provider;
    private String providerId;
    private List<Role> roles;
    private String name;
    private Map<String, Object> attributes;
}
