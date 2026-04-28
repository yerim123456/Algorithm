// 45 총합에서 빼는 방법 생각.... 와우..
// 숫자의 경우 기본 사칙연산 기반해서 생각하는 방법 기르기.

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] zeroToNine = {0,1,2,3,4,5,6,7,8,9};
        
        for(int num : numbers){
            for(int i = 0; i <= 9; i++){
                if(num == i){
                    zeroToNine[i] = 0;
                }
            }
        }
        
        for (int n : zeroToNine) {
            answer += n;
        }
        
        return answer;
    }
}