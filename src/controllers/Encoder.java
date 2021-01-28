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
    private String[][] pixelRlsbR;
    private String[][] pixelRlsbG;
    private String[][] pixelRlsbB;
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
    char[] binPanjangPesanAsli;
    int[] index;
    int panjangcipherRSA,panjangcipherRSACRT, panjangPesanAsli;
    public void setCoverImage(BufferedImage cover_image){
        this.cover_image = cover_image;
    }
    
    public void setSecretMessage(String secret_message){
        this.secret_message = secret_message;
    }
    
    public void setKValue(int k){
        this.k = k;
    }
    
    public void setBinPesanAsli(char[] binPanjangPesanAsli) {
        this.binPanjangPesanAsli = binPanjangPesanAsli;
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
    
    public BufferedImage cloneImage(BufferedImage cover_image){
        this.cover_image = cover_image;
        ColorModel cm = cover_image.getColorModel();
        WritableRaster raster = cover_image.copyData(null);
        return new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);
    }
    public void setPanjangPesanAsli(int panjangBinPesanAsli) {
        this.panjangPesanAsli = panjangBinPesanAsli;
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
    public int getPanjangPesanAsli(){
        return this.panjangPesanAsli;
    }
    public void encodeRlsb(int panjangBinPesanAsli, int[] x) {
        setPanjangPesanAsli(panjangBinPesanAsli);
        stego_image = cloneImage(cover_image);
        width = stego_image.getWidth();
        height = stego_image.getHeight();
        R = new int [width][height];
        G = new int [width][height];
        B = new int [width][height];
        
        SR = new String [width][height];
        SG = new String [width][height];
        SB = new String [width][height];
        
        pixelRlsbR=new String[width][height];
        pixelRlsbG=new String[width][height];
        pixelRlsbB=new String[width][height];
        for (i = 0; i < (width); i++) {
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
            }
        }
       int ulang=0;
       int panjangx = x.length;
     
       index = new int[panjangx];
       for(i = 0;i<panjangx;i++){
           if(x[i]==1){
              index[i] = 7;
           }
           else if(x[i]==2){
              index[i] = 6;
           }
        }
       
        int indexer = 1;
        //MENGUBAH
        for(an=0;an < panjangPesanAsli;an++){
          for(i=0;i < width;i++){
            for(j=0;j < height;j++){
                
               if(an >= panjangPesanAsli){
                   break;
               }
               pixelRlsbR[i][j]= pixelRlsbR[i][j].substring(0, index[indexer]) + binPanjangPesanAsli[an] + pixelRlsbR[i][j].substring(index[indexer]+1);
               an++;
               
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
                if(an>=panjangPesanAsli){
                   break;
               }
               pixelRlsbG[i][j]= pixelRlsbG[i][j].substring(0, index[indexer]) + binPanjangPesanAsli[an] + pixelRlsbG[i][j].substring(index[indexer]+1);
               an++;
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
               if(an>=panjangPesanAsli){
                   break;
               }
                pixelRlsbB[i][j]= pixelRlsbB[i][j].substring(0, index[indexer]) + binPanjangPesanAsli[an] + pixelRlsbB[i][j].substring(index[indexer]+1);
               an++;
               
                //System.out.println("i = "+i+" J="+j+" AN = "+an);
                indexer++;
            }
            if(an>=panjangPesanAsli){
                   break;
            }
        }  
        }         
        indexer=1;
        for (i = 0; i<(width); i++) {
            for (j = 0; j < (height) ; j++) {
                col = ((Integer.parseInt(pixelRlsbR[i][j],2)) << 16) | ((Integer.parseInt(pixelRlsbG[i][j],2)) << 8)|  ((Integer.parseInt(pixelRlsbB[i][j],2)));
                stego_image.setRGB(i,j , col);         
            }
        }
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
