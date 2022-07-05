
val comb = mutableListOf<Long>()
fun main()
{
    val n = readLine()!!.toInt()
    if (n>1022){
        println(-1)
        return
    }
    for(i in 9 downTo  0 ) {combination(i.toLong())}
    val sorted = comb.sorted()
    println(sorted[n])
}

fun combination(x:Long)
{
    comb.add(x)
    val a = x % 10
    if (a >= 1){
        for(i in a-1 downTo 0){
            combination(x*10 + i)
        }
    }
}