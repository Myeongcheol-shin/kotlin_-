class Solution {
    var dx = intArrayOf(-1,1,0,0)
    var dy = intArrayOf(0,0,1,-1)
    
    // 대각선 
    var dx1 = intArrayOf(-1,-1,1,1)
    var dy1 = intArrayOf(1,-1,-1,1)
    
    var checking : MutableList<MutableList<Pair<Int, Int>>> = mutableListOf(
        mutableListOf(Pair(-1,0), Pair(0,1)),
        mutableListOf(Pair(-1,0), Pair(0,-1)),
        mutableListOf(Pair(0,-1), Pair(1,0)),
        mutableListOf(Pair(0,1), Pair(1,0))
    )
    
    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        for(i in places) {
            answer.add(check(i))
        }
        
        return answer.toIntArray()
    }
    
    fun check(place : Array<String>) : Int {
        // P의 좌표를 먼저 찾아낸다.
        for(x in 0 until 5) {
            for(y in 0 until 5){
                if(place[x][y] == 'P') {
                    for(i in 0 until 4) {
                        val nx = x + dx[i]
                        val ny = y + dy[i]
                        if(nx in (0..4) && ny in (0..4)){
                            // 사람이 있는경우
                            if(place[nx][ny] == 'P') return 0                                                 // 빈테이블의 경우
                            else if(place[nx][ny] == 'O') {
                                val nnx = nx + dx[i]
                                val nny = ny + dy[i]
                                if(nnx in (0..4) && nny in (0..4)){
                                    // 사람이 있으면
                                    if(place[nnx][nny] == 'P') return 0
                                }
                            }
                            // 파티션인 경우는 문제가 없음
                        }
                    }
                    for(i in 0 until 4) {
                        val nx = x + dx1[i]
                        val ny = y + dy1[i]
                        if(nx in (0..4) && ny in (0..4)){
                            if(place[nx][ny] == 'P'){
                                for(check in checking[i]) {
                                    val nnx = check.first + x
                                    val nny = check.second + y
                                    if(nnx in (0..4) && nny in (0..4)){
                                        if(place[nnx][nny] == 'P'|| place[nnx][nny] == 'O') return 0
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1
    }
}