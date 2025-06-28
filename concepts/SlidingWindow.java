The sliding window technique is a common algorithmic approach used to solve problems 
involving arrays or lists, where you need to find a subrange (or "window") that satisfies 
certain conditions. It is efficient and avoids unnecessary computations by maintaining a dynamic window
of elements.

Here’s an example of how to implement the sliding window technique in Java:

Example 1: Maximum Sum of Subarray of Size K


public class SlidingWindowExample {
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first element of the window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSumSubarray(arr, k));
    }
}
// Example 2: Longest Substring Without Repeating Characters

import java.util.HashSet;

public class SlidingWindowExample {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }
}
// Example 3: Smallest Subarray with Sum Greater Than or Equal to Target

public class SlidingWindowExample {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, windowSum = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Minimum length of subarray: " + minSubArrayLen(target, nums));
    }
}


Key Points:

Sliding Window is ideal for problems involving contiguous subarrays or substrings.
It reduces time complexity by avoiding redundant computations.
The window can expand, shrink, or slide based on the problem's requirements.