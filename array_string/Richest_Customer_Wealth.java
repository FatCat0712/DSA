package array_string;

public class Richest_Customer_Wealth {
    public static int maximumWealth(int[][] accounts) {
        int soKhachHang = accounts.length;
        int soNganHang = accounts[0].length;
        int[] danhSachTaiSan = new int[accounts.length];
        for(int i = 0; i < soKhachHang; i++){
            int tongTaiKhoan = 0;
            for(int j = 0; j < soNganHang; j++){
                tongTaiKhoan += accounts[i][j];
            }
            danhSachTaiSan[i] = tongTaiKhoan;
        }
        int max = danhSachTaiSan[0];
        for(int i = 0; i < danhSachTaiSan.length; i++){
            if(danhSachTaiSan[i] > max){
                max = danhSachTaiSan[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] a = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println("Thang giau nhat: "+maximumWealth(a));

    }
}
