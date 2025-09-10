import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // HashMap으로 종류 받기
        Map<String, Integer> wear = new HashMap<>();
        for(String[] array : clothes){
            wear.put(array[1], wear.getOrDefault(array[1], 1) + 1);
        }
        
        // 조합 X 경우
        int total = 1;
        for(String key : wear.keySet()){
           total *= wear.getOrDefault(key, 0);
        }
        
        
        
        return total - 1;
    }
}