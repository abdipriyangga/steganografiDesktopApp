/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author mabdipme
 */
public class TextData {
    String text;
    
    public void setText(String secret_message){
        this.text = secret_message;
    }
    
    public String getText(){
        return text;
    }
}
