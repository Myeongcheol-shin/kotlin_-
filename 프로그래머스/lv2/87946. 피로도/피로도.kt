class Solution {
    lateinit var visited : MutableList<Boolean>
    var answer = -1
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        // 던전 목록이 있음
        // 최대한 많이 방문해야함. 던전을 방문할수도 안할수도 있음
        // visit 배열을 선언해서 방문한 목록을 체크한다.
        visited = MutableList<Boolean>(dungeons.size){false}
        dfs(k, dungeons, 0)
        return answer
    }
    fun dfs(k : Int, dungeons : Array<IntArray>, move : Int){
        var vst = false
        visited.forEachIndexed{idx, v ->
            if(!v && dungeons[idx][0] <= k) {    
                visited[idx] = true
                dfs(k - dungeons[idx][1], dungeons, move+1)
                visited[idx] = false
                vst = true
            }
        }  
        answer = Math.max(answer, move)
        if(!vst) return
    }
}