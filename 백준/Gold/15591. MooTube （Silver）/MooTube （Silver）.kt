import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.min

fun main()
{

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val ip = br.readLine().split(" ").map { it.toInt() }

    val N = ip[0]
    val Q = ip[1]
    val graph = Array(N){ mutableListOf<Pair<Int,Int>>() }

    repeat(N-1)
    {
        val ip = br.readLine().split(" ").map { it.toInt() }
        graph[ip[0]-1].add(Pair(ip[1]-1, ip[2]))
        graph[ip[1]-1].add(Pair(ip[0]-1, ip[2]))
    }

    repeat(Q)
    {
        val ip = br.readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(N){false}
        visited[ip[1]-1] = true
        var answer = 0
        var dq = ArrayDeque<Pair<Int,Int>>()
        dq.add(Pair(ip[1]-1, Int.MAX_VALUE))
        while(dq.isNotEmpty())
        {
            val data = dq.removeFirst()
            graph[data.first].forEach{ i ->
                val minValue = min(data.second, i.second)
                if(!visited[i.first] && minValue >= ip[0]){
                    answer++
                    dq.addLast(Pair(i.first, minValue))
                    visited[i.first] = true
                }
            }
        }
        bw.write("${answer.toString()}\n")
    }
    bw.flush()
    bw.close()
}
