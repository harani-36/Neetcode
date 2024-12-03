### Approach 1: Brute Force  
**Intuition:**  
Compare each element with every other element in the array to check for duplicates.  

**Explanation:**  
Iterate through the array using nested loops. If two elements are the same, return `true`. This approach is straightforward but inefficient for large arrays due to its high time complexity of **O(n²)**.  

**Code:**  
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
```

---

### Approach 2: Sorting  
**Intuition:**  
Sort the array so duplicates are adjacent, simplifying detection.  

**Explanation:**  
Sort the array in **O(n log n)** and check adjacent elements for equality.  

**Code:**  
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}
```
### Approach 3: Hash Set  
**Intuition:**  
Use a hash set to store seen elements. If an element is already in the set, it's a duplicate.  

**Explanation:**  
Iterate through the array, checking membership in the hash set in **O(1)** per operation. The overall time complexity is **O(n)**.  

**Code:**  
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}
```

---

### Approach 4: Hash Map  
**Intuition:**  
Store elements in a hash map with their counts. If a count exceeds 1, a duplicate exists.  

**Explanation:**  
Iterate through the array and use a hash map to track occurrences. This approach also runs in **O(n)**.  

**Code:**  
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
```

### Summary:  
- **Brute Force:** O(n²), simple but inefficient.  
- **Sorting:** O(n log n), moderate efficiency.  
- **Hash Set:** O(n), fast and memory-efficient.  
- **Hash Map:** O(n), tracks duplicate counts but requires more memory.  
