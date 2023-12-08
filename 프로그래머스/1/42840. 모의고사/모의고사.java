import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] score = {0,0,0};
        
        // 찍는 방식
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++){
            if(student1[i % 5] == answers[i]){
                score[0]++;
            }
            if(student2[i%8] == answers[i]){
                score[1]++;
            }
            if(student3[i%10] == answers[i]){
                score[2]++;
            }
        }
        int tmp = 0;
        for(int s : score){
            System.out.println(s);
            if(tmp < s) {
                tmp = s;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(tmp == score[i]){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}