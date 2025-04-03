import java.util.*;
import java.util.stream.Collectors;


class Solution {
    
    public int solution(int a, int b, int c, int d) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a,b,c,d));

        // 숫자별 등장 횟수 저장
        Map<Integer, Long> countMap = list.stream().collect(
            Collectors.groupingBy(n -> n, Collectors.counting())
        );

    switch(countMap.size()){
    
            // 1) nnnn == 1111*n
            case 1: {
                return 1111 * list.get(0);
            }
            
            case 2: {
                List<Integer> keys = new ArrayList<>(countMap.keySet());
                int n = keys.get(0);
                int m = keys.get(1);

                // 2) nn mm == (n + m) * |n - m|
                if(countMap.get(n) == 2){
                    return (n + m) * Math.abs(n - m);
                    
                } // 3) nnn m == (10 x n + m)제곱
                else if(countMap.get(n) == 3){
                    int base = 10 * n + m;
                    return base * base;
                }else{
                    int base = 10 * m + n;
                    return base * base;
                }
            }
            
            // 4) nn m q == m * q
            case 3: {
                Map<Integer, Long> filteredMap = countMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                List<Integer> filteredKeys = new ArrayList<>(filteredMap.keySet());
                int n = filteredKeys.get(0);
                int m = filteredKeys.get(1);

                return n * m;
            }
            
            // 5) n > m > q > r == r
            case 4: {
                list.sort(Comparator.naturalOrder());
                return list.get(0);
            }
            default:
                return 0;
        }
    }
}