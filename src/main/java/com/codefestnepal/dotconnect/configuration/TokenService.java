package com.codefestnepal.dotconnect.configuration;

import com.codefestnepal.dotconnect.models.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtEncodingException;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder encoder;

    public String generateToken(Authentication authentication) {
        try {
            Instant now = Instant.now();
            String scope = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
            Map<String, Object> userClaims = new HashMap<>();
            JwtClaimsSet.Builder claimsBuilder = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plus(1000, ChronoUnit.HOURS))
                    .subject(authentication.getName())
                    .claim("scope", scope);
            if (authentication.getPrincipal() instanceof Agency) {
                Agency agency = (Agency) authentication.getPrincipal();
                userClaims.put("id",agency.getAgencyId());
                userClaims.put("name",agency.getName());
            }
            userClaims.forEach(claimsBuilder::claim);
            JwtClaimsSet claims = claimsBuilder.build();
            return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
