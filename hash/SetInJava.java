package hash;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInJava {
    public static void main(String[] args) {
        // Các key trong set là duy nhất
        // Hashset không đảm bảo thứ tự -> sử dụng array
        // Treeset(logn) : đảm bảo thứ tự vì phải sắp xếp các phần tử sau khi thêm
        // LinkedHashset -> sử dụng linkedlist -> theo thứ tự thêm vào
        Set<String> myIntSet = new LinkedHashSet<>();
        myIntSet.add("11111");
        myIntSet.add("333");
        myIntSet.add("22");

        myIntSet.add("11111");
        myIntSet.add("22");

        for(String s: myIntSet){
            System.out.println(s);
        }



    }
}
