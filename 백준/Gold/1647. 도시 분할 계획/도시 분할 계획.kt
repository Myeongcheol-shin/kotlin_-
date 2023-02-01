import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.max

lateinit var S : IntArray
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ").map { it.toInt() }
    val N = tmp[0]
    val M = tmp[1]

    S = IntArray(N){i -> i}

    val comp : Comparator<Triple<Int,Int,Int>> = compareBy { it.third }
    var arr = PriorityQueue(comp)

    repeat(M)
    {
        val tmp = br.readLine().split(" ").map{it.toInt()}
        arr.add(Triple(tmp[0]-1,tmp[1]-1,tmp[2]))
    }

    var ans = 0
    var mx = 0
    while(arr.isNotEmpty())
    {
        val tmp = arr.poll()
        if(!find(tmp.first, tmp.second))
        {
            unionParent(tmp.first, tmp.second)
            ans += tmp.third
            mx = max(mx, tmp.third)
        }
    }
    bw.write("${ans - mx}")
    bw.flush()
    bw.close()
}

fun getParent(x : Int) : Int
{
    if(x == S[x]) return x
    S[x] = getParent(S[x])
    return S[x]
}

fun unionParent(a : Int, b : Int)
{
    val a = getParent(a)
    val b = getParent(b)
    if(a>b) S[a] = b
    else S[b] = a
}

fun find(a : Int, b : Int) : Boolean
{
    val a = getParent(a)
    val b = getParent(b)
    if(a == b) return true
    return false
}