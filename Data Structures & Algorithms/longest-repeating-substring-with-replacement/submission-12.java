class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap();
        int maxfreq = 0;
        int left = 0;
        int best = 0;

        for(int r= 0; r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));


            while((r-left +1) - maxfreq > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;

            }

            best = Math.max(r-left+1, best);

        }
        return best;
    }
}
