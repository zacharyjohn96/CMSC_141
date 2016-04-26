/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rule_30;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ZacharyJohn
 */
public class Rule_30{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array length (nxn): \n\tn = ");
        int n = sc.nextInt();
        TheRule tr = new TheRule();
        tr.init(n);
        tr.follow(); 
    }
}

class TheRule {
    
    private char[][] cell;
    private int n = 0;
    
    public void init(int n){
        this.n = n;
        cell = new char[n][n];
        for(int i=0; i<n; i++){
                if(i==n/2){
                    cell[0][i]='1';
                }
                else
                    cell[0][i]='0';
            }
        System.out.println(cell[0]);
    }
    
    public void follow(){
            System.out.println("Follow");
            //System.out.println(Arrays.toString(cell[0]));
            StringBuilder sb;
            for(int i=1; i<n; i++){
                for(int j=1; j<n-1; j++){
                    sb  = new StringBuilder();
                    sb.append(cell[i-1][j-1]);
                    sb.append(cell[i-1][j]);
                    sb.append(cell[i-1][j+1]);
//                    System.out.println(sb.toString());
//                    System.out.println(condition(sb.toString()));
                    cell[i][j]=condition(sb.toString());
                }
                cell[i][0]='0';
                cell[i][n-1]='0';
            }
            //display
            for(int i=0; i<n; i++){
                System.out.println("");
                for(int j=0; j<n; j++){
                    if(cell[i][j]=='1')
                        System.out.print("#");
                    else
                        System.out.print(" ");
                    
                
            }
        }
    }
        
    public char condition(String cond){
        if("111".equals(cond) || "110".equals(cond) || "101".equals(cond) || "000".equals(cond))
            return '0';
        else if("100".equals(cond) || "011".equals(cond) || "010".equals(cond) || "001".equals(cond))
            return '1';
        else
            return '0';
    }
}