class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 현재 좌표 (가로, 세로)
        int[] s = getStartSpot(park);
        
        System.out.println("시작 지점 > " + s[0] + " : " + s[1]);
        
        // 명령 분석
        for(String route : routes){ 
            String[] order = route.split(" ");
            int distance = Integer.parseInt(order[1]);
            System.out.println("명  령 > " + order[0] + " : " + distance);
            
            String[] sRow = park[s[0]].split("");
            
            if(order[0].equals("N") && isOkToMoveN(order[0], distance, s, park)){
                s[0] -= distance;
            } else if (order[0].equals("S") && isOkToMoveS(order[0], distance, s, park)) {
                s[0] += distance;
            } else if(order[0].equals("E") && isOkToMoveE(order[0], distance, s, sRow)) { 
                s[1] += distance;
            } else if(order[0].equals("W") && isOkToMoveW(order[0], distance, s, sRow)) { 
                s[1] -= distance;
            }
            System.out.println("잘 감 > " + s[0] + " : " + s[1]);
            
        }
         
        
        return s;
    }
    
    private int[] getStartSpot(String[] park){
        int[] s = {0, 0};
        
        for(int i = 0; i < park.length; i++){
            String[] row = park[i].split("");
            for(int j = 0; j < row.length; j++){
                if(row[j].equals("S")){
                    s[0] = i;
                    s[1] = j; 
                    return s;
                }
            }
        } 
        
        return s;
    }
    
    private boolean isOkToMoveN(String order, int distance, int[] s, String[] park) {
        // 바운더리를 벗어남
        if (s[0] - distance < 0) return false;
        for (int i = s[0] - 1; i >= s[0] - distance; i--) {
            String[] row = park[i].split("");
            if (row[s[1]].equals("X")) return false;
         }

        
        return true;
    }   
    
    private boolean isOkToMoveS(String order, int distance, int[] s, String[] park) {
        // 바운더리를 벗어남
        if((order.equals("S") &&  s[0] + distance > park.length - 1) ) {
                System.out.println("S인 경우 멈춤 > " + (s[0] + distance) + " : " + park.length);
                return false;
        } else { // 장애물을 만남
            // N(북) / S(남): for 2단 > i는 다르고, j는 같고
            int flag = 0;
            for(int i = s[0] + 1; i < park.length; i++){
                String[] row = park[i].split("");
                if(row[s[1]].equals("X")) {
                    System.out.println("장애물을 만나 멈춤 > " + i  + " , " + s[1] +  " , " + row[s[1]]);
                    return false;
                } 
                flag += 1;
                if(flag == distance){
                    break;
                }
            }
        }
        
        return true;
    } 
    
    private boolean isOkToMoveE(String order, int distance, int[] s, String[] sRow) {
        // 바운더리를 벗어남
        if((order.equals("E") &&  s[1] + distance >  sRow.length - 1)){
             System.out.println("E인 경우 멈춤 > " + (s[1] + distance) + " : " + sRow.length);
            return false;
        } else { // 장애물 만남
            // E(동) / W(서): for 2단 > i는 같고 j는 다르고
            int flag = 0;
            for(int i = s[1] + 1; i < sRow.length; i++){
                System.out.println("장애물을 만나 멈춤 1 > " + sRow[i]);

                if(sRow[i].equals("X")){
                    System.out.println("장애물을 만나 멈춤 > " + i  +  " , " + sRow[i]);
                    return false;
                } 
                flag += 1;
                if(flag == distance){
                    break;
                }
                
                
            }
        }
        
        return true;
    }
    
    private boolean isOkToMoveW(String order, int distance, int[] s, String[] sRow) {
       if (s[1] - distance < 0) return false;

        for (int i = s[1] - 1; i >= s[1] - distance; i--) {
            if (sRow[i].equals("X")) return false;
        }
        return true;
    }
    
    
}

// 회고
// 1. for문 중첩일 경우, 내부 for 문만 빠져나가는 것은 아닌지 확인하기
// 2. Integer.valueOf > Integer 로 변환, Integer.parseInt > int 로 변환
// 3. for 문의 종료 조건 > -- 로 줄어드는 조건이라면 i >= 0 0보다 클 때, 같을 때까지 돈다고 설정!!
// 4. 조건에 맞게 체크 되고 있는지 확인하기 >  i > 0 > 끝까지만 돌기에 out 되지 않음s[0] - distance
// 5. 런타임 에러 발생 > for문 조건 등 다시 확인 + 해당 문제 해결 부분 다시 정리하기!!