import java.util.ArrayList;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        // t에서 p와 길이가 같은 부분 문자열 추출
        ArrayList<Long> sameLength = new ArrayList<>();

        for(int i = 0; i < (t.length() - p.length()) + 1; i++) {
            sameLength.add(Long.valueOf(t.substring(i, i + p.length())));
        }
            
        // 문자열 ArrayList 에서 p보다 <= 수 구하기
        for(long num : sameLength){
            if(num <= Long.parseLong(p)){
                answer++;
            }
        }
        
        return answer;
    }
}