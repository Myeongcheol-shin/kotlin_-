import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 정렬된 배열 큐(제일 큰 값이 있어야함.)
        // 그냥 우선순위로 저장된 큐
        // 정렬된 배열 큐에서 peek 값을 가져온다, 만약에 가져온 값의 우선순위가 더 크다면 다시 뒤로 넣음
        // 만약에 같다면 본인이므로 제외함.
        
        int[] pt = new int[priorities.length];
        Deque<ArrayList<Integer>> deque2 = new ArrayDeque<ArrayList<Integer>>();
        
        for(int i = 0; i < priorities.length; i++){
            pt[i] = priorities[i];
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(pt[i]);
            arr.add(i);
            deque2.add(arr);
        }
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        
        Arrays.sort(priorities);
        for(int i = 0 ; i < priorities.length; i++){
            deque.add(priorities[i]);
        }
        
        while(!deque2.isEmpty()){
            ArrayList<Integer> p = deque2.removeFirst();
            if(deque.getLast() == p.get(0)){
                answer++;
                if(p.get(1) == location) return answer;
                deque.removeLast();
            }
            else{
                deque2.add(p);
            }
        }
                
        return answer;
    }
}