import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndex = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = playerIndex.get(calling);
            if (idx > 0) {
                // swap
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;

                // Map 갱신
                playerIndex.put(players[idx], idx);
                playerIndex.put(players[idx - 1], idx - 1);
            }
        }

        return players;
    }
}