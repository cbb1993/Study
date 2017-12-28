package com.andy.study.数据结构和算法.加密;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES算法加密
 * Created by 坎坎 on 2017/12/26.
 */

public class DESTest {
    public static String test="ahsdhaskldhakjlshd22344===";
    public static final String DES="DES";
    public static byte[] key={ -12 , 117 , -53 , 91 , -83 , 64 , -119 , -42 };
    public static void main(String args[]){
        try {

//            ---------加密----------
            SecretKey secret=new SecretKeySpec(key,DES);
            Cipher cipher=Cipher.getInstance(DES);
            cipher.init(Cipher.ENCRYPT_MODE,secret); //初始化为加密模式
            byte[] cipherByte=cipher.doFinal(test.getBytes("UTF-8")); //加密


            StringBuffer stringBuffer=new StringBuffer();
            for (int i = 0; i < cipherByte.length; i++) {
                if(i==0){
                    stringBuffer.append(cipherByte[i]);
                }else {
                    stringBuffer.append(",").append(cipherByte[i]);
                }
            }

            String str =stringBuffer.toString();
            System.out.println(str);

            String ss[] =str.split(",");

            byte[] bytes =new byte[ss.length];

            for (int i = 0; i < ss.length; i++) {
                bytes[i]= Byte.parseByte(ss[i]);
            }
//            ---------解密--------
            SecretKey secret2=new SecretKeySpec(key,DES);
            Cipher cipher2=Cipher.getInstance(DES);
            cipher2.init(Cipher.DECRYPT_MODE,secret2); //初始化为解密模式
            byte[] cipherBytesss=cipher2.doFinal(bytes);
            String str2=new String(cipherBytesss);
            System.out.println("最终字符串：" +str2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
