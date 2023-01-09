package BJ_2531

import kotlin.math.max

fun main()
{
    var tmp = readLine()!!.split(" ").map{it.toInt()}
    var N = tmp[0]
    var d = tmp[1]
    var k = tmp[2]
    var c = tmp[3]
    var sushi = ArrayList<Int>()
    repeat(N)
    {
        sushi.add(readln().toInt())
    }

    var nList = ArrayList<Int>()

    repeat(k)
    {
        i ->
        nList.add(sushi[i])
    }
    var nSet = HashSet(nList)
    var i = 0
    var j = k-1
    var ans = 0

    while (i<N)
    {
        if(nSet.contains(c)) ans = max(ans, nSet.size)
        else ans = max(ans, nSet.size+1)
        nList.add(sushi[(++j)%N])
        nList.remove(sushi[i++])
        nSet = HashSet(nList)
        j %= N
    }
    println(ans)
}