import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

lateinit var bus : Array<ArrayList<Edge>>
lateinit var arr : IntArray
lateinit var route : IntArray
data class Edge(val node : Int, val weight : Int) : Comparable<Edge>{
    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = br.readLine().toInt()
    var M = br.readLine().toInt()

    bus = Array(N+1){ arrayListOf() }
    arr = IntArray(N+1){Int.MAX_VALUE}
    route = IntArray(N+1){0}

    repeat(M)
    {
        val tmp = br.readLine().split(" ").map { it.toInt()}
        bus[tmp[0]].add(Edge(tmp[1],tmp[2]))
    }
    val tmp = br.readLine().split(" ").map { it.toInt() }
    dijkstra(tmp[0])
    bw.write(arr[tmp[1]].toString() + "\n")
    val routeList = arrayListOf<Int>()
    var now = tmp[1]
    while(now != 0)
    {
        routeList.add(now)
        now = route[now]
    }
    bw.write(routeList.size.toString() + "\n")
    bw.write(routeList.reversed().joinToString(" ") + "\n")
    bw.flush()
    bw.close()
}
fun dijkstra(start : Int)
{
    arr[start] = 0
    var pq = PriorityQueue<Edge>()
    pq.add(Edge(start,0))
    while (pq.isNotEmpty())
    {
        val curIdx = pq.peek().node
        val curWei = pq.peek().weight
        pq.poll()
        if(arr[curIdx] < curWei) continue
        for(i in bus[curIdx].indices)
        {
            val nextIdx = bus[curIdx][i].node
            val nextWei = curWei + bus[curIdx][i].weight
            if(nextWei < arr[nextIdx])
            {
                arr[nextIdx] = nextWei
                route[nextIdx] = curIdx
                pq.add(Edge(nextIdx,nextWei))
            }
        }
    }
}