import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = br.readLine().toInt()

    var polygon = mutableListOf<Pair<Double, Double>>()
    repeat(N)
    {
        val tmp = br.readLine().split(" ").map { it.toDouble() }
        polygon.add(Pair(tmp[0], tmp[1]))
    }

    var answer = 0.0
    for(i in 1 until N-1){
        answer += ccw(polygon[0], polygon[i], polygon[i+1])
    }
    
    bw.write(String.format("%.1f", abs(answer)))
    bw.flush()
    bw.close()
}

fun ccw(standard : Pair<Double, Double>, a : Pair<Double, Double>, b : Pair<Double, Double>) : Double
{
    return ((standard.first * a.second + a.first * b.second + b.first * standard.second) - (standard.first * b.second + standard.second * a.first + a.second * b.first)) * 0.5
}
