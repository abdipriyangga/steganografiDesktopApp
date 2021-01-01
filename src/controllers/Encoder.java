/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 *
 * @author mabdipme
 */
public class Encoder {
    BufferedImage cover_image, stego_image,stego_imageCRT;
    private StringBuilder binary;
    private long duration;
    private long start;
    private long finish;
    private int[][] R;
    private int[][] G;
    private int[][] B;
    private String[][] SR;
    private String[][] SG;
    private String[][] SB;
    private String[][] pixelAESR;
    private String[][] pixelAESG;
    private String[][] pixelAESB;
    private int[][] R_aksen;
    private int[][] G_aksen;
    private int[][] B_aksen;
    private int an;
    private int col;
    private int colCRT;
    private int i;
    private int j;
    private int x;
    private int y;
    private int ascii_number;
    private int width;
    private int height;
    private int index_warna;
    String secret_message;
    String binary_secret_message;
    String channel;
    int[][] matrix;
    int[][] matrix_aksen;
    int k;
    int type;
    double time_encoding;
    char[] cbinCipherRSA;
    char[] cbinCipherRSACRT;
    int[] index;
    int panjangcipherRSA,panjangcipherRSACRT;
    public void setCoverImage(BufferedImage cover_image){
        this.cover_image = cover_image;
    }
    
    public void setSecretMessage(String secret_message){
        this.secret_message = secret_message;
    }
    
    public void setKValue(int k){
        this.k = k;
    }
    
    public void setcipherRSA(char[] cbinCipherRSA){
        this.cbinCipherRSA = cbinCipherRSA;
    }
    
    public void setcipherRSACRT(char[] cbinCipherRSACRT){
        this.cbinCipherRSACRT = cbinCipherRSACRT;
    }
    public void setRangeTable(int type){
        this.type = type;
    }
    
    private BufferedImage cloneImage(BufferedImage cover_image){
        this.cover_image = cover_image;
        ColorModel cm = cover_image.getColorModel();
        WritableRaster raster = cover_image.copyData(null);
        return new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);
    }
    
    public void setpanjangRSA(int panjangcRSA){
        this.panjangcipherRSA = panjangcRSA;
    }
     public void setpanjangRSACRT(int panjangcRSACRT){
        this.panjangcipherRSACRT = panjangcRSACRT;
    }
    public int getPanjangcRSA(){
        return this.panjangcipherRSA;
    }
    public int getPanjangcRSACRT(){
        return this.panjangcipherRSACRT;
    }
    public void encode(int panjangcRSA,int panjangcRSACRT,int[] x){
        setpanjangRSA(panjangcRSA);
        setpanjangRSACRT(panjangcRSACRT);
        stego_image = cloneImage(cover_image);
        stego_imageCRT = cloneImage(cover_image);
        width = stego_image.getWidth();
        height = stego_image.getHeight();
        
        //System.out.println("Width :"+width);
        //System.out.println("Height :"+height);
        
        R = new int [width][height];
        G = new int [width][height];
        B = new int [width][height];
        
        SR = new String [width][height];
        SG = new String [width][height];
        SB = new String [width][height];
        
       pixelAESR=new String[width][height];
       pixelAESG=new String[width][height];
       pixelAESB=new String[width][height];
        for (i = 0; i<(width); i++) {
            for (j = 0; j < (height) ; j++) {

                        Color c = new Color(stego_image.getRGB(i,j));
                        //System.out.println("RGB I="+i+" J="+j+"=" +stego_image.getRGB(i, j));
                        R[i][j] = c.getRed();
                        SR[i][j] = Integer.toBinaryString(R[i][j]);
                        while(SR[i][j].length() !=8){
                            SR[i][j] = "0"+SR[i][j];
                        }
                        
                        G[i][j] = c.getGreen();
                        SG[i][j] = Integer.toBinaryString(G[i][j]);
                        while(SG[i][j].length() !=8){
                            SG[i][j] = "0"+SG[i][j];
                        }
                        B[i][j] = c.getBlue();
                        SB[i][j] = Integer.toBinaryString(B[i][j]);
                        while(SB[i][j].length() !=8){
                            SB[i][j] = "0"+SB[i][j];
                        }
                        pixelAESR[i][j]=SR[i][j];
                        pixelAESG[i][j]=SG[i][j];
                        pixelAESB[i][j]=SB[i][j];
                }
        }
       int ulang=0;
       int panjangx = x.length;
       /*for(i=0;i<panjangx;i++){
             System.out.println("X["+i+"]= "+x[i]);
       }
        for (i = 0; i<(width); i++) {
            for (j = 0; j < (height) ; j++) {
                
                        System.out.println("R:["+i+"]["+j+"]"+pixelRSAR[i][j]);
                        
                        System.out.println("G:["+i+"]["+j+"]"+pixelRSAG[i][j]);
                        
                        System.out.println("B:["+i+"]["+j+"]"+pixelRSAB[i][j]);
                        
                }
        }*/
        index = new int[panjangx];
        for(i = 0;i<panjangx;i++){
            if(x[i]==1){
                index[i] = 7;
            }
            else if(x[i]==2){
                index[i] = 6;
            }
        }
//        for(int i = 0;i<index.length;i++){
//            System.out.println("Index["+i+"]="+index[i]);
//        }
        int indexer = 1;
        //MENGUBAH
        for(an=0;an<panjangcipherRSA;an++){
          for(i=0;i<width;i++){
            for(j=0;j<height;j++){
                
               if(an>=panjangcipherRSA){
                   break;
               }
               pixelAESR[i][j]= pixelAESR[i][j].substring(0, index[indexer]) + cbinCipherRSA[an] + pixelAESR[i][j].substring(index[indexer]+1);
               an++;
               
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
                if(an>=panjangcipherRSA){
                   break;
               }
               pixelAESG[i][j]= pixelAESG[i][j].substring(0, index[indexer]) + cbinCipherRSA[an] + pixelAESG[i][j].substring(index[indexer]+1);
               an++;
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
               if(an>=panjangcipherRSA){
                   break;
               }
                pixelAESB[i][j]= pixelAESB[i][j].substring(0, index[indexer]) + cbinCipherRSA[an] + pixelAESB[i][j].substring(index[indexer]+1);
               an++;
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
                indexer++;
            }
            if(an>=panjangcipherRSA){
                   break;
               }
        }  
        }         
        indexer=1;
//        for(an=0;an<panjangcipherRSACRT;an++){
//          for(i=0;i<width;i++){
//            for(j=0;j<height;j++){
//                
//               if(an>=panjangcipherRSACRT){
//                   break;
//               }
//               pixelRSACRTR[i][j]= pixelRSACRTR[i][j].substring(0, index[indexer]) + cbinCipherRSACRT[an] + pixelRSACRTR[i][j].substring(index[indexer]+1);
//               an++;
//               
//               
//                //System.out.println("i = "+i+" J="+j+" AN = "+an);
//                if(an>=panjangcipherRSA){
//                   break;
//               }
//               pixelRSACRTG[i][j]= pixelRSACRTG[i][j].substring(0, index[indexer]) + cbinCipherRSACRT[an] + pixelRSACRTG[i][j].substring(index[indexer]+1);
//               an++;
//               
//                //System.out.println("i = "+i+" J="+j+" AN = "+an);
//               if(an>=panjangcipherRSA){
//                   break;
//               }
//                pixelRSACRTB[i][j]= pixelRSACRTB[i][j].substring(0, index[indexer]) + cbinCipherRSACRT[an] + pixelRSACRTB[i][j].substring(index[indexer]+1);
//               an++;
//               
//                //System.out.println("i = "+i+" J="+j+" AN = "+an);
//                indexer++;
//            }
//            if(an>=panjangcipherRSACRT){
//                   break;
//               }
//        }  
//        }         
//        
        //System.out.println("==============================");
        for (i = 0; i<(width); i++) {
            for (j = 0; j < (height) ; j++) {
                        col = ((Integer.parseInt(pixelAESR[i][j],2)) << 16) | ((Integer.parseInt(pixelAESG[i][j],2)) << 8)|  ((Integer.parseInt(pixelAESB[i][j],2)));
                        stego_image.setRGB(i,j , col);
                        
//                        System.out.println("R2:["+i+"]["+j+"]"+pixelRSAR[i][j]);
//                        System.out.println("G2:["+i+"]["+j+"]"+pixelRSAG[i][j]);
//                        System.out.println("B2:["+i+"]["+j+"]"+pixelRSAB[i][j]);
                          
                }
        }
        
        
        //System.out.println("==============================");
//        for (int a = 0; a<(width); a++) {
//            for (int b = 0; b < (height) ; b++) {
//                        colCRT = ((Integer.parseInt(pixelRSACRTR[a][b],2)) << 16) | ((Integer.parseInt(pixelRSACRTG[a][b],2)) << 8)|  ((Integer.parseInt(pixelRSACRTB[a][b],2)));
//                        stego_imageCRT.setRGB(a,b , colCRT);
                        
//                        System.out.println("R2:["+a+"]["+b+"]"+pixelRSACRTR[a][b]);
//                        System.out.println("G2:["+a+"]["+b+"]"+pixelRSACRTG[a][b]);
//                        System.out.println("B2:["+a+"]["+b+"]"+pixelRSACRTB[a][b]);
//                          
//                }
//        }
        
        
    }
    
    public BufferedImage getStegoImage(){
        return stego_image;
    }
    
    public BufferedImage getStegoImageCRT(){
        return stego_imageCRT;
    }
    
    public double getTimeEncoding(){
        time_encoding = ((double) duration/1000000000.0);
        return time_encoding;
    }
}
