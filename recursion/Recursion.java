package recursion;

public class Recursion {
    public static void printf(){
        System.out.println("F");
        printf();
    }

    public static int GiaiThua(int n){
        // Bài toán cơ sở - điều kiện dừng
        if(n == 0)
            return 1;
        // Công thức quy nạp
        int t =  n * GiaiThua(n-1);
        return t;
    }

    // Tìm số fibonacci thứ n
    public static int Fibo(int n){
        System.out.println("F["+n+"]");
        // Bài toán cơ sở
        if(n == 1 || n == 2)
            return 1;
        // Công thứ quy nạp
        int fn =  Fibo(n - 1) + Fibo(n - 2);
        return fn;
    }

    public static void printElement(int[] arr,int index){
        // Bài toán cơ sở
        if(index < 0 || index >= arr.length)
            return;
        // Công thức quy nạp, in phần tử index, print index + 1
        System.out.println(arr[index]);
        printElement(arr,index + 1);
    }

    // in các phần tử từ n - 1 đến 0
    public static void printReverseElement(int[] arr, int index){
        if(index < 0 || index >= arr.length)
            return;
        printReverseElement(arr,index + 1);
        System.out.println(arr[index]);
    }


    // Tối ưu đệ quy
    // Đệ quy có nhớ
    static int[] F = new int [1000];
    public static int Fibo2(int n){
        if(F[n] != 0)
            return F[n];
        System.out.println("F["+n+"]");
        if(n == 1 || n == 2){
            F[1] = 1;
            F[2] = 1;
            return 1;
        }
        F[n] = Fibo2(n - 1) + Fibo2(n - 2);
        return F[n];
    }




    public static void main(String[] args) {
//        printf();
//        System.out.println(GiaiThua(4));
//        System.out.println(Fibo(5));
//       int[] arr = new int[]{1,2,3,4,5};
// printElement(arr,0);
//    printReverseElement(arr,0);
      //  System.out.println(Fibo(10));
        System.out.println(Fibo2(10));


        // Khử đệ quy
        // Sử dụng vòng lặp
        // F[10]
//        int[] FiboM = new int[11];
//        FiboM[1] = 1;
//        FiboM[2] = 1;
//        for (int i = 3; i <= 10; i++){
//            FiboM[i] = FiboM[i - 1] + FiboM[i - 2];
//            System.out.println(FiboM[i]);
//        }

    }
}
