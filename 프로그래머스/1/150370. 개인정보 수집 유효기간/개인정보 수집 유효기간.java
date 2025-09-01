import java.util.stream.*;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // HashMap 으로 약관 유효기간 매핑
        Map<String, Integer> termsMap = new HashMap<>();
        
        termsMap = Arrays.stream(terms)
                            .map(term -> term.split(" "))
                            .collect(
                                        Collectors.toMap(
                                            arr -> arr[0],
                                            arr -> Integer.parseInt(arr[1])
                                        )
                                    );
    
        // for 문으로 돌아가며
        for(int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            
            // 해당 약관 유효기간 가져오기
            int duration = termsMap.get(privacy[1]);
            
            // 약관 유효기간 만료 확인 및 추가
            if(isExpired(privacy[0], duration, today)){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public boolean isExpired(String startDate, int duration, String today){
        // String > int[] 변환
        int[] startDates = Arrays.stream(startDate.split("\\."))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();

        int[] todays = Arrays.stream(today.split("\\."))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        
        // 년 차이 계산
        int yearDiff = todays[0] - startDates[0];
        int monthDiff = 0;
        
        // 년 차이에 따른 달 차이 계산 (1달 = 28)
        if(yearDiff == 0) {
            monthDiff = todays[1] - startDates[1] -1;
        } else if(yearDiff == 1) {
            monthDiff = (12 - startDates[1]) + (todays[1] - 1);
        } else if(yearDiff > 1) {
            monthDiff = (12 - startDates[1]) + (todays[1] - 1) + ((yearDiff - 1) * 12);
        }
        
        // 달 차이 계산
        int dayDiff = todays[2] + (28 - startDates[2] + 1);
        
        // 해당 기간과 유효기간 차이 계산
        return (monthDiff*28 + dayDiff) > duration*28;
    }
}

// 회고
// 1. 조건 분기 처리해서 어떤 경우에 달라지는 지 명확히 파악하기 (날짜 차이 계산 방식!!!)
// + 차이 계산 헷갈리지 말기!!!
// n - m > 양쪽 일자 중 한 개의 일자만 빼기
// n - m - 1 > 양쪽 일자 다 빼기
// n - m + 1> 양쪽 일자 다 더하기

// 2. ArrayList<> > Array 변경 방식 (기본 자료형으로 변경을 위한 stream 이용)
// answer.stream().mapToInt(Integer::intValue).toArray();

// 3. split 의 . 은 모든 글자를 의미 > 실제 "."로 분리하고 싶다면 \\ 붙이기!!
// startDate.split("\\.")

// 4. 문제 정확히 보기
// 반환해야 하는 값과 조건 먼저 살피기!!
// NotExpired 가 아니라 Expired 반환해야 하는 거였음!!!
// 그냥 인덱스가 아니라 인덱스 + 1 반환이었음!!!