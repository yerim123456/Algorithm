class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String sA = String.valueOf(a);
        String sB = String.valueOf(b);
        
        if(Integer.parseInt(sA + sB) >= Integer.parseInt(sB + sA)){
            answer = Integer.parseInt(sA + sB);
        }
        else{
            answer = Integer.parseInt(sB + sA);
        }
        
        return answer;
    }
}