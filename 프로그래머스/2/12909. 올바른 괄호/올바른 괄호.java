import java.util.ArrayList;

class Solution {
    boolean solution(String s) {
        // 처음부터 닫힌 경우 선제 처리
        if(s.toCharArray()[0] == ')'){
            return false;
        }
        
        int countLeft = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                countLeft++;
            } else {
                if(countLeft > 0){
                    countLeft--;
                }
            }
        }

        return countLeft == 0? true : false;
    }
}