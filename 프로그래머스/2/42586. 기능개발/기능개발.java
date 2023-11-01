
import java.util.*;
class Solution {

    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Integer date = 0;  
        Integer cnt = 0;
        Deque<ArrayList<Integer>> s = new ArrayDeque<ArrayList<Integer>>();
        
        // pair 추가
        for(int i = 0; i < progresses.length; i++){
            ArrayList<Integer> arr = new ArrayList();
            arr.add(progresses[i]);
            arr.add(speeds[i]);
            s.push(arr);
        }
        while(!s.isEmpty()){
            ArrayList<Integer> arr = s.getLast();
            if(date * arr.get(1) + arr.get(0) >= 100){
                cnt++;
                s.removeLast();
            }
            else {
                if(cnt > 0){
                    answer.add(cnt);
                    cnt = 0;
                }
                date++;
            }
        }
        if(cnt > 0){
            answer.add(cnt);
            cnt = 0;
        }
        return answer;
    }
}