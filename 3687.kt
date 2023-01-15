package BJ_3687

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

var minMatches = listOf(1,7,4,2,0,8)
var matchNum = listOf(2,3,4,5,6,7)
var ans : Long = 0
lateinit var maxMatch : String
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val T = br.readLine().toInt()

    var dp = LongArray(101) { Long.MAX_VALUE }
    for (i in matchNum.indices) dp[matchNum[i]] = minMatches[i].toLong()
    dp[6] = 6
    dp[1] = Int.MAX_VALUE.toLong()
    for(i in 8..100)
    {
        for(j in matchNum.indices)
        {
            dp[i] = min(dp[i], dp[i - j - 2] * 10 + minMatches[j])
        }
    }
    repeat(T)
    {
        val tmp = br.readLine().toInt()

        /* 최대 구하기 */
        maxMatch = ""
        if(tmp % 2 == 0)
        {
            repeat(tmp/2)
            {
                maxMatch += "1"
            }
        }
        else
        {
            maxMatch += "7"
            repeat(tmp/2-1)
            {
                maxMatch += "1"
            }
        }
        /* 최소 구하기 */
        val minMatch = dp[tmp]
        bw.write("$minMatch $maxMatch\n")
    }
    bw.flush()
    bw.close()
}