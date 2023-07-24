import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var dp : MutableList<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    val seq = mutableListOf<Int>(0)
    seq.addAll(br.readLine().split(" ").map { it.toInt() })
    dp = MutableList(N+1){0}

    var depth = 1
    for(i in 1 until seq.size) {
        val idx = binarySearch(0, depth-1, seq[i])
        if(idx == -1) {
            dp[depth] = seq[i]
            depth++
        }
        else dp[idx] = seq[i]
    }
    bw.write((depth-1).toString())
    bw.flush()
    bw.close()
}

fun binarySearch(start : Int, end : Int, find: Int) : Int {
    val mid : Int = (start + end) / 2
    if(start > end) return -1
    if(dp[mid] < find && find <= dp[mid+1]) return mid + 1
    if(dp[mid] >= find) return binarySearch(start, mid-1, find)
    if(dp[mid] < find) return binarySearch(mid+1, end, find)
    return -1
}