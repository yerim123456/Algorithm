// StringBuilder 사용
// for 문으로 그냥 붙이는 방법도 있음..!!
// Array > String 방법 숙지하기! 

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String[] arr = my_string.split("");
        
        for(int i = 0; i < arr.length/2; i++){
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        // Array > String 방법 1: collector 이용!
       // return Arrays.stream(arr).collect(Collectors.joining(""));
        
        // Array > String 방법 2: String 클래스의 join 메서드 사용!!
        return String.join("", arr);
    }
}