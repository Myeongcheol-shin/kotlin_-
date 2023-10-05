class Solution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        // dfs로 지금 현재 숫자의 합을 저장한다.
        dfs(0,0,target,numbers)
        return answer
    }
    fun dfs(idx : Int, sum : Int, target : Int, numbers:IntArray)
    {
        if(idx == numbers.size){
            if(sum == target) answer++       
        }
        else{
            dfs(idx+1, sum + numbers[idx], target, numbers)
            dfs(idx+1, sum - numbers[idx], target, numbers)
        }
    }
}