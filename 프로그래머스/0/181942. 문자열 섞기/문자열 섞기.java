// answer += str1.charAt(i) + str2.charAt(i);
// 위 코드처럼 수행하면, 195195.. 처럼 char 문자끼리 아스키 코드로 덧셈을 진행하게 됨 > 원하는 결과 X
// char 는 숫자형 타입으로 간주될 수 있기에 + `+` 연산자는 int를 우선하기에 나는 결과

class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        for(int i = 0; i < str1.length(); i++){
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }
       
        return answer;
    }
    
}