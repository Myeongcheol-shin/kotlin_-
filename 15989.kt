import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main()
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val N = br.readLine().toInt()

    var dp = ArrayList<IntArray>()
    dp.add(IntArray(10001,{0}))
    dp[0][0] = 1
    repeat(3)
    {
        dp.add(IntArray(10001,{0}))
    }
    for(i in 1 ..3){
        for(j in 0..10000)
        {
            if(j < i) dp[i][j] = dp[i-1][j]
            else dp[i][j] = dp[i][j-i] + dp[i-1][j]
        }
    }
    repeat(N)
    {
        bw.write(dp[3][br.readLine().toInt()].toString() + "\n")
    }
    bw.flush()
    bw.close()
}