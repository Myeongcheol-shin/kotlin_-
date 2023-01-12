package BJ_1446

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.min

data class highway(val start : Int, val end : Int, val distance : Int) : Comparable<highway> {
    override fun compareTo(other: highway): Int {
        return start - other.start
    }
}
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var tmp = br.readLine().split(" ").map{it.toInt()}
    var N = tmp[0]
    var D = tmp[1]
    var pq = PriorityQueue<highway>()
    var arr = IntArray(D+1){i -> i}
    repeat(N)
    {
        tmp = br.readLine().split(" ").map{it.toInt()}
        pq.add(highway(tmp[0],tmp[1],tmp[2]))
    }
    while (pq.isNotEmpty())
    {
        val p = pq.poll()
        if(p.end <= D) {
            if(p.end - p.start <= p.distance) continue
            if(arr[p.end] > arr[p.start] + p.distance){
                val dist = arr[p.start] + p.distance
                for (i in p.end .. D) arr[i] = min(dist + i - p.end, arr[i])
            }
        }
    }
    bw.write(arr[D].toString())
    bw.flush()
    bw.close()
}