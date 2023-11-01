import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : scoville){
            pq.add(i);
        }
        while(pq.size() >= 2 && pq.peek() < K){
            Integer a = pq.poll();
            Integer b = pq.poll();
            Integer c = a + (b * 2);
            pq.add(c);
            answer++;
        }
        if(pq.size() < 2){
            while(!pq.isEmpty()){
                if(pq.poll() < K) return -1;
            }
        }
        return answer;
    }
}