package BJ_2531

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Deque
import java.util.LinkedList

var N = 0
var M = 0
lateinit var cheese : ArrayList<ArrayList<Int>>
var dx = listOf(0,0,1,-1)
var dy = listOf(1,-1,0,0)
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ").map { it.toInt() }
    N = tmp[0]
    M = tmp[1]

    cheese = arrayListOf()
    repeat(N) {cheese.add(ArrayList(br.readLine().split(" ").map { it.toInt() })) }

    var ans = 0
    /* 외각 찾기 */
    val k = findZero()
    while (true)
    {
        if(bfs(k.first,k.second)) ans++
        else break
    }
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}
fun findZero() : Pair<Int, Int>
{
    for (i in 0 until N)
    {
        if(cheese[i][0]==1) return Pair(i,0)
        if(cheese[i][M-1]==1) return Pair(i,M-i)
    }
    for (i in 0 until M)
    {
        if(cheese[0][i]==1) return Pair(0,i)
        if(cheese[N-1][i]==1) return Pair(N-1,i)
    }
    return Pair(0,0)
}

fun bfs(x : Int, y : Int) : Boolean
{
    var q : Deque<Pair<Int,Int>> = LinkedList()
    var visited = Array(N, {IntArray(M,{0})})
    q.add(Pair(x,y))
    while (q.isNotEmpty())
    {
        val pq = q.removeFirst()
        repeat(4)
        {
            i ->
            var nx = pq.first + dx[i]
            var ny = pq.second + dy[i]
            if(nx in 0 until N && ny in 0 until M)
            {
                /* 치즈가 있는 곳인 경우 */
                if(cheese[nx][ny] == 1)
                {
                    visited[nx][ny]++
                }
                /* 치즈가 없는 곳인 경우 */
                else
                {
                    /* 방문한 치즈인지 체크 */
                    if(visited[nx][ny] != -1) {
                        visited[nx][ny] = -1
                        q.add(Pair(nx,ny))
                    }
                }
            }
        }
    }
    var check = false
    for(i in 0 until N)
    {
        for(j in 0 until M)
        {
            if(visited[i][j] >= 2)
            {
                cheese[i][j] = 0
                check = true
            }
        }
    }
    return check
}