package LeetCode.SOLVED;

import java.util.ArrayList;
import java.util.List;

public class _283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        nums = new int[]{0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int counter = 0;

        List<Integer> numsList = new ArrayList<>();

        for (int num : nums) {
            if (num == 0) {
                counter++;
            }
            if (num != 0) {
                numsList.add(num);
            }
        }

        for (int i = 0; i < counter; i++) {
            numsList.add(0);
        }

        System.out.println(numsList);
    }
}
