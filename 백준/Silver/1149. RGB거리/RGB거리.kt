import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

lateinit var rgb : Array<MutableList<Int>>
var rgbPair = listOf<Pair<Int,Int>>(Pair(1,2), Pair(0,2), Pair(0,1))
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    rgb = Array(N + 1){ mutableListOf() }
    rgb[0] = MutableList(3) {0}
    repeat(N)
    {
        i ->
        rgb[i + 1] = br.readLine().split(" ").map{it.toInt()} as MutableList<Int>
    }

    for(i in 1..N)
    {
        for(j in 0 until 3)
        {
            rgb[i][j] = min(rgb[i-1][rgbPair[j].first], rgb[i-1][rgbPair[j].second]) + rgb[i][j]
        }
    }

    bw.write(min(min(rgb[N][0],rgb[N][1]),rgb[N][2]).toString())
    bw.flush()
    bw.close()
}
