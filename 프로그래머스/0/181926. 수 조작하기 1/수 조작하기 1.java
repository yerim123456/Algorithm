class Solution {
    public int solution(int n, String control) {
        for(char c : control.toCharArray()){
            switch(c){
                    case 'w' -> n++;
                    case 's' -> n--;
                    case 'd' -> n += 10;
                    case 'a' -> n -= 10;
            }
        }
        
        return n;
    }
}