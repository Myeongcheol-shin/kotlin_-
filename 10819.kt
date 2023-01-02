package BJ_10819

import kotlin.math.abs
import kotlin.math.max

var N : Int? = null
var A : List<Int>? = null
var ans :Int? = null

fun main()
{
    N = readln().toInt()
    A = readLine()!!.split(' ').map { it.toInt() }
    var check = BooleanArray(N!!, {false})
    var save = IntArray(N!!, {0})
    ans = 0
    dfs(0,check,save)
    System.out.println(ans)
}
fun cal(save:IntArray) : Int
{
    var sum = 0
    for(i in 1..save.size-1)
    {
       sum += abs(save[i-1] - save[i])
    }
    return sum
}
fun dfs(cnt : Int, check:BooleanArray,save : IntArray)
{
    if (cnt == N) {
        ans = max(ans!!, cal(save))
    }
    else {
        for(i in 0..N!!-1) {
            if(!check!![i]){
                check!![i] = true
                save[cnt] = A!![i]
                dfs(cnt+1, check, save)
                check!![i] = false
            }
        }
    }
}