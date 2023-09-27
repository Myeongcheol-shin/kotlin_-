class Solution {
    val dx = intArrayOf(0,0,1,-1)
    val dy = intArrayOf(-1,1,0,0)
    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        return dfs(aloc,bloc,0, board).second
    }
    
    // Pair -> 승패 / 진행된 턴
    fun dfs(aloc: IntArray, bloc: IntArray, move: Int, bd : Array<IntArray>) : Pair<Boolean, Int> {
          
        // 이동할 곳이 없는지 체크 (A가)
        var can_move = false
        val loc = if(move % 2 == 0) aloc else bloc
        for(i in (0..3)){
            val nx = loc[0] + dx[i]
            val ny = loc[1] + dy[i]
            if(nx in (0 until bd.size) && ny in (0 until bd[nx].size) && bd[nx][ny] != 0) {
                can_move = true
                break
            }
        }
        if(!can_move) {
            return Pair(move % 2 != 0, move)
        }       
        
        // 같은 위치의 경우
        // A의 턴 - A가 움직이면 B가 바로 패배
        if(aloc == bloc) {
            return Pair(move % 2 == 0, move+1)
        }
        
        val win = mutableListOf<Int>()
        val lose = mutableListOf<Int>()
        
        // 승리를 한다 ? => 한번이라도 승리하면됨
        // 패배 => 무조건 다져야함
        
        // 좌표를 이동하며 탐색
        // a의 차례
        if(move % 2 == 0){
            // 이동하므로 현재 위치를 0으로 바꿈
            bd[aloc[0]][aloc[1]] = 0
            for(i in (0..3)){
                val nx = aloc[0] + dx[i]
                val ny = aloc[1] + dy[i]
                if(nx in (0 until bd.size) && ny in (0 until bd[nx].size) && bd[nx][ny] != 0) {
                    val rt = dfs(intArrayOf(nx,ny), bloc, move+1, bd)
                    // a의 승리라면?
                    if(rt.first){
                        win.add(rt.second)
                    }
                    else{
                        lose.add(rt.second)
                    }
                }
            }
            // 돌려놓기
            bd[aloc[0]][aloc[1]] = 1
        }
        
        // b의 차례
        else{
            // 이동하므로 현재 위치를 0으로 바꿈
            bd[bloc[0]][bloc[1]] = 0
            for(i in (0..3)){
                val nx = bloc[0] + dx[i]
                val ny = bloc[1] + dy[i]
                if(nx in (0 until bd.size) && ny in (0 until bd[nx].size) && bd[nx][ny] != 0) {
                    val rt = dfs(aloc, intArrayOf(nx,ny), move+1,bd)
                    // b의 승리라면?
                    if(!rt.first){
                        win.add(rt.second)
                    }
                    else{
                        lose.add(rt.second)
                    }
                }
            }
            // 돌려놓기
            bd[bloc[0]][bloc[1]] = 1
        }
        
        // win 과 Lose 비교
        if(win.isNotEmpty()){
            var min = Integer.MAX_VALUE
            win.forEach{
                min = Math.min(min, it)
            }
            return Pair(move % 2 == 0, min)
        }
        else{
            var max = Integer.MIN_VALUE
            lose.forEach{
                max = Math.max(max, it)
            }
            return Pair(move % 2 != 0, max)
        }
    }
}