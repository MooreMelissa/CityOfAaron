/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
/**
 *
 * @author heatherholt
 */


public class RandomNumbers {

    /* public static void main(String[] args) {
        Random random = new Random();
        int origin = 17;
        int bound = 28;
        int r = 0;
        int n = bound - origin;
            if (n > 0) {
                r =  random.nextInt(n) + origin;
            }

        System.out.println (r);
    }  */
	
	
	private static Random random = new Random();
	
	protected static void setRandom (Random newRandom) {
		random = newRandom;
	}

      
        public static int getRandom (int origin, int bound) {
            return random.nextInt((bound + 1)-origin) + origin;
            
        }
        
}