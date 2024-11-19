// 거리두기 확인하기
class Solution {
    
    private static final int[] dy = {-1, 0, 0, 1};
    private static final int[] dx = {0, 1, -1, 0};

    private boolean isNextToVolunteer(char[][] room, int y, int x, int exclude){
        for(int d = 0; d < 4; d++){
            if(d == exclude) continue;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    private boolean isDistanced(char[][] room, int y, int x){
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch(room[ny][nx]){
                case 'P': return false;
                case 'O':
                    if(isNextToVolunteer(room, ny, nx, 3 - d)) return false;
                    break;
            }
        }    
        return true;
    }
    
    private boolean isDistanced(char[][] room){
        for(int i = 0; i < room.length; i++){
            for(int j = 0; j < room[0].length; j++){
                if(room[i][j] != 'P') continue;
                if(!isDistanced(room, i , j)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < answer.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++){
                room[j] = place[j].toCharArray();
            }
            if(isDistanced(room)){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}