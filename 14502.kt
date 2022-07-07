import java.util.*
import kotlin.math.max

var lab : Array<IntArray>? = null
var N = 0
var M = 0
var dx = intArrayOf(0,0,1,-1)
var dy = intArrayOf(1,-1,0,0)
var ans = 0
fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    N = input[0]
    M = input[1]
    lab = Array(N,{ IntArray(M,{0}) })
    repeat(N)
    {
        i->
        val ip = readLine()!!.split(" ").map{it.toInt()}
        repeat(M){
            j ->
            lab!![i][j] = ip[j]
        }
    }
    wall(0)
    println(ans)
}

fun wall(cnt : Int)
{
    if(cnt == 3){
        bfs()
        return
    }
    for(i in 0..N-1)
    {
        for(j in 0..M-1)
        {
            if(lab!![i][j] == 0){
                lab!![i][j] = 1
                wall(cnt + 1)
                lab!![i][j] = 0
            }
        }
    }
}

fun bfs()
{
    val Q : Deque<IntArray> = LinkedList()
    val vQ : Deque<IntArray> = LinkedList()

    val visited = Array(N,{BooleanArray(M,{false})})
    var cnt = 0
    for(i in 0..N-1)
    {
        for(j in 0..M-1)
        {
            if(lab!![i][j] == 2){
                vQ.add(intArrayOf(i,j))
                visited[i][j] = true
            }
        }
    }


    while(vQ.isNotEmpty())
    {
        val vpq = vQ.removeFirst()
        Q.add(vpq)
        while(Q.isNotEmpty())
        {
            val pq = Q.removeFirst()
            var x = pq[0]
            var y = pq[1]

            repeat(4)
            {
                    i->
                var nx = x + dx[i]
                var ny = y + dy[i]
                if(nx in 0..N-1 && ny in 0..M-1 && !visited[nx][ny] && lab!![nx][ny] == 0)
                {
                    Q.add(intArrayOf(nx,ny))
                    visited[nx][ny] = true
                }
            }
        }
    }

    for(i in 0..N-1)
    {
        for(j in 0..M-1)
        {
            if(lab!![i][j] == 0 && !visited[i][j])
            {
                cnt++
            }
        }
    }
    ans = max(cnt, ans)
}