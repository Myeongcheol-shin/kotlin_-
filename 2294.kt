import java.lang.Integer.min

fun main()
{
    var coinArr : IntArray = IntArray(10001,{10001})
    coinArr[0] = 0
    var input = readLine()!!.split(" ").map {it.toInt()}
    var n = input[0]
    var k = input[1]

    var coinPrice : IntArray = IntArray(101,{0})

    repeat(n)
    {
        i ->
        coinPrice[i] = readLine()!!.toInt()
        for (j in coinPrice[i]..k)
        {
            coinArr[j] = min(coinArr[j], coinArr[j - coinPrice[i]] + 1)
        }
    }

    if(coinArr[k] == 10001) println(-1)
    else println(coinArr[k])

}