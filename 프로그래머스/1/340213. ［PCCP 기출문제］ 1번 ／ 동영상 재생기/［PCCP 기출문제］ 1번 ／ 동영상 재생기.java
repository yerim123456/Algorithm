class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // 모두 초로 변환
        String[] video_len_array = video_len.split(":");
        String[] pos_array = pos.split(":");
        String[] op_start_array = op_start.split(":");
        String[] op_end_array = op_end.split(":");
        
        int video_len_second = Integer.parseInt(video_len_array[0])*60 + Integer.parseInt(video_len_array[1]);
        int pos_second = Integer.parseInt(pos_array[0])*60 + Integer.parseInt(pos_array[1]);
        int op_start_second = Integer.parseInt(op_start_array[0])*60 + Integer.parseInt(op_start_array[1]);
        int op_end_second = Integer.parseInt(op_end_array[0])*60 + Integer.parseInt(op_end_array[1]);
        
        // 현재 구간이 오프닝 구간인지 확인
            // 오프닝 구간이라면 기본적으로 op_end에서 시작
        if(pos_second < op_end_second && pos_second > op_start_second){
            pos_second = op_end_second;    
        }
        
        // commands 에 따라 next(+10) / prev(-10)
        for(String command : commands){
            if(command.equals("prev")){
                if(pos_second < 10){
                    pos_second = 0;
                } else {
                    pos_second -= 10;
                }
            } else if(command.equals("next")){
                if(video_len_second - pos_second < 10){
                    pos_second = video_len_second;
                } else {
                    pos_second += 10;
                }
            }
            
            if(pos_second <= op_end_second && pos_second >= op_start_second){
                pos_second = op_end_second;    
            }
        }
        
        // 초를 분으로 변경
        if((pos_second / 60) < 10){
            answer += "0" + pos_second / 60;
        } else {
            answer += pos_second / 60;
        }
         
        if((pos_second % 60) < 10){
            answer += ":0" + pos_second % 60;
        } else {
            answer += ":" + pos_second % 60;
        }
        
        
        return answer;
    }
}