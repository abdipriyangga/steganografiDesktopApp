/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mabdipme
 */
public class LCG {
    int a, b, m, x0;
    int[] listRandom;
    
    public LCG(int a, int b, int m, int x0) {
        this.a = a;
        this.b = b;
        this.m = m;
        this.x0 = x0;
    }
    public int[] getRandom(){
        int  z, j;
        
        
        int[] listRandom = new int[m] ;
        listRandom[1] = x0;
        try {
            for(z = 1; z < m; z++) {
                listRandom[z] = ((a * (listRandom[z - 1])) + b) % m;
//                for(j = z; j < listRandom[z] ; j++){
//                    if(listRandom[j]%2 == 0){
//                        listRandom[j] = 2;
//                        
//                        if(listRandom[j] == 2) {
//                            listRandom[j] = 6;
//                        }
//                    }
//                    else{
//                        listRandom[j] = 1;
//                        
//                        if(listRandom[j] == 1) {
//                            listRandom[j] = 7;
//                        }
//                    }
//                }
            }
            this.listRandom = listRandom;
        } catch(Exception ex) {
            Logger.getLogger(Encoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRandom;
    }
}
