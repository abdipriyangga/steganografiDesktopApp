/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mabdipme
 */
public class AES {
//        public static void main(String[] args) throws Exception {
//        String kunciEnkripsi = "huaHaHahahaahahah"; // kunci maksimal 16 karakter
//        String pesanPlainText = "Ini Budi. \nIni Ibu Budi. \nIni Bapak Budi. \nIni Iwan, adik Budi. \nIni kakak Budi, Wati.";
//        String pesanTerenkripsi = encryptAES(pesanPlainText, kunciEnkripsi);
//        String hasilDekripsi = decryptAES(pesanTerenkripsi, kunciEnkripsi);
// 
//        // Tampilkan ke layar
//        System.out.println("PESAN ASLI : \n" + pesanPlainText);
//        System.out.println("\nHASIL ENKRIPSI : \n" + pesanTerenkripsi);
//        System.out.println("\nHASIL DEKRIPSI : \n" + hasilDekripsi);
//    }
// 
    // Method Enkripsi AES
    public static String encryptAES(String Data, String kunciEnkripsi)
    throws Exception {
        Cipher c = Cipher.getInstance("AES");
        Key key = generateKey(kunciEnkripsi);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        // String encryptedValue = new BASE64Encoder().encode(encVal); //
        // deprecated
        String encryptedValue = DatatypeConverter.printBase64Binary(encVal);
        return encryptedValue;
    }
 
    // Method Dekripsi AES
    public static String decryptAES(String encryptedData, String kunciEnkripsi)
            throws Exception {
        Cipher c = Cipher.getInstance("AES");
        Key key = generateKey(kunciEnkripsi);
        c.init(Cipher.DECRYPT_MODE, key);
 
        // byte[] decordedValue = new
        // BASE64Decoder().decodeBuffer(encryptedData); // deprecated
        byte[] decordedValue = DatatypeConverter
                .parseBase64Binary(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
 
    // Method untuk membangkitkan kunci AES dari String
    private static Key generateKey(String kunciEnkripsi) throws Exception {
        Key key = new SecretKeySpec(konversiKeByte(kunciEnkripsi), "AES");
        return key;
    }
 
    // Method untuk konversi String menjadi byte
    private static byte[] konversiKeByte(String kunci) {
        byte[] array_byte = new byte[16];
        int i = 0;
        while (i < kunci.length()) {
            array_byte[i] = (byte) kunci.charAt(i);
            i++;
        }
        if (i < 16) {
            while (i < 16) {
                array_byte[i] = (byte) i;
                i++;
            }
        }
        return array_byte;
    }
}
