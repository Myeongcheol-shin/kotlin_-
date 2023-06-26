import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val tmp = br.readLine().split(" ").map{it.toLong()}
    bw.write(recr(tmp[0],tmp[1],tmp[2]).toString())
    bw.flush()
    bw.close()
}

fun recr(a : Long, b : Long, c : Long) : Long {
    if(b.equals(1L)) return a % c
    val tmp = recr(a, b / 2, c)
    return if((b % 2).equals(0L)) (tmp * tmp) % c else (((tmp * tmp) % c) * a) % c
}