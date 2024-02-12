package array_string;

import java.util.Arrays;

public class Remove_Element {
    public static int removeElement(int[] nums,int value){
        int n = nums.length;
        for(int i = 0; i < n; ){
            if(nums[i] == value){
                // Dời tất cả các phần tử còn lại sang trái
                for(int j = i; j < n - 1; j++){
                    nums[j] = nums[j+1];
                }
                // Giảm số lượng phần tử
                n--;
            }
            else{
                //Nếu không phải số cần xóa thì tiếp tục duyệt
                i++;
            }
        }
        return n;
    }
    // Sử dụng kỹ thuật 2 con trỏ
    public static int removeElement2(int[] nums,int value){
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++){
            if(nums[i] != value){
                //nums[k] luôn là phần tử đúng cuối cùng
                nums[k] = nums[i];
                k++;
            }
            //trường hợp nums[i] == value thì bỏ qua
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement2(nums,2));
        System.out.println(Arrays.toString(nums));

    }
}
