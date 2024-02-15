package array_string;

public class Check_If_2_Strings_Are_Equal {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();

        for (String str: word1) {
            r1.append(str);
        }
        for (String str: word2){
            r2.append(str);
        }

        return r1.toString().equals(r2.toString());
    }
    public static void main(String[] args) {

    }
}
