class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 1
        val wonho = scores[0]
        if(scores.filter{it[0] > wonho[0] && it[1] > wonho[1]}.size > 0) return -1
        for(i in 1 until scores.size){
            if(scores[i][0] + scores[i][1] <= wonho[0] + wonho[1]) continue
            var check = true
            for(j in 1 until scores.size){
                if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    check = false
                    break
                }
            }
            if(check) answer++
        }
        return answer
    }
}