import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
         Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 앞에서부터 비교
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        // 마지막 참가자가 완주 못한 경우
        return participant[participant.length - 1];

//         두번째 시도한 것 >         contains > O(n) / indexOf() + remove() > O(n)
//         ArrayList<String> participantList = new ArrayList<>(Arrays.asList(participant));
//         ArrayList<String> completionList = new ArrayList<>(Arrays.asList(completion));
        
//         for(String person : participantList){
//             // 존재하지 않음
//             if(!completionList.contains(person)){
//                 return person;
//             }
            
//             // 값 삭제로 동명이인의 경우 없애기
//             int completionIndex = completionList.indexOf(person); 
//             completionList.remove(completionIndex);
//         }
        
//         return "";
        
        
//         처음 시도한 것 > 효율성 점수 X       
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         for(int i = 0; i < participant.length; i++){
//             for(int j = 0; j < completion.length; j++){
//                 if(participant[i].equals(completion[j])){
//                     participant[i] = "";
//                     completion[j] = "";
//                     Arrays.sort(participant);
//                     Arrays.sort(completion);
//                     break;
//                 }
//             }
//         }
        
//         for(String name : participant){
//             if(!name.equals("")){
//                 return name;
//             }
//         }
        
//         return "";
    }
}


// 회고
// HashMap의 KeySet, Arrays 의 contain, indexOf 등도 활용해보기!!!
// Arrays sort 중요!!