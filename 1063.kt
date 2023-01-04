
var sx : Int = 0
var sy : Int = 0
var cx : Int = 0
var cy : Int = 0
fun main() {
    var tmp = readLine()!!.split(" ")
    cx = tmp[0][0].toInt() - 64
    cy = tmp[0][1].toInt() - 48
    sx = tmp[1][0].toInt() - 64
    sy = tmp[1][1].toInt() - 48
    var N = tmp[2].toInt()

    repeat(N)
    {
        when(readLine())
        {
            "R" -> {
                move(1,0)
            }
            "L" -> {
                move(-1,0)
            }
            "B" -> {
                move(0,-1)
            }
            "T" -> {
                move(0,1)
            }
            "RT" -> {
                move(1,1)
            }
            "LT" -> {
                move(-1,1)
            }
            "RB" -> {
                move(1,-1)
            }
            "LB" -> {
                move(-1,-1)
            }
        }
    }
    System.out.printf("%s %s",(64 + cx).toChar() + cy.toString(),(64 + sx).toChar() + sy.toString())
}
fun move(x : Int, y : Int)
{
    if (canMove(x + cx, y + cy)){
        if (checkStone(x + cx , y + cy)){
            if(canMove( x + sx, y + sy)){
                sx += x
                sy += y
                cx += x
                cy += y
            }
        }
        else {
            cx += x
            cy += y
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
