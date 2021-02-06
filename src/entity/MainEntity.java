package entity;

import controllers.LCG;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class MainEntity {
    public BufferedImage doEmbed(BufferedImage stego_image, String secret_message, int[] listLCG){
        int panjang = stego_image.getHeight();
        int lebar   = stego_image.getWidth();
        // INIT ARRAY RGB (COVER)
        int[][] cover = new int[panjang][lebar];
        for(int y = 0; y < panjang; y++){
            for(int x = 0; x < lebar; x++){
                cover[y][x] = stego_image.getRGB(x,y);
            }
        }
        // AMBIL BIT DARI STRING SECRET MESSAGE
        String sm       = "";
        char[] msgBiner = secret_message.toCharArray();
        
        for(int i = 0; i < msgBiner.length;i++){
            int binaryDigits = (int) msgBiner[i];
            String tmpBinary = Integer.toBinaryString(binaryDigits);
//            System.out.println("TMP BINARY: "+tmpBinary);
            sm += String.format("%1$7s" , tmpBinary).replace(" ", "0");
        }
        int indexer = -1 ;
        try{
            for (int counter = 0; counter < panjang * lebar; counter++) {
                int secretBinary = 0;
                if(++indexer < sm.length()) {
                    secretBinary = Integer.parseInt(sm.substring(indexer, indexer + 1)) ;
                }
                // EMBED BINARY
                int axisPanjang = counter/panjang;
                int axisLebar   = counter%lebar;
                
                if(listLCG != null){
                    axisPanjang = listLCG[counter]/panjang;
                    axisLebar   = listLCG[counter]%lebar;
                }
                    
                int red   = (2 * Math.floorDiv((cover[axisPanjang][axisLebar] >> 16) & 0xFF, 2) + secretBinary);
                int green = ((cover[axisPanjang][axisLebar] >> (8) ) & 0xFF );
                int blue  = (cover[axisPanjang][axisLebar] & 0xFF );
                Color pixel = new Color(red, green, blue);
                stego_image.setRGB(axisLebar, axisPanjang, pixel.getRGB());
            }
            
        }
        catch(Exception E){
            System.out.println("ERROR: "+E);
        }
        return stego_image; 
    }
    public String doDecode(BufferedImage stego_image, int[] listLCG){
        String secretMessage = "";
        
        int panjang = stego_image.getHeight();
        int lebar   = stego_image.getWidth();
        
        int[][] arrayRGB = new int[panjang][lebar];
        for(int y = 0; y < panjang; y++){
            for(int x = 0; x < lebar; x++){
                arrayRGB[y][x] = stego_image.getRGB(x,y);
            }
        }
        
        int countDecode = 0;
        String stringBinary = "0";
        // DECODE TEXT
        try {
            for (int counter = 0; counter < panjang * lebar; counter++) {
                // DECODE BINARY SESUAI LCG
                
                int axisPanjang = counter/panjang;
                int axisLebar   = counter%lebar;
                
                if(listLCG != null){
                    axisPanjang = listLCG[counter]/panjang;
                    axisLebar   = listLCG[counter]%lebar;
                }
                
                int red   = (arrayRGB[axisPanjang][axisLebar] >> 16) & 0xFF;
                int secretBinary = red - (2 * Math.floorDiv((arrayRGB[axisPanjang][axisLebar] >> 16) & 0xFF, 2));
                countDecode++;
                stringBinary += String.valueOf(secretBinary);
                if(countDecode == 7){
                    // RESET AWAL BIT
                    countDecode = 0;
                    // SIMPAN KARAKTER STRING BINARY
                    int parseInt    = Integer.parseInt(stringBinary, 2);
//                                System.out.println("AFTER PARSE");
                    if(parseInt == 0){
                        //do nothing
                    }
                    else{
//                        System.out.println("ParseInt: " + parseInt);
                        char charBinary = (char)parseInt;
                        secretMessage += Character.toString(charBinary);
                    }
                    // RESET STRING BINARY
                    stringBinary = "0";
                }
            }
        } catch(Exception E) {
            System.out.println("Error: "+E);
        }
        System.out.println("secret message: "+secretMessage);
        return secretMessage;
    }
    public int[] getLCG(int a, int b, int m, int seed){
        
        LCG lcg = new LCG( a, b, m, seed);
        return lcg.getRandom();
        
    }
}
