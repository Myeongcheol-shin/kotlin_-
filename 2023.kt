
var N = 0
fun main()
{
    N = readLine()!!.toInt()
    val nb = intArrayOf(2,3,5,7)
    repeat(4)
    {
        i ->
        find(nb[i], 1)
    }
}
fun find(x : Int, sz : Int)
{
    if (sz == N)
    {
        println(x)
    }
    repeat(10)
    {
        i ->
        var newnumber = x * 10 + i
        if(is_prime_number(newnumber)){
            find(newnumber, sz + 1)
        }
    }
}
fun is_prime_number(x : Int) : Boolean
{
    for(i in 2..Math.sqrt(x.toDouble()).toInt()){
        if(x % i == 0)
            return false
    }
    return true
}