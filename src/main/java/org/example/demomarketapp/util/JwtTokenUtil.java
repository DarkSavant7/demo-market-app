package org.example.demomarketapp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.example.demomarketapp.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


/**
 * Util that working with jwt tokens
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration.minutes:120}")
    private long minutesToExpire;

    public String generateTokenFromUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = user.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", roles);
        claims.put("some1", "some info");
        claims.put("some2", "some info # 2");

        Date issuedDate = new Date();
        Date expired = new Date(issuedDate.getTime() + minutesToExpire * 1000 * 60);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(issuedDate)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public List<String> getRolesFromToken(String token) {
        return getClaimFromToken(token,
                (Function<Claims, List<String>>) claims -> claims.get("roles", List.class));
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsTFunction.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }
}
