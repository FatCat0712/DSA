package array_string;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i: nums2){
            themPhanTuVaoMang(i,nums1,m);
            m++;
        }
    }

    private static void themPhanTuVaoMang(int x, int[] a, int m) {
        boolean isFound = false;
        for(int i = 0; i < m; i++){
            if(a[i] > x){
                isFound = true;
                for (int j = m - 1; j >= i; j--){
                    a[j + 1] = a[j];
                }
                a[i] = x;
                break;
            }
        }
        if(!isFound){
            a[m] = x;
        }
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) -1;

        while(k >= 0){
            if(j < 0){
                nums1[k] = nums1[i];
                i--;
            }
            else if(i < 0){
                nums1[k] = nums2[j];
                j--;
            }
            else if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
    }
    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};

//        merge(n1,4,n2,3);
//        System.out.println(Arrays.toString(n1));
        merge2(n1,3,n2,3);
        System.out.println(Arrays.toString(n1));
    }
}
