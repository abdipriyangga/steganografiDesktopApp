/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author mabdipme
 */
public class PsnrManager {
    BufferedImage cover_image;
    BufferedImage stego_image;
    private int width;
    private int height;
    private int i;
    private int x;
    private int y;
    private int selisih;
    private double sum;
    double psnr;
    double mse;
    
    public PsnrManager(BufferedImage cover_image, BufferedImage stego_image){
        this.cover_image = cover_image;
        this.stego_image = stego_image;
        width = cover_image.getWidth();
        height = cover_image.getHeight();
    }
    
    public void calculatePSNR(){
        sum = 0;
        for(x=0; x<width; x++){
            for(y=0; y<height; y++){
                for(i=1;i<=3;i++){
                    Color c = new Color(cover_image.getRGB(x, y));
                    Color s  = new Color(stego_image.getRGB(x, y));
                    if(i==1){
                        sum += Math.pow(c.getRed()-s.getRed(),2);
                    }
                    else if(i==2){
                        sum += Math.pow(c.getGreen()-s.getGreen(),2);
                    }
                    else if(i==3){
                        sum += Math.pow(c.getBlue()-s.getBlue(),2);
                    }
                }
            }
        }
        System.out.println(sum);
        mse = sum / (width*height);
        System.out.println(mse);
        psnr = 10*Math.log10(Math.pow(255, 2)/mse);   
        System.out.println("PSNR = "+psnr);
    }
    
    public double getMSE(){
        return mse;
    }

    public double getPSNR(){
        return psnr;
    }
}
