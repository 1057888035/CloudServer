package com.cloud.springcloud.entities;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {



        // Token过期时间30分钟
        public static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * @Author lsc
     * <p> 校验token是否正确 </p>
     * @Param token
     * @Param username
     * @Param secret
     * @Return boolean
     */
        public static boolean verify(String token, String username, String secret) {
            try {
                // 设置加密算法
                Algorithm algorithm = Algorithm.HMAC256(secret);
                JWTVerifier verifier = JWT.require(algorithm)
                        .withClaim("username", username)
                        .build();
                // 效验TOKEN
                DecodedJWT jwt = verifier.verify(token);
                return true;
            } catch (Exception exception) {
                return false;
            }
        }



        /**
         * @Author lsc
         * <p>生成签名,30min后过期 </p>
         * @Param [username, secret]
         * @Return java.lang.String
         */
        public static String sign(String username, String secret) {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }

        /**
         * @Author lsc
         * <p> 获得用户名 </p>
         * @Param [request]
         * @Return java.lang.String
         */
        public static String getUserNameByToken(HttpServletRequest request)  {
            String token = request.getHeader("X-Token");
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username")
                    .asString();
        }




}
