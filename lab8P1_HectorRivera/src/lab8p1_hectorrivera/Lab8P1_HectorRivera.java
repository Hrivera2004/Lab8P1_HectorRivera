
package lab8p1_hectorrivera;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class Lab8P1_HectorRivera {
    
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    public static void main(String[] args) {
        System.out.println("-----Menu------");
        System.out.println("1. Game of Life\n2.salir");
        int opc = sc.nextInt();
        while(opc==1){
            System.out.println("Ingrese cuandos rounds se juegan");
            int rounds = sc.nextInt();

            int[][]MatA=gen();

            Game messi = new Game(MatA,rounds);
            messi.getMatA();
            messi.jugar(rounds);
            
            System.out.println("\n-----Menu------");
            System.out.println("1. Game of Life\n2.salir");
            opc = sc.nextInt();
        }//while
        System.out.println("Saliendo del programa");
    }
    
    public static int[][] gen(){
        int[][] gen1=new int[10][10];
        for (int i = 0; i < gen1.length; i++) {
            for (int j = 0; j < gen1[i].length; j++) {
                if((i==0||i==gen1.length-1)||(j==0||j==gen1.length-1)){
                    gen1[i][j]= 0;
                }else{
                    gen1[i][j] = rd.nextInt(1 - 0 + 1) + 0;
                }
            }
        }
        return gen1;
    }
}
