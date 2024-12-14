package com.codefestnepal.dotconnect.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Map;

public class BaseController {
    protected Map<String, Object> getClaims() {
        Authentication auth = getAuthentication();
        return ((Jwt) auth.getPrincipal()).getClaims();
    }

    protected String getClaim(String key) {
        var claims = getClaims();
        return (String) claims.get(key);
    }

    protected String getAgencyId() {
       return  getClaim("id");
    }

    protected String getAgencyName() {
        return  getClaim("name");
    }
    protected String getAgencyUserName() {
        return  getClaim("sub");
    }
    protected String getAgencyRole() {
        return  getClaim("scope");
    }


    protected Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
