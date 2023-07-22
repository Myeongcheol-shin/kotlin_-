import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val solid = br.readLine().split(" ").map { it.toLong() } as MutableList
    solid.sort()
    var ans = MutableList<Long>(3){0}
    var ansSum = Long.MAX_VALUE

    for(i in 0 until solid.size - 2){
        var left = i + 1
        var right = solid.size - 1
        while(left < right){
            val ns : Long = solid[i] + solid[left] + solid[right]
            if(abs(ns) < ansSum) {
                ans = mutableListOf(solid[i], solid[left], solid[right])
                ansSum = abs(ns)
            }
            if(ns < 0) left++
            else right--
        }
    }

    bw.write(ans.joinToString(" "))
    bw.flush()
    bw.close()
}


