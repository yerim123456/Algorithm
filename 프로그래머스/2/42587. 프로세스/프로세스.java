import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> dq = new ArrayDeque<>();

        // 초기화
        int index = 0;
        for (int p : priorities)
            dq.offer(new int[]{index++, p});  
        
        // location 원소 위치 파악이 문제임.
        while (!dq.isEmpty()) { 
            int[] cur = dq.poll(); // 꺼낸다

            boolean isOut = true;
            for(int[] i : dq){
                if (cur[1] < i[1]) { // 현재 값이 더 우선순위가 낮다면
                    dq.offer(cur); // 뒤로 다시 넣음 == 안 나감
                    isOut = false;
                    break;
                }
            }
            
            if (cur[0] == location && isOut) {
                return ++answer; // location 끝남 // 오류가 난 이유 3)
            } else if (isOut) { // 나감 // 오류가 난 이유 1) 2)
                answer++;
            }
        }

        return answer;
    }
}


// 회고
// 오류가 난 이유 1) 
// answer 이 어디서 부터 세어야 할지에 대한 생각 정리가 제대로 되지 않아서 였음 > answer 이 location 시작점부터 세어야 할지. 아니면 처음부터일지에 대한 정리가 안돼서. 즉, 답변을 어디서부터 해야할지 정리 제대로 해야 함

// 오류가 난 이유 2)
// 실제로 어떨 때 올려야 할지 감을 제대로 잡지 못함. 즉, 원래는 뒤로 넘길 때 즉, offer(cur) 안 할 때만 answer 올려줘야 하는 건데, 그냥 올림. 그니까 그말은 즉슨, 나갈 때가 언제인지, 나갈 때라는 개념과 offer 다시 넣는다는 개념이 잘 매치되지 않아서 같음. 나갈 때는 count 가 올라가는 것, 즉 offer 라고 다시 넣지 않으면 count 상승. 근데 그냥 검사만 해도 count 를 높이니까 문제가 되었던 것 같음

// 오류가 난 이유 3)
// 자신이 나갈 때도 세어줘야 함, 그리고 return answer++; 하면 뒤에서 + 되기에 의미 없음 앞에서 해야함. 그거 생각 못함 자신이 나갈 때도 세어줘야 하는 거. 

// 오래 걸린 이유 1) 
// Deque 에 대한 개념도 있고, index 의 개념을 계속 스택/큐에 집어넣으려고 해서 돌아간 것

// 알게 된 거 1)
// Deque 는 큐로 쓸 때 cur 로 poll로 꺼내면 이미 꺼낸 것, 그리고 for문으로 dq 리스트에서 비교하면 이미 뽑아졌기에 그거 빼고 다 비교됨. 그니까 i j 이중 for문 안 쓰고 그냥 바로 최댓값 탐색 하는 거에 유용한 듯.

// queue 기본 공식
//  Deque<Integer> dq = new ArrayDeque<>();
//  
//  // 초기 세팅
//  for (int x : arr) dq.offer(x);
//  
//  while (!dq.isEmpty()) {
//      int cur = dq.poll();   // 1. 꺼낸다
//  
//      if (조건 만족) {
//          // 2. 처리
//      } else {
//          dq.offer(cur);     // 3. 다시 뒤로 보냄
//      }
//  }


// stack 기본 공식
// Deque<Integer> stack = new ArrayDeque<>();
// 
// for (int x : arr) {
// 
//     while (!stack.isEmpty() && 조건) {
//         stack.pop();   // 1. 제거
//     }
// 
//     stack.push(x);     // 2. 쌓기
// }