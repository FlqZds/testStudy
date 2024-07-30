package com.ddjc.teststudy.common;

import com.ddjc.teststudy.beans.userDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTutil {

    @Value("${config.jwt.expiration}")
    private long expiration;
    @Value("${config.jwt.secret}")
    private String secret;


    /**
     * 加密 成 token
     */
    public String generateJwt(userDTO member) {

        // 把秘钥变成byte 数组
        byte[] keyBytes = secret.getBytes();
        // 获得密钥对象
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT") //令牌类型
                .setHeaderParam("alg", "HS256") //签名算法
                .setIssuedAt(new Date()) //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)) //过期时间  10扥中
                .claim("userId", member.getUserId())
                .claim("username", member.getUsername())
                .claim("account", member.getAccount())
                .claim("nikname",member.getNikname())
                .claim("avatarUrl", member.getAvatarUrl())
                .claim("roleId", member.getRoleId())
                .claim("roleName",member.getRoleName())
                .claim("userpassword",member.getUserpassword())
                .signWith(key, SignatureAlgorithm.HS256).compact();

        return token;
    }


    /**
     * 把 token 解密成对象的算法
     */
    public userDTO checkJwt(String jwtToken) {

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(this.secret.getBytes()).
                parseClaimsJws(jwtToken);
        // map
        Claims claims = claimsJws.getBody();

        Long userId = claims.get("userId", Long.class);
        String userName = claims.get("username", String.class);
        String nikname = claims.get("nikname", String.class);
        Long account = claims.get("account", Long.class);
        String avatarUrl = claims.get("avatarUrl", String.class);
        Integer roleid = claims.get("roleId", Integer.class);
        String roleName = claims.get("roleName", String.class);
        String userpassword=claims.get("userpassword",String.class);


        return userDTO.builder()
                .userId(userId)
                .roleId(roleid)
                .avatarUrl(avatarUrl)
                .username(userName)
                .account(account)
                .nikname(nikname)
                .roleName(roleName)
                .userpassword(userpassword)
                .build();
    }


}
