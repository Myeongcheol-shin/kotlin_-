import java.util.Deque
import java.util.LinkedList

fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    val N = input[0]
    val K = input[1]
    val MAX = 100001
    val visited = IntArray(MAX,{MAX})
    visited[N] = 0
    val dq : Deque<Int> = LinkedList()
    dq.addFirst(N)

    while(dq.isNotEmpty())
    {
        val pd = dq.removeFirst()
        if(pd == K) {
            println(visited[pd])
            return
        }
        if(pd * 2 < MAX && visited[pd*2] == MAX){
            dq.addFirst(pd*2)
            visited[pd*2] = visited[pd]
        }
        if (pd+1 < MAX && visited[pd+1] == MAX){
            dq.addLast(pd+1)
            visited[pd+1] = visited[pd] + 1
        }
        if (pd-1 >= 0 && visited[pd-1] == MAX){
            dq.addLast(pd-1)
            visited[pd-1] = visited[pd] + 1
        }
    }

}