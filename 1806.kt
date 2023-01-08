package BJ_1806

fun main()
{
    var tmp = readLine()!!.split(" ").map {it.toInt()}
    var N = tmp[0]
    var S = tmp[1]
    var arr = readLine()!!.split(" ").map { it.toInt() }
    var left = 0
    var right = 0
    var ans = Int.MAX_VALUE
    var sum = 0
    while(true)
    {
        if(sum >= S){
            sum -= arr[left]
            ans = Math.min(ans, right - left)
            left++
        }
        else if (right == N) break
        else sum += arr[right++]
    }
    if(ans == Int.MAX_VALUE) println(0)
    else println(ans)
}