// 반복문에서는 StringBuilder를 사용하는 게 좋음 > 객체 생성과 복사가 반복되지 않기에
// ( 가독성 측면에서는 String 사용이 좋음
// 그냥 += 하는 것은 String이 불변 객체이기에 새로운 객체를 생성하여 새로운 값을 할당
// 근데 StringBuilder의 경우 가변 객체여서 동일 객체에서 바로 수정이 가능

class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 1; i < numLog.length; i++ ){
            switch(numLog[i] - numLog[i-1]){
                    case 1 -> answer.append("w");
                    case -1 -> answer.append("s");
                    case 10 -> answer.append("d");
                    case -10 -> answer.append("a");
            }
        }
        
        return answer.toString();
    }
}