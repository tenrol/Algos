import java.util.ArrayList;
import java.util.List;
import java.util.*;


class Solution {

    public static void main(String[] args) {
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        System.out.println(Solution.fourSum(nums, 4).toString());    
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int sum;
        List<List<Integer>> result = new ArrayList();
        Set<List<Integer>> result_set = new HashSet();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int m = j + 1; m < nums.length - 1; m++) {
                    for (int p = m + 1; p < nums.length; p++) {
                        sum = nums[i] + nums[j] + nums[m] + nums[p];
                        if (sum == target) {
                            List<Integer> quadruplet = new ArrayList() {
                                
                                @Override
                                public boolean equals(Object o) {
                                    if (o == null) return false;
                                    if (!(o instanceof ArrayList))
                                        return false;
                                    if (o == this)
                                        return true;
                                    /*
                                    ListIterator<Integer> e1 = listIterator();
                                    ListIterator<?> e2 = ((List<?>) o).listIterator();
                                    
                                    while (e1.hasNext() && e2.hasNext()) { // Both have no next, so no loop    here
                                        Integer o1 = e1.next();
                                        Object o2 = e2.next();
                                        if (!(o1==null ? o2==null : o1.equals(o2)))
                                            return false;
                                    }
                                    return !(e1.hasNext() || e2.hasNext()); 
                                    */
                                    return true;
                                }
                                @Override
                                public int hashCode() {
                                    return 0;
                                }
                            };
                            quadruplet.add(nums[i]);
                            quadruplet.add(nums[j]);
                            quadruplet.add(nums[m]);
                            quadruplet.add(nums[p]);
                            result_set.add(quadruplet);
                        }
                    }
                }
            }
        }
        System.out.println(result_set);
        result.addAll(result_set);
        return result;
    }
}