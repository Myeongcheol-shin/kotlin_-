import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

const val MAX_VALUE = 10000000
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    val rgb :Array<MutableList<Int>> = Array(N){ mutableListOf() }
    repeat(N) {
        rgb[it] = br.readLine().split(" ").map { it.toInt() } as MutableList<Int>
    }

    // 조건 1 : 1번 집 != 2번집 + N번집
    // 조건 2 : N번 집 != N-1 번집
    // 조건 3 : N번 집 != N-1 , N+1 (양 옆이 같으면 안된다.)

    var ans = MAX_VALUE
    for(i in 0 until  3){
        val dp = MutableList(N){MutableList(3){MAX_VALUE}}
        dp[0][i] = rgb[0][i]
        for(j in 1 until  N) {
            dp[j][0] = rgb[j][0] + min(dp[j-1][1], dp[j-1][2])
            dp[j][1] = rgb[j][1] + min(dp[j-1][0], dp[j-1][2])
            dp[j][2] = rgb[j][2] + min(dp[j-1][0], dp[j-1][1])
        }
        repeat(3){
            if(it != i) ans = min(ans, dp.last()[it])
        }
    }
    bw.write(ans.toString())
    bw.flush()
    bw.close()

}