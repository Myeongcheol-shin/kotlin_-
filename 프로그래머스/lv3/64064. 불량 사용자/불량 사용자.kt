/*
문제 접근
1. dfs 방식
2. 일치하는 것을 찾으면 그것을 제외하고 다시 탐색
3. 무한 반복
*/
class Solution {
    var answer = mutableSetOf<Set<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        dfs(0, user_id.toMutableList(), banned_id)
        return answer.size
    }
    fun dfs(index : Int, user_id: MutableList<String>, banned_id : Array<String>) {
        if(index == banned_id.size) {
            answer.add(user_id.toSet())
        }
        else if(index < banned_id.size) {
            val ban = banned_id[index]
            user_id.forEachIndexed{ idx, v ->
                if(check(v,ban)) {
                    // deepcopy
                    val n_user_id = mutableListOf<String>()
                    n_user_id.addAll(user_id)
                    
                    n_user_id.removeAt(idx)
                    dfs(index+1, n_user_id, banned_id)
                }
                
            }
        }
        
    }
    // 일치하는지 확인
    fun check(a1 : String, a2 : String) : Boolean{
        // 먼저 글자 길이부터 체크
        if(a1.length != a2.length) return false
        for(i in 0 until a2.length){
            if(a2[i] == '*') continue
            if(a1[i] != a2[i]) return false
        }
        return true
    }
}