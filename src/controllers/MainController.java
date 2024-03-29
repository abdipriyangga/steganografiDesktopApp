package controllers;

import entity.MainEntity;
import java.awt.image.BufferedImage;

public class MainController {
    
    MainEntity entity = new MainEntity();
    // BUAT LCG SEBANYAK NILAI M (CASE: 250 X 250)
    int a  = 30201; //multiplier 5001
    int b  = 29573; //increment 11213
    int m  = 0; //modulus 0 
    int seed = 3; //seed 3
    public MainController() {
    }
    public BufferedImage doRLSB(BufferedImage stego_image, String secret_message){
        //IMAGE SIZE
        int panjang = stego_image.getHeight();
        int lebar   = stego_image.getWidth();
        // LCG
        m             = panjang * lebar;
        int[] listLCG = entity.getLCG(a,b,m,seed);
        // DO EMBED
        stego_image = entity.doEmbed(stego_image, secret_message, listLCG);
        // RETURN STEG IMG
        return stego_image;
    }
    public String doRLSBDecode(BufferedImage stego_image){
        //IMAGE SIZE
        int panjang = stego_image.getHeight();
        int lebar   = stego_image.getWidth();
        // LCG
        m             = panjang * lebar;
        int[] listLCG = entity.getLCG(a,b,m,seed);
        // DO DECODE
        String secretMessage = entity.doDecode(stego_image, listLCG);
        return secretMessage;
    }
    public BufferedImage doLSB(BufferedImage stego_image, String secret_message){
        // DO EMBED
        stego_image = entity.doEmbed(stego_image, secret_message, null);
        // RETURN STEG IMG
        return stego_image;
    }
    public String doLSBDecode(BufferedImage stego_image){
        //IMAGE SIZE
        int panjang = stego_image.getHeight();
        int lebar   = stego_image.getWidth();
        // DO DECODE
        String secretMessage = entity.doDecode(stego_image, null);
        return secretMessage;
    }
}
