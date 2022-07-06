fun main()
{
    val input = readLine()!!.split(" ").map{it.toInt()}
    val H = input[0]
    val W = input[1]

    val water = Array(H,{IntArray(W,{0})})
    val wt = readLine()!!.split(" ").map{it.toInt()}
    for(i in 0..W-1)
    {
        repeat(wt[i])
        {
            j ->
            water[j][i] = 1
        }
    }
    var ans = 0
    for(i in 0..H-1)
    {
        var stack = 0
        var wall = false
        var now_wall = false
        for(j in 0..W-1)
        {
            if(water[i][j] == 1){
                if(!wall) wall = true
                else if(wall && now_wall) {
                    now_wall = false
                    ans += stack
                    stack = 0
                }
            }
            else if(water[i][j] == 0 && wall) {
                now_wall = true
                stack++
            }
        }
    }
    println(ans)
}