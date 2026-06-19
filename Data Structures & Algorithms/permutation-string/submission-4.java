class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap();

        for(int i =0; i< s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int left = 0;
        int count = s1.length();
        for (int right=0; right< s2.length();right++){
            if(map.containsKey(s2.charAt(right))){
                if(map.get(s2.charAt(right)) >0){
                    count--;
                }
                map.put(s2.charAt(right),map.get(s2.charAt(right)) -1);
            }
            if(right-left+1 > s1.length()){
                char leftChar = s2.charAt(left);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) >=0){
                        count++;
                    }
                    map.put(leftChar, map.get(leftChar)+1);
                }
                left++;
            }
            if (count ==0) return true;

        }

        return  false;
    }
}
