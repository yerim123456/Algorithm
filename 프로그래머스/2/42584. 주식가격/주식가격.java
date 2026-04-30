import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i : prices)
            stack.offer(i);
        
        int index = 0;
        while(!stack.isEmpty()){
            int cur = stack.poll();
            
            int time = 0;
            for(int i : stack){
                if(cur <= i) { // 가격이 안 떨어짐
                    time++;
                } else { // 가격이 떨어짐. > 이 경우도 고려해서 1초 올려줘야 함. 조건 모두 생각했는지 확인하기!!
                    time++;
                    break;
                }
            }
            
            answer[index] = time;
            index++;
        }
        
        return answer;
    }
}