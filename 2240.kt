import java.util.*
import kotlin.math.max

fun main()
{
    val input = readLine()!!.split(" ").map {it.toInt()}
    val T = input[0]
    val W = input[1]

    val plumList = Array(3,{Array(1001,{IntArray(32,{0})})})

    for (i in 1..T)
    {
        val plumDrop = readLine()!!.toInt()
        for (j in 1..W+1)
        {
            if (plumDrop == 1)
            {
                plumList[1][i][j] = max(plumList[1][i-1][j] + 1, plumList[2][i-1][j-1] + 1)
                plumList[2][i][j] = max(plumList[1][i-1][j-1], plumList[2][i-1][j])
            }
            else
            {
                if(i == 1 && j == 1) continue
                plumList[1][i][j] = max(plumList[2][i-1][j-1], plumList[1][i-1][j])
                plumList[2][i][j] = max(plumList[2][i-1][j] + 1, plumList[1][i-1][j-1] + 1)
            }
        }
    }
    var ans = 0
    for(i in 1..W+1){
        ans = maxOf(plumList[1][T][i],plumList[2][T][i], ans)
    }
    println(ans)
}