/* Brute force
Sorting Each String and Using a HashMap
Idea:
Convert each string into a canonical form by sorting its characters.
Use a HashMap to group strings with the same sorted representation.
Steps:
Sort the characters of each string to get a "key."
Use this sorted key to group anagrams in a HashMap.
Time Complexity:
Sorting takes O(M log M), and iterating over N strings gives O(N * M log M).
*/
Code:
import java.util.*;

public class SortAndHashMapGroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
/*Frequency Count as Key (Optimized)
Idea:
Instead of sorting, use a character frequency count array to represent each string.
Convert the frequency array into a string (key).
Use the key to group anagrams in a HashMap.
Steps:
Create a frequency count of characters for each string.
Use the frequency array as a unique key.
Group strings using a HashMap.
Time Complexity:
Counting frequencies takes O(M), iterating over N strings gives O(N * M).
Code:*/
import java.util.*;

public class FrequencyCountGroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            // Convert frequency array to a string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    keyBuilder.append((char) ('a' + i)).append(count[i]);
                }
            }
            String key = keyBuilder.toString();
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
