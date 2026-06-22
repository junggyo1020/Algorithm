import java.util.*;

class Solution {
    
    static HashMap<String, String> hM = new HashMap<>();
    
    public String[] solution(String[] record) {
        int size = 0;
        
        for(String s : record) {
            StringTokenizer st = new StringTokenizer(s);
            
            String op = st.nextToken();
            if(op.equals("Enter")) {
                Enter(st.nextToken(), st.nextToken());
                size++;
            } else if(op.equals("Leave")) {
                size++;
            } else if(op.equals("Change")) { 
                Change(st.nextToken(), st.nextToken());
            }
        }
        
        String[] answer = new String[size];
        int idx = 0;
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            if(command.equals("Enter")) {
                answer[idx++] = hM.get(st.nextToken()) + "님이 들어왔습니다.";
            } else if(command.equals("Leave")) {
                answer[idx++] = hM.get(st.nextToken()) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
                      
    private static void Enter(String uid, String name) {
        hM.put(uid, name);
    }
                      
    private static void Change(String uid, String name) {
        hM.put(uid, name);
    }
}