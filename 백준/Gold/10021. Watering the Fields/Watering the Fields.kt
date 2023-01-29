import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.pow

var C = 0
lateinit var S : IntArray
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val arr = arrayListOf<Pair<Int, Int>>()
    val tmp = br.readLine().split(" ").map{it.toInt()}

    C = tmp[1]
    S = IntArray(tmp[0]){i -> i}
    repeat(tmp[0])
    {
        val tmp = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(tmp[0],tmp[1]))
    }

    val comparable : Comparator<Triple<Int,Int,Int>> = compareBy { it.third }
    var E = PriorityQueue(comparable)

    for(i in 0 until arr.size)
    {
        for(j in i until arr.size)
        {
            val tmp = (arr[i].first - arr[j].first).toFloat().pow(2)  + (arr[i].second - arr[j].second).toFloat().pow(2)
            if(tmp >= C) E.offer(Triple(i,j,tmp.toInt()))
        }
    }
    var ans = 0
    var count = 0
    while (E.isNotEmpty())
    {
        val tmp = E.remove()
        if(find(tmp.first, tmp.second)){
            ans += tmp.third
            count++
            unionParent(tmp.first, tmp.second)
        }
    }
    if(count < tmp[0]-1) bw.write("-1")
    else bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun getParent(a : Int) : Int
{
    if(S[a] == a) return a
    S[a] = getParent(S[a])
    return S[a]
}

fun unionParent(a : Int, b : Int)
{
    val a = getParent(a)
    val b = getParent(b)
    if(a < b) S[b] = a
    else S[a] = b
}

fun find(a : Int, b : Int) : Boolean
{
    val a = getParent(a)
    val b = getParent(b)
    if(a == b) return false
    return true
}
