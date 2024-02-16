package hash;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            if (mySet.contains(num)) {
                return true;
            } else {
                mySet.add(num);
            }
        }
        return false;
    }
}
