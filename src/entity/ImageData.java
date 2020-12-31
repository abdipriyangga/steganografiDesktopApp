/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.awt.image.BufferedImage;

/**
 *
 * @author mabdipme
 */
public class ImageData {
    BufferedImage image;
    
    public void setImage(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage getImage(){
        return image;
    }
}
