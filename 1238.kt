package BJ_1238

import java.util.PriorityQueue
import kotlin.math.max

var N : Int = 0
lateinit var map : ArrayList<ArrayList<Pair>>
fun main()
{
    var tmp = readLine()!!.split(" ").map { it.toInt() }
    N = tmp[0]
    var M = tmp[1]
    var meet = tmp[2] - 1
    var ans = 0
    map = arrayListOf()
    for(i in 0 until N) map.add(ArrayList())
    repeat(M)
    {
        tmp = readLine()!!.split(" ").map { it.toInt() }
        map[tmp[0]-1]!!.add(Pair(tmp[1]-1,tmp[2]))
    }
    val log = arrayListOf<IntArray>()
    repeat(N)
    {
        i ->
        log.add(dijkstra(i))
    }
    repeat(N)
    {
        i ->
        ans = max(ans, log[i][meet] + log[meet][i])
    }
    println(ans)
}
data class Pair(val idx : Int, val dist : Int) : Comparable<Pair>{
    override fun compareTo(other: Pair): Int = dist - other.dist
}


fun dijkstra(start : Int) : IntArray
{
    var arr = IntArray(N,{Int.MAX_VALUE})
    var pq = PriorityQueue<Pair>()
    arr[start] = 0
    pq.add(Pair(start,0))
    while(pq.isNotEmpty())
    {
        var cur = pq.peek().idx
        var dist = pq.peek().dist
        pq.poll()

        if(arr[cur] < dist) continue
        for(i in 0 until map[cur]!!.size)
        {
            var next = map[cur]!![i].idx
            var nextDist = dist + map[cur]!![i].dist
            if(nextDist < arr[next]){
                arr[next] = nextDist
                pq.add(Pair(next, nextDist))
            }
        }
    }

    return arr
}