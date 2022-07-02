import java.util.*
import kotlin.math.max

fun main()
{
    val n = readLine()!!.toInt()
    val ar = readLine()!!.split(" ").map {it.toInt()}

    var dp = Array(100001,{IntArray(2,{0})})

    var ans = ar[0]
    for(i in 0..n-1){
        dp[i][0] = ar[i]
        dp[i][1] = ar[i]
        if(i == 0) continue
        dp[i][0] = max(dp[i-1][0] + ar[i], ar[i])
        dp[i][1] = max(dp[i-1][0],dp[i-1][1] + ar[i])
        ans = maxOf(ans, dp[i][0], dp[i][1])
    }
    println(ans)
}