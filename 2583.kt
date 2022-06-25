import java.util.*
import kotlin.collections.ArrayList

var M : Int? = null
var N : Int? = null
var K : Int? = null
var ar : Array<IntArray>? = null
var count = 0
var dx = intArrayOf(1,-1,0,0)
var dy = intArrayOf(0,0,1,-1)

fun main() {
    var input = readLine()!!.split(' ').map { it.toInt() }
    M = input[0]
    N = input[1]
    K = input[2]
    ar = Array(M!!, { IntArray(N!!, { 0 }) })
    repeat(K!!) { i ->
        input = readLine()!!.split(' ').map { it.toInt() }
        val a = input[0]
        val b = input[1]
        val c = input[2]
        val d = input[3]

        for (j in b..d - 1) {
            for (k in a..c - 1) {
                ar!![j][k] = 1
            }
        }
    }
    var ans = ArrayList<Int>()
    repeat(M!!)
    {
            i ->
        repeat(N!!) { j ->
            if(ar!![i][j] == 0){
                count = 0
                dfs(i,j)
                ans.add(count)
            }
        }
    }
    var ansSorted = ans.sorted()
    println(ansSorted.size)
    println(ansSorted.joinToString(" "))
}

fun dfs(x:Int,y:Int)
{
    ar!![x][y] = 1
    count++

    repeat(4)
    {
        i ->
        var nx = x + dx[i]
        var ny = y + dy[i]

        if(nx in 0..M!!-1 && ny in 0..N!!-1 && ar!![nx][ny] == 0){
            dfs(nx,ny)
        }
    }
}