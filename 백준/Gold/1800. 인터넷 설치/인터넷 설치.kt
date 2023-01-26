import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue


lateinit var arr : Array<ArrayList<Edge>>
lateinit var dist : IntArray
var end = 0
var ans = -1
var sale = 0
data class Edge(val node : Int, val weight : Int) : Comparable<Edge>
{
    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val tmp = br.readLine().split(" ").map{it.toInt()}

    arr = Array(tmp[0]+1){ arrayListOf() }
    end = tmp[0]
    sale = tmp[2]
    repeat(tmp[1])
    {
        val tmp2 = br.readLine().split(" ").map { it.toInt() }
        arr[tmp2[0]].add(Edge(tmp2[1],tmp2[2]))
        arr[tmp2[1]].add(Edge(tmp2[0],tmp2[2]))
    }

    var l = 0
    var r = 1000000

    while (l <= r)
    {
        dist = IntArray(tmp[0]+1){Int.MAX_VALUE}
        val mid = (l + r) / 2
        if(dijkstra(mid)) {
            ans = mid
            r = mid - 1
        } else
        {
          l = mid + 1
        }
    }
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun dijkstra(w : Int) : Boolean
{
    dist[1] = 0
    var pq = PriorityQueue<Edge>()
    pq.add(Edge(1,0))
    while (pq.isNotEmpty())
    {
        val cur = pq.poll()
        arr[cur.node].forEach{
            it ->
            var x = 1
            if(it.weight <= w) x = 0
            if(dist[it.node] > cur.weight + x) {
                dist[it.node] = cur.weight + x
                pq.add(Edge(it.node,cur.weight + x))
            }
        }
    }
    return dist[end] <= sale
}

