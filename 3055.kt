import java.util.Deque
import java.util.LinkedList
import kotlin.math.min

var dx = intArrayOf(0,0,1,-1)
var dy = intArrayOf(1,-1,0,0)
var N = 0
var M = 0
var wt : Array<IntArray>? = null
fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    N = input[0]
    M = input[1]
    val t = Array(N,{CharArray(M,{'a'})})
    wt = Array(N,{IntArray(M,{10000})})
    for(i in 0..N-1)
    {
        val k = readLine()!!.toCharArray()
        for(j in 0..M-1)
        {
            t[i][j] = k[j]
        }
    }
    for(i in 0..N-1)
    {
        for(j in 0..M-1)
        {
            if(t[i][j] == '*') findWater(i,j,t)
        }
    }
    for(i in 0..N-1)
    {
        for(j in 0..M-1)
        {
            if(t[i][j] == 'S') {
                if(!bfs(i, j, t)) println("KAKTUS")
                return
            }
        }
    }
}

fun findWater(x:Int,y:Int, t:Array<CharArray>)
{
    val Q : Deque<IntArray> = LinkedList()
    Q.add(intArrayOf(x,y))
    wt!![x][y] = 0
    while(Q.isNotEmpty())
    {
        val pq = Q.removeFirst()
        var tx = pq[0]
        var ty = pq[1]
        repeat(4)
        {
            i ->
            var nx = tx + dx[i]
            var ny = ty + dy[i]
            if(nx in 0..N-1 && ny in 0..M-1 && t[nx][ny] == '.')
            {
                if(wt!![nx][ny] > wt!![tx][ty] + 1){
                    Q.add(intArrayOf(nx,ny))
                    wt!![nx][ny] = wt!![tx][ty] + 1
                }
            }
        }
    }
}
fun bfs(x:Int,y:Int,t:Array<CharArray>) : Boolean
{
    val Q: Deque<IntArray> = LinkedList()
    val visited = Array(N,{BooleanArray(M,{false})})
    visited[x][y] = true
    Q.add(intArrayOf(x,y,0))
    while(Q.isNotEmpty())
    {
        val pq = Q.removeFirst()
        var tx = pq[0]
        var ty = pq[1]
        var date = pq[2]
        repeat(4)
        {
            i->
            var nx = tx + dx[i]
            var ny = ty + dy[i]
            if(nx in 0..N-1 && ny in 0..M-1 && !visited[nx][ny] && wt!![nx][ny] > date + 1)
            {
                if(t[nx][ny] == '.'){
                    Q.add(intArrayOf(nx,ny,date+1))
                    visited[nx][ny] = true
                }
                else if(t[nx][ny] == 'D'){
                    wt!![nx][ny] = min(wt!![nx][ny], date+1)
                    println(wt!![nx][ny])
                    return true
                }
            }
        }
    }
    return false
}