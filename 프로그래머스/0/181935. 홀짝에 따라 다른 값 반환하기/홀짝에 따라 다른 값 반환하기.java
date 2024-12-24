class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isEvenNumber = n % 2 == 0 ? true : false;
        
        if(isEvenNumber){
          for(int i = 2; i <= n; i=i+2){
              answer += (i*i);
          }  
            
            
        } else {
          for(int i = 1; i <= n; i=i+2){
              answer += i;
          }  
        }
        
        return answer;
    }
}







