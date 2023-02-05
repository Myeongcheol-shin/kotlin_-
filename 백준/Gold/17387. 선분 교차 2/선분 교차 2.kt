import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

data class Point(val x : Long, val y : Long)
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var tmp = br.readLine().split(" ").map{it.toLong()}
    val a = Point(tmp[0],tmp[1])
    val b = Point(tmp[2],tmp[3])
    tmp = br.readLine().split(" ").map{it.toLong()}
    val c = Point(tmp[0],tmp[1])
    val d = Point(tmp[2],tmp[3])

    if(intersect(a,b,c,d)) bw.write("1")
    else bw.write("0")

    bw.flush()
    bw.close()
}

fun ccw(a : Point, b :Point, c : Point) : Int
{
    var op = (a.x * b.y) + (b.x * c.y) + (c.x * a.y)
    op -= (a.y * b.x) + (b.y * c.x) + (c.y * a.x)
    if(op > 0) return 1
    else if(op == 0L) return 0
    return -1
}

fun intersect(a : Point, b : Point, c : Point, d : Point) : Boolean {

    val com1 = min(a.x,b.x) <= max(c.x,d.x)
    val com2 = min(c.x,d.x) <= max(a.x,b.x)
    val com3 = min(a.y,b.y) <= max(c.y,d.y)
    val com4 = min(c.y,d.y) <= max(a.y,b.y)
    val ab = ccw(a,b,c) * ccw(a,b,d)
    val cd = ccw(c,d,a) * ccw(c,d,b)
    if(ab == 0 && cd == 0){
        if(com1 && com2 && com3 && com4) return true
        return false
    }
    return ab <= 0 && cd <= 0
}