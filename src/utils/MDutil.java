package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDutil {
    /**
     *
     * @param data
     * @return
     */
    public static String SHA256(String data) {
        MessageDigest md = null;
        byte[] sha = new byte[256];
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            MessageDigest tc1 = (MessageDigest) md.clone();
            sha = tc1.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return byte2hex(sha);
    }

    /**
     * 二行制转字符串
     * @param b
     * @return
     */
    static String byte2hex(byte[] b) {
        String hs="";
        String stmp="";
        for (int n=0;n<b.length;n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length()==1) hs = hs + "0" + stmp;
            else hs = hs + stmp;
        }
        return hs.toUpperCase();
    }
}
