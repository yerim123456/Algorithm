// toCharArray
// StringBuilder
    // append
// isUpperCase / isLowerCase
// toUpperCase / toLowerCase

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder result = new StringBuilder();
        
        for (char c :  a.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c)); // 소문자를 대문자로
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c)); // 대문자를 소문자로
            } else {
                result.append(c); // 알파벳이 아닌 경우 그대로 추가
            }
        }
        
        System.out.println(result.toString());
    }
}