class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 0) return false;
        Deque<Character> stack = new ArrayDeque();

        for(int i = 0; i<s.length();i++){
            char c= s.charAt(i);
            if(c == '(' || c == '{' || c =='['){
                stack.addLast(c);
            }else{
                if(stack.isEmpty()) return false;
                char p = stack.removeLast();
                if(c == ')' && p!='(') return false;
                if(c =='}' && p!= '{') return false;
                if(c == ']' && p!= '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
