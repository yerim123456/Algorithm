import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}

// 회고
// 1. String > substring(시작 인덱스, 끝 인덱스+1);
// 2. 항상 예외적인 부분 고려해서 생각하기... > ex 현재 체크해야하는 접두어가 [0] 만 인 줄 알았으나, 전체의 경우임
// 비교의 경우, 대부분 대체로!!! sort 사용해서 정렬하고 하는 게 중요 > why? 현재는 뒤에 접두사가 있는 경우 앞과 비교가 힘듦, 그러나 sort 하고 비교하면 접두사에 대한 거 뒤에 있을 경우가 없음...!!!!!!!!!!!!!
//         for(int i = 0; i < phone_book.length - 1; i++){
//             String pre = phone_book[i];
//             int pre_length = pre.length();
//             for(int j = i + 1; j < phone_book.length; j++ ){
//                 if(phone_book[j].length() >= pre.length() && phone_book[j].substring(0, pre_length).equals(pre)){
//                     return false;
//                 }
//             }
//         }
        
//         return true;
// 근데 시간 문제 발생.... >> 
