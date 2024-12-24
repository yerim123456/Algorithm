class Solution {
    public String solution(String code) {
        String answer = "";
        
        char[] codeArray = code.toCharArray();
        boolean mode = false;
        
        for(int i = 0; i < codeArray.length; i++){
           if(codeArray[i] == '1'){
               mode = !mode;
           } else if(mode && i%2 != 0 || !mode && i%2 == 0) {
                answer += codeArray[i];
            }
        }
        
        if(answer.isEmpty()){
            answer = "EMPTY";
        }
        
        return answer;
    }
}