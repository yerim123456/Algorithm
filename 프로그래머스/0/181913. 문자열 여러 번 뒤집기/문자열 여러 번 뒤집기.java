class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
            System.out.println(my_string);
        for(int[] array : queries){
          answer = swap(answer, array[0], array[1]);
        }
        return answer;
    }
    
    private String swap(String str, int a, int b){
        StringBuilder sb = new StringBuilder(str);
        
        int aBetweenB = b - a + 1;
        for(int i = 0; i < aBetweenB/2; i++){
            char c1 = str.charAt(a+i);
            char c2 = str.charAt(b-i);
            
            sb.setCharAt(a+i, c2);
            sb.setCharAt(b-i, c1);   
        }
        
        return sb.toString();
    }
}