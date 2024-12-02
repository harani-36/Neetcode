/*Brute Force Approach
The brute force approach involves using two nested loops to check every possible pair in the array.*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
/*
 Explanation:
- Iterate through all pairs of elements in the array using two nested loops.
- If the sum of the two elements equals the target, return their indices.

 Time Complexity:  
O(n^2)  
- Two loops are used to traverse the array, making the complexity quadratic.

 Space Complexity:  
O(1)  
- No extra space is used, apart from the returned array.

   Optimal Approach (Using HashMap)

Instead of checking all pairs, use a HashMap to store the indices of the numbers and check for the complement  {target} - {nums[i]}  as you iterate through the array.

 Code:*/
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
/*
 Explanation:
- As you iterate through the array:
  - Calculate the complement ( {target} - {nums[i]} ).
  - Check if the complement exists in the HashMap.
  - If it exists, return the current index and the index of the complement.
  - Otherwise, store the current number and its index in the HashMap.

 Time Complexity:  
O(n)  
- Each lookup and insertion in the HashMap is O(1), and the array is traversed only once.

 Space Complexity:  
O(n)  
- Extra space is used for the HashMap to store the elements and their indices.

Two-pointer approach :
If the input is sorted can be solved in O(logn) time. 
(Just to return true or false can use Two pointer approach irrespective of input).

---

 Comparison

| Approach       | Time Complexity | Space Complexity | When to Use?                              |
|---------------------|---------------------|-----------------------|-----------------------------------------------|
| Brute Force     | O(n^2)         | O(1)             | Small input size; no extra memory available. |
| HashMap (Optimal) | O(n)          | O(n)             | Larger inputs; faster performance required.  |
*/
