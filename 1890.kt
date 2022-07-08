fun main()
{
    val N = readLine()!!.toInt()
    val dp = Array(N,{LongArray(N,{0})})
    val jmp = Array(N,{LongArray(N,{0})})
    dp[0][0] = 1
    repeat(N)
    {
        i->
        val input = readLine()!!.split(" ").map{it.toInt()}
        repeat(N)
        {
            j->
            jmp[i][j] = input[j].toLong()
        }
    }
    repeat(N)
    {
        i->
        repeat(N)
        {
            j->

            if(jmp[i][j] != 0.toLong()){
                val right : Int = j + jmp[i][j].toInt()
                val down : Int = i + jmp[i][j].toInt()
                if(down < N) dp[down][j] += dp[i][j]
                if(right < N) dp[i][right] += dp[i][j]
            }
        }
    }
    println(dp[N-1][N-1])
}