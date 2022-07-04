import java.*
import java.util.*

fun main()
{
    val N = readLine()!!.toInt()
    val numList = readLine()!!.split(" ").map{it.toInt()}
    val dp = Array(100,{LongArray(21,{0})})

    dp[0][numList[0]] = 1
    for(i in 1..N-2)
    {
        for(j in 0..20)
        {
            if(dp[i-1][j] >= 1)
            {
                if(j + numList[i] <= 20) dp[i][j + numList[i]] += (dp[i-1][j])
                if(j - numList[i] >= 0) dp[i][j - numList[i]] += (dp[i-1][j])
            }
        }
    }
    println(dp[N-2][numList[N-1]])
}