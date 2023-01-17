import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val tmp = br.readLine().split(" ").map{it.toInt()}
    bw.write((tmp[0] + tmp[1]).toString())
    bw.flush()
    bw.close()
}