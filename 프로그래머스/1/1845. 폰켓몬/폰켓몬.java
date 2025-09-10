import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // map 으로 string, integer 에 포켓몬 별 숫자 저장
        Map<Integer, Integer> poketmon = new HashMap<>();
        
        for(int num : nums) poketmon.put(num, poketmon.getOrDefault(num, 0) + 1);
        
        // keyset 이 nums.length / 2 의 값인지 확인
        if(poketmon.keySet().size() <= nums.length/2){
            return poketmon.keySet().size();
        }
            
        // 아니라면 keyset 값 제공
        return nums.length/2;
    }
}