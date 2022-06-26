import java.lang.Integer.max
import java.util.LinkedList
import java.util.Queue

var dx = intArrayOf(-1,1,0,0)
var dy = intArrayOf(0,0,1,-1)
fun main()
{
    var xy = readLine()!!.split(" ").map {it.toInt()}
    var x = xy[0]
    var y = xy[1]

    var answer = 0
    var tresure : Array<CharArray> = Array(x, { CharArray(y,{'W'}) })
    repeat(x)
    {
        i ->
        var k = readLine()!!
        repeat(y)
        { j ->
            tresure[i][j] = k[j]
        }
    }

    repeat(x)
    {
            i ->
        repeat(y){
                j ->
            if (tresure[i][j] == 'L')
            {
                answer = max(bfs(tresure,x,y,i,j), answer)
            }
        }
    }
    println(answer)
}

fun bfs(trs:Array<CharArray>, M:Int, N:Int,x:Int, y:Int) : Int {
    var check : Array<IntArray> = Array(M, { IntArray(N,{2500}) } )
    var Q:Queue<IntArray> = LinkedList()
    var ans = 0
    check[x][y] = 1
    Q.add(intArrayOf(x,y))
    while(Q.isNotEmpty())
    {
        var k = Q.poll()
        var qx = k[0]
        var qy = k[1]
        for(i in 0..3)
        {
            var nx = qx + dx[i]
            var ny = qy + dy[i]
            if (nx in 0..M-1 && ny in 0..N-1 && trs[nx][ny] == 'L' && check[qx][qy] + 1 < check[nx][ny])
            {
                ans = max(ans, check[qx][qy] + 1)
                check[nx][ny] = check[qx][qy] + 1
                Q.add(intArrayOf(nx,ny))
            }
        }
    }
    return ans - 1
}