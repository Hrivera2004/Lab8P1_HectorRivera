/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_hectorrivera;
    import java.util.*; 

public class Game {
    public ArrayList<String> CD= new ArrayList<String>();
    public int[][] MatA;    
    public int[][] MatF= new int[10][10]; 
    public int rd;

    public Game() {
    }

    public Game(int[][] MatA, int[][] MatF, int rd) {
        this.MatA = MatA;
        this.MatF = MatF;
        this.rd = rd;
    }

    public Game(int[][] MatA, int rd) {
        this.MatA = MatA;
        this.rd = rd;
    }
   
    
    public void setCD(ArrayList<String> CD) {
        this.CD = CD;
    }
    public void setMatA(int[][] MatA) {
        this.MatA = MatA;
    }
    public void setMatF(int[][] MatF) {
        this.MatF = MatF;
    }
    public void setRd(int rd) {
        this.rd = rd;
    }
    
    public ArrayList<String> getCD() {
        return CD;
    }
    public int[][] getMatA() {
        return MatA;
    }
    public int[][] getMatF() {
        return MatF;
    }
    public int getRd() {
        return rd;
    }
    
    
    
    
    public void jugar(int rd){
        for (int i = 0; i < rd; i++) {
            nextGen();
            print(CD);
        }
    }
    
    public void nextGen(){
        CD.clear();
        MatF = MatA;
        
        for (int i = 0; i < MatA.length; i++) {
            for (int j = 0; j < MatA[i].length; j++) {
               
                if (MatA[i][j]==1) {//muerte
                    int cont=0;
                    if (MatA[i-1][j-1]==1){//fila 1
                        cont++;
                    }
                    if (MatA[i-1][j]==1){
                        cont++;
                    } 
                    if (MatA[i-1][j+1]==1){
                        cont++;
                    }
                    if (MatA[i][j-1]==1){//fila2
                        cont++;
                    }
                    if (MatA[i][j+1]==1){
                        cont++;
                    }
                    if (MatA[i+1][j-1]==1){//fila3
                        cont++;
                    }
                    if (MatA[i+1][j]==1){
                        cont++;
                    }
                    if (MatA[i+1][j+1]==1) {
                        cont++;
                    }
                    
                    if (cont!=2){
                        MatF[i][j]=0;
                    }
                    
                }
                else if (MatA[i][j]==0 && ((j!=0 && j!=MatA[i].length-1) && (  i!=0 && i!=MatA.length-1)) ) {//revive
                    int cont=0;
                    if (MatA[i-1][j-1]==1){//fila 1
                        cont++;
                    }
                    if (MatA[i-1][j]==1){
                        cont++;
                    } 
                    if (MatA[i-1][j+1]==1){
                        cont++;
                    }
                    if (MatA[i][j-1]==1){//fila2
                        cont++;
                    }
                    if (MatA[i][j+1]==1){
                        cont++;
                    }
                    if (MatA[i+1][j-1]==1){//fila3
                        cont++;
                    }
                    if (MatA[i+1][j]==1){
                        cont++;
                    }
                    if (MatA[i+1][j+1]==1) {
                        cont++;
                    }
                    
                    if (cont==3){
                        MatF[i][j]=1;
                        
                    }
                }
                
                if (MatF[i][j]==1) {
                    CD.add(j+":"+i);
                }
            }
        }
        MatA = MatF;
    }
    
    public void print(ArrayList<String> cd){
        int[][] temp =new int[10][10];
        
        
        
        for (int i = 0; i < cd.size(); i++) {
            String pos=cd.get(i);
            String[] arg = pos.split(":");
            for (int j = 0; j < 1; j++) {
                int x= Integer.parseInt(arg[j]);
                int y= Integer.parseInt(arg[j+1]);  
                temp[y][x]=1;  
            }
            System.out.print("["+cd.get(i)+"]");
        } 
        System.out.println(" ");
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(" ["+temp[i][j]+"] ");
            }
            System.out.println();
        } 
        System.out.println();
    }

        
    
}
