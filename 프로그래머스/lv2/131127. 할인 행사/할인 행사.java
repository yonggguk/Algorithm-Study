import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int wantTotal = Arrays.stream(number).sum();
        int numberCnt = 0;
        for(int i = 0; i < wantTotal; i++){
            number = numberCnt(number, want, discount[i]);
        }
        for(int k = 0; k < number.length; k++){
            if(number[k] == 0) numberCnt++;
        }
        if(numberCnt == number.length) answer++;
        int lt = 0;
        int rt = wantTotal - 1;
        for(int i = 0; i < discount.length - wantTotal; i++){
            lt = i;
            rt += 1;
            for(int j = 0; j < want.length; j++){
                if(want[j].equals(discount[lt])){
                    number[j]++;
                    break;
                }
            }
            for(int j = 0; j < want.length; j++){
                if(want[j].equals(discount[rt])){
                    number[j]--;
                    break;
                }
            }
            numberCnt = 0;
            for(int k = 0; k < number.length; k++){
                if(number[k] == 0) numberCnt++;
            }
            if(numberCnt == number.length) answer++;
        }
        return answer;
    }
    public int[] numberCnt(int[] number, String[] wantItemList, String discountItem){
        for(int i = 0; i < wantItemList.length; i++){
            if(wantItemList[i].equals(discountItem)){
                number[i]--;
                break;
            }
        }
        return number;
    }
}