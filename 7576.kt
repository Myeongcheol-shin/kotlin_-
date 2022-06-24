import java.util.*
import kotlin.math.max

var dx = intArrayOf(1,-1,0,0)
var dy = intArrayOf(0,0,1,-1)

fun main()
{
    var K = readLine()!!.split(' ').map {it.toInt()}
    var M = K[0]
    var N = K[1]
    val tomato = Array(N, {IntArray(M,{0})})

    repeat(N)
    {i ->
        var I = readLine()!!.split(' ').map {it.toInt()}
        repeat(M)
        {j ->
            tomato[i][j] = I[j]
        }
    }

    bfs(tomato, N,M)
}

fun bfs(tmt:Array<IntArray>, N:Int, M:Int){
    val Q:Queue<IntArray> = LinkedList()
    repeat(N){
        i ->
        repeat(M) {
            j ->
            if(tmt[i][j] == 1) Q.add(intArrayOf(i,j))
        }
    }
    while (Q.isNotEmpty())
    {
        var a = Q.poll()
        var x = a[0]
        var y = a[1]
        repeat(4){i ->
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0..N-1 && ny in 0..M-1 && tmt[nx][ny] == 0)
            {
                tmt[nx][ny] = tmt[x][y] + 1
                Q.add(intArrayOf(nx,ny))
            }
        }
    }
    var ans = 0
    repeat(N){
            i->
        repeat(M){
                j ->
            if(tmt[i][j] == 0){
                println(-1)
                return
            }
            ans = max(ans, tmt[i][j])
        }
    }
    println(ans - 1)
}