package recursion;

import java.util.Scanner;

public class ThapHaNoi {
    static char[] c = {'A','B','C'};

    public static void thapHaNoi(int n,int nguon, int trunggian,int dich){
        if(n == 1){
            System.out.println("Chuyen dia "+n+" tu cot "+c[nguon]+" sang cot "+c[dich]);
        }
        else{
            thapHaNoi(n-1,nguon,dich,trunggian);
            System.out.println("Chuyen dia "+n+" tu cot "+c[nguon]+" sang cot "+c[dich]);
            thapHaNoi(n-1,trunggian,nguon,dich);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        thapHaNoi(n,0,1,2);
    }
}
