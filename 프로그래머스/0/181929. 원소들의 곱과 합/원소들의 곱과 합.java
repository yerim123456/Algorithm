class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiple = 1;
        
        for(int num : num_list){
            multiple *= num;
            sum += num;
        }
        
        return multiple < Math.pow(sum, 2) ? 1 : 0;
    }
}