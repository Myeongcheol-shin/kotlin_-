import kotlin.math.max

fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    val n = input[0]
    val k = input[1]

    val dp = Array(101,{IntArray(100001,{0})})
    val w = IntArray(101,{0})
    val v = IntArray(101,{0})
    repeat(n)
    {
        i ->
        val t = readLine()!!.split(" ").map{it.toInt()}
        w[i+1] = t[0]
        v[i+1] = t[1]
    }

    for(i in 1..n)
    {
        for(j in 1..k)
        {
            if(j-w[i] >= 0) dp[i][j] = max(dp[i-1][j], dp[i-1][j - w[i]] + v[i])
            else dp[i][j] = dp[i-1][j]
        }
    }
    println(dp[n][k])
}