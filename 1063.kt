package BJ_1063

var sx : Int = 0
var sy : Int = 0
var cx : Int = 0
var cy : Int = 0
fun main() {
    var tmp = readLine()!!.split(" ")
    var sx = tmp[0][0].toInt() - 64
    var sy = tmp[0][1].toInt() - 48
    var cx = tmp[1][0].toInt() - 64
    var cy = tmp[1][1].toInt() - 48
    var N = tmp[2].toInt()

    repeat(N)
    {
        when(readLine())
        {
            "R" -> {

            }
            "L" -> {

            }
            "B" -> {

            }
            "T" -> {

            }
            "RT" -> {

            }
            "LT" -> {

            }
            "RB" -> {

            }
            "LB" -> {

            }
        }
    }
}

fun canMove(x : Int, y : Int) : Boolean
{
    if (x in 1..8 && y in 1..8) return true
    return false
}
fun checkStone(x : Int, y : Int) : Boolean
{
    if (sx == x && sy == y) return true
    return false
}