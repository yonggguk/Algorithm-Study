import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        Stack<Integer> st = new Stack<>();
        for(int i = 1; i < food.length; i++){
            if(food[i] < 2) continue;
            int nFood = food[i];
            while(nFood > 1){
                answer += i;
                st.push(i);
                nFood-=2;
            }
        }
        answer += 0;
        while(!st.isEmpty()){
            answer += st.pop();
        }
        return answer;
    }
}