///*
//package br.com.matheus.bandeira.infrastructure.components;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//
//@Component
//public class MD5Component {
//
//    public String encrypt(String input) {
//        String md5 = null;
//        if (null == input)
//            return null;
//        try {
//            MessageDigest digest = MessageDigest.getInstance("MD5");
//            digest.update(input.getBytes(), 0, input.length());
//            md5 = new BigInteger(1, digest.digest()).toString(16);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return md5;
//    }
//
//
//    */
///*@Bean
//    public String criptografarSenha(String senha) {
//        MessageDigest md;
//        try {
//            md = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
//        return hash.toString(16);
//    }*//*
//
//
//}
//*/
