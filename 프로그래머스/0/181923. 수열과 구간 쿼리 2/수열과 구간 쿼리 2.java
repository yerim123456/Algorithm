/**
기본 조건
queries에서 sek 추출, 
1) s와 e 사이 값인 인덱스 구하기
2) 해당 인덱스 값이 k보다 <= 은지 
3) 추출된 값 중 가장 작은 값인지 확인

추가 조건
1) 답 존재 X -1 저장

반환 값
각 쿼리 별로 추출한 값을 저장한 배열 반환
**/

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){ // row 반복
            for(int j = queries[i][0]; j <= queries[i][1]; j++){ // 조건 1 적용
                if(answer[i] == 0 || answer[i] > arr[j]){ // 조건 3 적용
                    if(arr[j] > queries[i][2]) { // 조건 2 확인
                        answer[i] = arr[j];
                    } 
                }
            }
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}


