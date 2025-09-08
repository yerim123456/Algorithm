import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer = new ArrayList<>();
        // Map 으로 이름 key, 그리움 점수 value 인 변수 제작
        Map<String, Integer> nameYearning = new HashMap();
        
        // map 에 값 추가
        for(int i = 0; i < name.length; i++){
            nameYearning.put(name[i], yearning[i]);
        }
        
        // photo 의 각 점수 합산
        for(int i = 0; i < photo.length; i++){
            int total = 0;
            for(String person : photo[i]){
                total += nameYearning.getOrDefault(person, 0);
            }
            answer.add(total);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

// 회고
// 1. ArrayList: add() / HashMap: put()
// 2. ArrayList: answer.stream() / Array: Arrays.stream(arr)
// 3. mapToInt 기억!!
// 4. getOrDefault 기억!!