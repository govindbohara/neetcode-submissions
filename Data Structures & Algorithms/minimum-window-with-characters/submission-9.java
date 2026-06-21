class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        int bestLength = Integer.MAX_VALUE;
        int left = 0;
        HashMap<Character,Integer> have = new HashMap();
        HashMap<Character,Integer> map = new HashMap();
        int[] subs = new int[2];

        for(int i =0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int need = map.size();
        int haveCount= 0;
        int start = 0;

        for(int right=0; right<s.length();right++){
            char key = s.charAt(right);
            if(map.containsKey(key)){
                have.put(key,have.getOrDefault(key,0)+1);
                if(have.get(key).equals(map.get(key))){
                    haveCount++;
                }
            }

            while(haveCount == need){
                int windowLength = right-left+1;
                if(windowLength < bestLength){
                    bestLength = windowLength;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    have.put(leftChar,have.get(leftChar)-1);
                    if(have.get(leftChar) < map.get(leftChar)){
                        haveCount--;
                    }
                }
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ?"": s.substring(start, start + bestLength);
    }
}
