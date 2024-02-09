package recursion;

import java.util.Scanner;

public class ThapHaNoi {
    static char[] c = {'A','B','C'};

    public static void thapHaNoi(int n,int i, int j,int k){
        if(n == 1){
            System.out.println("Chuyen dia "+n+" tu cot "+c[i]+" sang cot "+c[j]);
        }
        else{
            thapHaNoi(n-1,i,k,j);
            System.out.println("Chuyen dia "+n+" tu cot "+c[i]+" sang cot "+c[j]);
            thapHaNoi(n-1,k,j,i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        thapHaNoi(n,0,2,1);
    }
}
