import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

var N = 0
var M = 0
lateinit var map : ArrayList<ArrayList<Edge>>
lateinit var arr : IntArray
data class Edge(val node : Int, val weight : Int) : Comparable<Edge>{
    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val tmp = br.readLine().split(" ").map {it.toInt()}
    map = ArrayList()
    N = tmp[0]
    M = tmp[1]
    arr = IntArray(N,{Int.MAX_VALUE})
    repeat(N){map.add(ArrayList())}
    repeat(M)
    {
        val tmp = br.readLine().split(" ").map {it.toInt()}
        map[tmp[0]-1].add(Edge(tmp[1]-1,tmp[2]))
        map[tmp[1]-1].add(Edge(tmp[0]-1,tmp[2]))
    }
    dijkstra(0)
    bw.write(arr[N-1].toString())
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
        val cur_idx = pq.peek().node
        val cur_weight = pq.peek().weight
        pq.poll()
        if(arr[cur_idx] < cur_weight) continue
        for(i in 0 until map[cur_idx].size)
        {
            var next_idx = map[cur_idx][i].node
            var next_wei = cur_weight + map[cur_idx][i].weight
            if(next_wei < arr[next_idx]){
                arr[next_idx] = next_wei
                pq.add(Edge(next_idx,next_wei))
            }
        }
    }
}

