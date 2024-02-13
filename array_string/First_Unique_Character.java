package array_string;

public class First_Unique_Character {
    public static int firstUniqueChar(String s) {
        char[] characters = s.toCharArray();
        int[] count = new int[123];
        for(int i = 0; i < characters.length; i++){
            char c = characters[i];
            int index = (int)c;
            count[index]++;
        }
        for(int i = 0; i < characters.length; i++){
            char c = characters[i];
            if(count[(int)c] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqueChar(s));

    }
}
