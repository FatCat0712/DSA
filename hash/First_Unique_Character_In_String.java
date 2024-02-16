package hash;

import java.util.HashMap;

public class First_Unique_Character_In_String {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> myMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(myMap.containsKey(c) == false){
                myMap.put(c,1);
            }
            else{
                myMap.put(c, myMap.get(c)+1);
            }
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(myMap.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
