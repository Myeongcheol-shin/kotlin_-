import kotlin.contracts.contract
import kotlin.math.max

fun main()
{
    var N = readLine()!!.toInt()
    val dp = IntArray(N+1,{0})
    val t = IntArray(N+1, {0})
    val p = IntArray(N+1,{0})

    repeat(N)
    {
        i->
        var input = readLine()!!.split(" ").map{it.toInt()}
        t[i] = input[0]
        p[i] = input[1]
        if(i+t[i] < N) dp[i] = p[i]
    }

    for(i in 0..N-1)
    {
        for(j in i + t[i]..N-1){
            if(j + t[j] > N) continue
            dp[j] = max(dp[i] + p[j], dp[j])
        }
    }
    println(dp.maxOf { it.toInt() })
}