import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answerList = new ArrayList<>();
        for(String str : intStrs){
            int i = Integer.parseInt(str.substring(s, s+l));
            if(i > k){
                answerList.add(i);
            }
        }
        return answerList.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}