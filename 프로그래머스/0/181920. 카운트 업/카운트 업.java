// 배열에 비해 ArrayList의 경우 성능이 떨어질 수 있음
// 계속 직접 객체를 생성해서 추가하기 때문임
// 공간 할당이 필요하다는 뜻으로, 메모리 사용과 성능 면에서 오버헤드 발생 가능성이 있음!!

// 따라서 웬만하면 Array 사용이 나음
// >  지금의 경우 end_num - start_num + 1 로 크기를 설정할 수 있으니 해당 부분으로 사용하기..!

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int start_num, int end_num) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = start_num; i <= end_num; i++){
            answer.add(i);   
        }
        
        return answer;
    }
}