

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean isEqual = eq.equals("=") ? true : false;
        boolean isBigger = ineq.equals(">") ? true : false;
        
        if(isEqual && n == m){
            return 1;
        }
        
        if(isEqual || !isEqual) {
            if(isBigger && n > m || !isBigger && n < m) {
                return 1;
            }
        }
        
        return 0;
    }
    
}