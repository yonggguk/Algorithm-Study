import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int answer = 0;
 
        answer = IntStream.range(0, n+1)
                .filter(i -> i % 2 == 0)
                .sum();
        return answer;
    }
}