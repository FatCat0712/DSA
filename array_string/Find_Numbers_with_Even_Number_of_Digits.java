package array_string;

public class Find_Numbers_with_Even_Number_of_Digits {
    public static int findNumbers(int[] nums){
        int count = 0;
        for (int i: nums){
            //Kiểm tra số chữ số của a
            // Nếu số chữ số là chẵn => tăng biến đếm lên 1
            if(tinhSoChuSo(i) % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static int tinhSoChuSo(int a) {
        int count = 0;
        // chia cho 10 cho đến khi nhận được thương bằng 0
        while (a != 0){
            a /= 10;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));

    }
}
