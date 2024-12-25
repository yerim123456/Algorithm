/**
// 1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111...  
// sring 만 toCharArray 가능함 > 막무가내로 하지말고 형변환 합쳐보기
**/
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        boolean isNotAllow = false;
        for(int i = l; i <= r; i++){
            for(char c : String.valueOf(i).toCharArray()){
                if(c != '5' && c != '0'){
                    isNotAllow = true;
                    break;
                }
            }    
            
            if(!isNotAllow){
                answer.add(i);
            } else{
                isNotAllow = false;
            }
        }
        
        if(answer.isEmpty()){
            answer.add(-1);
        }
        
        return answer;
    }
}