import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> days = new ArrayList<>();
        
        // 각 요소 별 걸리는 날 측정
        for(int i = 0; i < progresses.length; i++){
            int lastAmount = 100 - progresses[i];
            int lastDay = lastAmount / speeds[i] + (lastAmount % speeds[i] == 0 ? 0 : 1);
            days.add(lastDay);
        }
        
        // 배포 시뮬레이션
        int maxDay = days.get(0);
        int count = 1;
        
        for (int i = 1; i < days.size(); i++) {
            if (days.get(i) <= maxDay) {
                // 같은 날 배포 가능
                count++;
            } else {
                // 새로운 배포 시작
                answer.add(count);
                count = 1;
                maxDay = days.get(i);
            }
        }
        
        answer.add(count); // 마지막 배포 묶음 추가
        
//         int todayAmount = 1;
//         // 앞의 요소보다 적게 걸리는 거 순으로 제출
//         for(int i = 0; i < days.size() - 1; i++){
//             int basic = days.get(i); 
//             for(int j = i + 1; j < days.size(); j++){
//                 if(basic >= days.get(j)){
//                     todayAmount += 1;

//                 } else {
//                     answer.add(todayAmount);
//                     todayAmount = 1;
//                     i = (j < days.size()) ? (j - 1) : (days.size() - 1);
//                     break;
//                 }
//             }
//         }
        
//         answer.add(todayAmount);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}