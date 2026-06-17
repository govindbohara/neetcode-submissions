class Solution {
    public int lengthOfLongestSubstring(String s) {
        int best=0, left = 0;
        HashSet<Character> set = new HashSet();

        for(int right = 0; right < s.length();right++){

            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            best = Math.max(best, right - left +1);
        }


        return best;


        
    }
}
