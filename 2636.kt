import java.util.Deque
import java.util.LinkedList
import java.util.Queue

var visited : Array<IntArray>? = null
var chz : Array<IntArray>? = null
var x = intArrayOf(0,0,1,-1)
var y = intArrayOf(1,-1,0,0)
var M : Int = 0
var N : Int = 0
fun main()
{
    var beforeCnt = 0
    var ct = 0
    var input = readLine()!!.split(" ").map {it.toInt()}
    M = input[0]
    N = input[1]
    visited = Array(M,{IntArray(N,{0})})
    chz = Array(M,{ IntArray(N,{0}) })
    repeat(M)
    {
        i ->
        input = readLine()!!.split(" ").map {it.toInt()}
        repeat(N)
        {
            j ->
            chz!![i][j] = input[j]
        }
    }

    var time = 0
    while(true)
    {
        beforeCnt = ct
        ct = bfs()
        if(ct > 0) {
            time++
        }
        else {
            println(time)
            println(beforeCnt)
            break
        }
    }
}

fun bfs() : Int
{
    val Q : Deque<IntArray> = LinkedList()
    Q.add(intArrayOf(0,0))
    visited = Array(M,{IntArray(N,{0})})
    visited!![0][0] = 1
    var count = 0
    while(Q.isNotEmpty())
    {
        val pq = Q.removeFirst()
        repeat(4)
        {
            i ->
            val nx = pq[0] + x[i]
            val ny = pq[1] + y[i]
            if (nx in 0..M-1 && ny in 0..N-1 && visited!![nx][ny] == 0){
                if (chz!![nx][ny] == 0)
                {
                    visited!![nx][ny] = 1
                    Q.add(intArrayOf(nx,ny))
                }
                else{
                    chz!![nx][ny] = 0
                    visited!![nx][ny] = 1
                    count++
                }
            }
        }
    }
    return count
}
