import java.util.*
import kotlin.math.max
import kotlin.math.min

var x = intArrayOf(1,-1,0,0)
var y = intArrayOf(0,0,1,-1)
var MAX = 20000010
fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    val N = input[0]
    val M = input[1]
    val K = input[2]

    val floor = Array(1000,{CharArray(1000,{'0'})})
    repeat(N){
            i ->
        val line = readLine().toString()
        repeat(M)
        {
                j ->
            floor[i][j] = line[j]
        }
    }
    val ar = Array(1000,{Array(1000,{IntArray(11,{MAX})})})
    val Q : Deque<IntArray> = LinkedList()

    Q.add(intArrayOf(0,0,0))
    repeat(K)
    {
            i->
        ar[0][0][i] = 0
    }
    while (Q.isNotEmpty())
    {
        val pd = Q.removeFirst()

        var pdx = pd[0]
        var pdy = pd[1]
        var remained = pd[2]
        repeat(4)
        {
                i ->
            val nx = pdx + x[i]
            val ny = pdy + y[i]

            if(nx in 0..N-1 && ny in 0..M-1)
            {
                if (remained + 1 <= K){
                    if(floor[nx][ny] == '0' && ar[nx][ny][remained] > ar[pdx][pdy][remained] + 1){
                        Q.add(intArrayOf(nx,ny,remained))
                        ar[nx][ny][remained]  = ar[pdx][pdy][remained] + 1
                    }
                    else if(floor[nx][ny] == '1' && ar[nx][ny][remained+1] > ar[pdx][pdy][remained] + 1){
                        Q.add(intArrayOf(nx,ny,remained + 1))
                        ar[nx][ny][remained + 1] = ar[pdx][pdy][remained] + 1
                    }
                }
                else{
                    if(floor[nx][ny] == '0' && ar[nx][ny][remained] > ar[pdx][pdy][remained] + 1){
                        Q.add(intArrayOf(nx,ny,remained))
                        ar[nx][ny][remained]  = ar[pdx][pdy][remained] + 1
                    }
                }
            }
        }
    }
    var ans = MAX
    for(i in 0..K)
    {
        ans = min(ar[N-1][M-1][i], ans)
    }
    if (ans == MAX) println(-1)
    else println(ans+1)
}