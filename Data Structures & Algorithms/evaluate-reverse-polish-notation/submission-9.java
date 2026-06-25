class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();

        for(int i=0; i< tokens.length;i++){
            String c = tokens[i];
            if(!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
                stack.push(Integer.parseInt(c));
            }else{
                if(!stack.isEmpty()){
                int c1 = stack.pop();
                int c2 = stack.pop();
                int res = 0;

                switch(c){
                    case "+": 
                    res =  c2+c1;
                    break;
                    case "-": 
                    res = c2-c1;
                    break;
                    case "*": 
                    res = c2*c1;
                    break;
                    case "/": 
                    res = c2/c1;
                    break;
                }
                stack.push(res);

                }
            }
        }
        return stack.pop();
        
    }
}
