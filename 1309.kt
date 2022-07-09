fun main()
{
    val N = readLine()!!.toInt()
    val dp = Array(3, {IntArray(100001,{0})})
    dp[0][0] = 1
    dp[1][0] = 1
    dp[2][0] = 1
    for(i in 1..100000)
    {
        dp[0][i] = (dp[2][i-1] + dp[1][i-1]) % 9901
        dp[1][i] = (dp[2][i-1] + dp[0][i-1]) % 9901
        dp[2][i] = (dp[0][i-1] + dp[1][i-1] + dp[2][i-1]) % 9901
    }
    println((dp[0][N-1] + dp[1][N-1] + dp[2][N-1]) % 9901)
}