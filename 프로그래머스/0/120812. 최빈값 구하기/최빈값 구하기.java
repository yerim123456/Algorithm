import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> valueCount = new HashMap<>();   
        
        for(int i : array) {
            valueCount.put(i, valueCount.getOrDefault(i, 1) + 1);
        }
        
        int bigCount = 0;
        int answer = 0;
        for(int i : valueCount.keySet()) {
            if(bigCount < valueCount.get(i)){
                bigCount = valueCount.get(i);
                answer = i;
            }
        }
        
        
        for(int i : valueCount.keySet()) {
            if(bigCount == valueCount.get(i) && answer != i){
                return -1;
            }
        }
        
        return answer;
    }
}