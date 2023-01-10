package BJ_20437

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = br.readLine().toInt()
    repeat(N)
    {
        var W = br.readLine().toString()
        var K = br.readLine().toInt()

        var abcIndex = Array(26,{ arrayListOf<Int>() })
        repeat(W.length)
        {
            i ->
            abcIndex[W[i] - 'a'].add(i)
        }
        var answer1 = Int.MAX_VALUE
        var answer2 = Int.MIN_VALUE
        for(i in 0 until 26)
        {
            if(abcIndex[i].size < K) continue
            var left = 0
            var right = K - 1
            while(right < abcIndex[i].size)
            {
                answer1 = min(answer1, abcIndex[i][right] - abcIndex[i][left])
                answer2 = max(answer2, abcIndex[i][right++] - abcIndex[i][left++])
            }
        }
        if(answer1 == Int.MAX_VALUE) bw.write("-1\n")
        else{
            answer1++
            answer2++
            bw.write("$answer1 $answer2\n")
        }
    }

    bw.flush()
    bw.close()
}