import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 모든 트럭이 다리를 건너는 데 걸리는 최소 초 수
        
        // 다리 대기조
        Deque<Integer> trucks = new ArrayDeque<>();
        for(int t : truck_weights){
            trucks.offer(t);
        }
        
        // 다리
        Deque<int[]> bridge = new ArrayDeque<>();
        
        // 사용한 자리
        int used_length = 0;
        
        // 남은 무게
        int remain_weights = weight;
        
        // 트럭 대기열 확인
        do {
            // 이미 초수 채웠으면 내보내기
            bridge.removeIf(truck -> truck[0] == bridge_length);
            
            Integer cur = trucks.poll();
            
            
            if(cur != null && cur <= remain_weights && used_length < bridge_length){ // 무게도 남았고, 자리도 남았다면
                // brdige 입성
                used_length++; // 자리 하나 차지
                remain_weights -= cur; // 무게 차지
        
                // t 무게의 차가 다리에 올라감
                bridge.offer(new int[]{0, cur});
                
            } else if (cur != null){
                trucks.offerFirst(cur);
            }
            
            // 1초 지남
            time++;
            for (int[] truck : bridge) {
                // 초 수 올리기
                truck[0]++;
                
                if(truck[0] == bridge_length){
                    // 자리, 무게 반납
                    used_length--;
                    remain_weights += truck[1];
                }
            }
        } while (!bridge.isEmpty());
        
        return time;
    }
}