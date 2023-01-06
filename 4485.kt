package BJ_4485

import java.util.LinkedList

lateinit var zelda : ArrayList<List<Int>>
lateinit var save : ArrayList<IntArray>
var N = 0
var ans = 0

var dx = listOf(1,-1,0,0)
var dy = listOf(0,0,1,-1)
fun main()
{
    var count = 1
    while(true)
    {
        N = readln().toInt()
        if(N==0) break
        ans = Int.MAX_VALUE
        zelda = arrayListOf()
        save = arrayListOf()
        repeat(N)
        {
            i ->
            zelda.add(readLine()!!.split(" ").map { it.toInt() })
            save.add(IntArray(N, { Int.MAX_VALUE }))
        }
        save[0][0] = zelda[0][0]
        bfs()
        System.out.printf("Problem %d: %d\n", count++, save[N-1][N-1])
    }
}
data class graph(val x : Int, val y : Int)
fun bfs()
{
    var q = LinkedList<graph>()
    q.add(graph(0,0))
    while(q.isNotEmpty())
    {
        var gp = q.poll()
        repeat(4)
        {
            i ->
            val nx = dx[i] + gp.x
            val ny = dy[i] + gp.y
            if(nx in 0..N-1  && ny in 0.. N-1 && save[nx][ny] > save[gp.x][gp.y] + zelda[nx][ny]){
                save[nx][ny] = save[gp.x][gp.y] + zelda[nx][ny]
                q.add(graph(nx,ny))
            }
        }
    }
}