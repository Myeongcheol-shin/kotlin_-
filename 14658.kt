package BJ_14658

import kotlin.math.max

var N = 0
var M = 0
var L = 0
var K = 0

lateinit var star : ArrayList<coordinate>
data class coordinate(val x : Int, val y : Int)
fun main()
{
    var tmp = readLine()!!.split(" ").map {it.toInt()}
    N = tmp[0]
    M = tmp[1]
    L = tmp[2]
    K = tmp[3]

    star = ArrayList()
    var ans = 0
    repeat(K)
    {
        i ->
        var tmp = readLine()!!.split(" ").map {it.toInt()}
        star.add(coordinate(tmp[0], tmp[1]))
    }

    for(i in 0 until K)
    {
        for(j in 0 until K)
        {
            var cnt = 0
            for(k in 0 until  K)
            {
                val x = star[i].x
                val y = star[j].y
                if(star[k].x in x..x+L && star[k].y in y..y+L) cnt++
            }
            ans = max(ans, cnt)
        }
    }
    println(K - ans)
}
