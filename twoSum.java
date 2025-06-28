// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//Solution 1: HashMap - optimal for better space and time complexity

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int value = target - nums[i];  // for i=0, value = 9-2 => 7 ; for i=1, value = 9-7 = 2
            if(map.containsKey(value)){
                return new int[]{map.get(value), i};  // [0,1]
            }
            map.put(nums[i],i);  // {2:0}
        }
        return new int[]{};
    }
}

// Solution 2 Hash Map

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            map.put(nums[i],i);   // {2:0, 7:1,..}
        }
        for(int i =0; i<nums.length; i++){
            int value = target - nums[i];  // for i=0 value = 7
            if(map.containsKey(value) && map.get(value)!=i){
                return new int[]{i, map.get(value)};
            }
        }
        return new int[]{};
    }
}

// Solution 3 : brute force method

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // If no valid pair is found, return an empty array instead of null
        return new int[] {};
    }
}