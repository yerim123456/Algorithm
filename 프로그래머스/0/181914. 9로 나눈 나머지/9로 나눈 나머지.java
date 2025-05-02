class Solution {
    public int solution(String number) {
        
        try {
            return Integer.parseInt(number) % 9;
        } catch (NumberFormatException e) {
            int answer = 0;
            for (int i = 0; i < number.length(); i++) {
                 answer += number.charAt(i) - '0'; 
            }
            return answer % 9;
        }
    }
}