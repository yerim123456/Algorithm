// Math.max(a,b) > 큰 수 비교
// 너무 길어진다 싶다면, "" 사용하는 게 더 나을 수도 있을 것 같음

class Solution {
    public int solution(int a, int b) {
        int result1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int result2 = 2 * a * b;
        
        return result1 >= result2 ? result1 : result2;
    }
}