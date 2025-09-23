package com.hospital.hospitalserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hospital.hospitalserver.domain.entity.HospitalUser;

import java.util.Date;

public class TokenUtils {

    //token到期时间3天:3*24*60*60*1000
    private static final long EXPIRE_TIME= 7*24*60*60*1000;
    //refresh token到期时间7天：7*24*60*60*1000
    private static final long REFRESH_EXPIRE_TIME= 7*24*60*60*1000;
    //密钥盐
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 生成token
     * @param user
     * @return token
     */
    public static String sign(HospitalUser user){

        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("userpass",user.getPassword())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException| JWTCreationException je) {

        }
        return token;
    }


    /**
     * token验证
     * @param token
     * @return true or false
     */
    public static Boolean verify(String token){

        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("userpass: " + decodedJWT.getClaim("userpass").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    /**
     * token自动续期
     * 访问验证token和refreshtoken两个，refreshtoken过期时间远大于token
     * 当token过期但refreshtoken未过期，则调用刷新token方法同时刷新token和refreshtoken的延长时间
     * 如果用户超过refresh的过期时间未进行登录，则让用户返回登录页面
     * @param user
     * @return refreshToken
     */
    public static String refreshToken(HospitalUser user){

        String refreshToken="";
        try {
            Date expireAt=new Date(System.currentTimeMillis()+REFRESH_EXPIRE_TIME);
            refreshToken = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("username",user.getUsername())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException| JWTCreationException je) {

        }
        return refreshToken;
    }

}
