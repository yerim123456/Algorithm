// repeat(repeat count)

class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        
        /** 1.
        for(int i = 0; i < k; i++){
            answer += my_string;
        }
        **/
        
        // 2.
        answer = my_string.repeat(k);

        return answer;
    }
}