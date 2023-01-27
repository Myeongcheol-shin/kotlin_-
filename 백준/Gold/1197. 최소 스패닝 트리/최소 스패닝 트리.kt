import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

var V = 0
lateinit var arr : PriorityQueue<Edge>
lateinit var set : IntArray

data class Edge(val a : Int, val b : Int, val distance : Int) : Comparable<Edge>
{
    override fun compareTo(other: Edge): Int {
        return distance - other.distance
    }
}
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ").map { it.toInt() }
    V = tmp[0]

    set = IntArray(tmp[0]){i -> i}
    arr = PriorityQueue()

    repeat(tmp[1])
    {
        val tmp = br.readLine().split(" ").map { it.toInt() }
        arr.add(Edge(tmp[0], tmp[1], tmp[2]))
    }
    var ans = 0
    while(arr.isNotEmpty())
    {
        val k = arr.remove()
        if(!(find(k.a-1, k.b-1))){
            ans += k.distance
            unionParent(k.a-1,k.b-1)
        }
    }
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun getParent(x : Int) : Int
{
    if(set[x] == x) return x
    set[x] = getParent(set[x])
    return set[x]
}

fun unionParent(a : Int, b : Int)
{
    val a = getParent(a)
    val b = getParent(b)
    if(a<b) set[b] = a
    else set[a] = b
}

fun find(a: Int, b : Int) : Boolean
{
    val a = getParent(a)
    val b = getParent(b)
    if(a==b) return true
    return false
}