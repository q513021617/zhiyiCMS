package cn.zhiyigo.pblog.Utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET = "jwtsecret";
    public static final String ISS = "echisan";

    private static final Long EXPIRATION = 60 * 60 * 3L; //过期时间3小时

    private static final String ROLE = "role";

    //创建token
    public static String createToken(String username, String role, boolean isRememberMe){
        Map map = new HashMap();

        map.put(ROLE, role);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }

    //从token中获取用户名(此处的token是指去掉前缀之后的)
    public static String getUserName(String token){
        String username;
        try {
            username = getTokenBody(token).getSubject();
        } catch (    Exception e){
            username = null;
        }
        return username;
    }

    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE);
    }

    private static Claims getTokenBody(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch(ExpiredJwtException e){
            e.printStackTrace();

        } catch(UnsupportedJwtException e){
            e.printStackTrace();

        } catch(MalformedJwtException e){
            e.printStackTrace();
        } catch(SignatureException e){
            e.printStackTrace();
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return claims;
    }

    //是否已过期
    public static boolean isExpiration(String token){
        try{
            return getTokenBody(token).getExpiration().before(new Date());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
