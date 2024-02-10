package recursion;

import java.util.*;

public class BinarySearch {
    public static int BinarySearch(ArrayList<Integer> arr,int n,int k,int left,int right){
        if(left == right){
            if(arr.get(left) == k){
                return left;
            }
            else{
                return -1;
            }
        }
        else{
            int mid = (left + right)/2;
            if(arr.get(mid) == k){
                return mid;
            }
            else{
                // gọi đệ quy
                if(arr.get(mid) < k){
                    return BinarySearch(arr,n,k,mid + 1,right);
                }
                else{
                    return BinarySearch(arr,n,k,left,mid - 1);
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        Random rd = new Random();
        for(int i = 0; i < n; i++){
            arr.add(rd.nextInt(0,101));
        }
        Collections.sort(arr);
        System.out.println("Your array: "+ arr.toString());
        System.out.print("Select an element: ");
        int k = sc.nextInt();

        int result = BinarySearch(arr,n,k,0,n -1);
        System.out.println("Your element is at index: "+ result);



    }
}
