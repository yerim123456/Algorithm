import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> valueCount = new HashMap<>();   
        
        for(int i : array) {
            valueCount.put(i, valueCount.getOrDefault(i, 0) + 1);
        }
        
        int bigCount = 0;
        int answer = -1;
        
        for(int key : valueCount.keySet()) {
            
            int count = valueCount.get(key);
            
            if(bigCount < count){
                bigCount = count;
                answer = key;
            } else if (count == bigCount) {
                answer = -1;
            }
        }
        
        return answer;
    }
}