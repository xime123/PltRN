package com.juzix.plt.service.crypt;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSA {

    private static final String PUBLIC_KEY   = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrjDEknDbZKKMQHwfOCiyDVEi+6d7EzVJVALwnfH73Rxxj3a5lnx0R/evaUCpNOv4ee+97msi3oUa8KGWdSt1U0Wbb01zkIVvVixM2h9ieXhdIq7V1fD3W+2z5gz7AlOTWX0ORm4cUPUzFzzdUFOl3YkiFIldOK6BphDStDzEnsQIDAQAB";
    private static final String CHARSET_NAME = "utf-8";

    private static RSAPublicKey getPublicKey(String pubKey) {
        try {
            byte[]             buffer     = Base64.decode(pubKey, Base64.DEFAULT);
            KeyFactory         keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec    = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 加密
     *
     * @param plainText 待解密内容
     * @return
     */
    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(PUBLIC_KEY));// 初始化
            byte[] result = cipher.doFinal(plainText.getBytes(CHARSET_NAME));
            return Base64.encodeToString(result, Base64.DEFAULT); // 加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 解密
     *
     * @param cipherText 待解密内容
     * @return
     */
    public static String decrypt(String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, getPublicKey(PUBLIC_KEY));// 初始化
            byte[] result = cipher.doFinal(Base64.decode(cipherText, Base64.DEFAULT));
            return new String(result, CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
