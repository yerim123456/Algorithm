class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        char[] myStrArray = my_string.toCharArray();
        for (int i : index_list) {
            answer += myStrArray[i];
        }
        return answer;
    }
}