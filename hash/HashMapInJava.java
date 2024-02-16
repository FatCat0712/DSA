package hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapInJava {
    // HashTable
    // HashMap
    // deu su dung function voi array
    // LinkedHashMap => su dung linkedlist => theo thu tu them vao
    // TreeMap => co sap xep thu tu key => slower

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,2};
        Map<Integer, Integer> myMap = new HashMap<>();
        // key: Giá trị của phần tử trong mảng
        // value: số lần xuất hiện của phần tử trong mảng

        for(int i: arr){
            // chưa xuất hện trong map
            if(myMap.containsKey(i) == false){
                myMap.put(i,1);
            }
            else{
                // đã xuất hiện trước đó
                int oldValue = myMap.get(i);
                oldValue++;
                myMap.put(i,oldValue);
            }
        }

        for (Map.Entry entry : myMap.entrySet()){
            System.out.println(entry.getKey() + " xuat hien " +entry.getValue() + " lan ");
        }

    }

}
