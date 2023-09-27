class Solution {
    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        return search(board, Pair(aloc[0], aloc[1]), Pair(bloc[0], bloc[1]), 0).second
    }
    fun search(board:Array<IntArray>, aloc: Pair<Int,Int>, bloc: Pair<Int,Int>, turn : Int) : Pair<Boolean, Int> {
        // 이동 가능한지 체크
        val next_list : MutableList<Pair<Int,Int>> = if(turn % 2 == 0) get_next(board, aloc) else get_next(board, bloc)
        
        if(next_list.isEmpty()) return Pair(turn % 2 != 0, turn)
        // 일치하면
        if(aloc == bloc) return Pair(turn % 2 == 0, turn + 1)
        
        // dfs
        val win = mutableListOf<Int>()
        val lose = mutableListOf<Int>()
        
        if(turn % 2 == 0) {
            board[aloc.first][aloc.second] = 0
            next_list.forEach {
                val (can_move, cnt) = search(board, Pair(it.first, it.second), bloc, turn + 1)
                if(can_move) win.add(cnt)
                else lose.add(cnt)
            }  
            board[aloc.first][aloc.second] = 1
        }
        else {
            board[bloc.first][bloc.second] = 0
            next_list.forEach {
                val (can_move, cnt) = search(board, aloc, Pair(it.first, it.second), turn + 1)
                if(!can_move) win.add(cnt)
                else lose.add(cnt)
            }  
            board[bloc.first][bloc.second] = 1
        }
        return if(win.isNotEmpty()) Pair(turn % 2 == 0 , win.minOrNull() ?: 0) 
            else Pair(turn % 2 != 0, lose.maxOrNull() ?: 0)
    }
    fun get_next(board:Array<IntArray>, loc:Pair<Int,Int>) : MutableList<Pair<Int,Int>>{
        val dx = intArrayOf(1,-1,0,0)
        val dy = intArrayOf(0,0,1,-1)
        val mt = mutableListOf<Pair<Int,Int>>()
        for(i in (0 until 4)){
            val nx = dx[i] + loc.first
            val ny = dy[i] + loc.second
            if(nx in (0 until board.size) && ny in (0 until board[0].size) && board[nx][ny] == 1) mt.add(Pair(nx,ny))
        }
        return mt
    }
}