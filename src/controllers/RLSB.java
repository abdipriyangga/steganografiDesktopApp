/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

/**
 *
 * @author mabdipme
 */
public class RLSB {
        public static int[] LCG(int a, int c ,int m,int x0){
    
    
            int[]x = new int[m];
            x[0] = x0;
            
            for(int i = 1; i<m ; i++){
                x[i] = ((a*x[i-1])+c)%m;
                
            }
            
            for(int i = 0; i<m ; i++){
                if(x[i]%2 == 0){
                    x[i] = 2;
                }
                else{
                    x[i] = 1;
                }
            }
            return x;
}
}
