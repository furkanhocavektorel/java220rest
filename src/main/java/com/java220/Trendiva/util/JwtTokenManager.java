package com.java220.Trendiva.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.java220.Trendiva.exception.custom.TokenException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

// Json web token
@Service
public class JwtTokenManager {


    String secretKey= "c814d75cb3be27ff333f6a3d0c9353907e7ac4d095598ba3a885a44f8c3e17640b38b4fb677f9a9de9ca1bbfacc47ae93d393861c5be4bae682a03461aeaf76d";

    public Optional<String> createToken(Long id){

        String token = "";

        Long expiresTime=1000*60*60*12l; //12 saat

        try {

            token= JWT.create()
                    .withClaim("id",id)
                    .withClaim("admin-mail","trendiva@info.com")
                    .withClaim("testmetni","benim notum")
                    .withIssuer("java220")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+expiresTime))
                    .sign(Algorithm.HMAC512(secretKey));

            return Optional.of(token);

        }catch (Exception e){
            throw new TokenException("token oluşturulurken hata",2001);
        }


    }

    public Optional<Long> getIdByToken(String token){

        try {

            Algorithm algorithm=Algorithm.HMAC512(secretKey);

            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer("java220").build();

            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            if (decodedJWT==null){
                throw new TokenException("decode jwt boş geldi",2003);
            }
            Optional<Long> id = Optional.of(decodedJWT.getClaim("id").asLong()) ;

            return id;

        }catch (Exception e){
            throw new TokenException("token açma sırasında hata",2002);
        }


    }



}
