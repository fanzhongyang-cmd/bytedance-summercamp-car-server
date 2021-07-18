package com.example.cartype.util;

import com.alibaba.fastjson.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.cartype.entity.User;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.codec.binary.Base64;


import javax.lang.model.element.NestingKind;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final long EXPIRE_TIME = 10*60*60*1000;  //将token的有效时间设置为10小时
    private static final String TOKEN_SECRET = "ByteDanceSummerCamp";
    public static Map<Integer,String> tokenMap=new HashMap<>();
//    private static  List<String>
    /**
     *
     * @param user
     * @return String
     */
    public static String sign(User user){
        String token = null;
        try{
            Date expiresAt = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userId",""+user.getId())
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
            System.out.println(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        tokenMap.put(user.getId(),token);
        return token;
    }

    /**
     *
     * @param token
     * @return boolean
     */
    public static boolean verify(String token){
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            String payload = new String(Base64.decodeBase64(jwt.getPayload()));
            JSONObject jsonObject=JSON.parseObject(payload);
            int id=Integer.parseInt(jsonObject.get("userId").toString());
            if(token.equals(tokenMap.get(id))){
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
