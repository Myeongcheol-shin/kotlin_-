var base = arrayOf(
    longArrayOf(1,1),
    longArrayOf(1,0)
)
fun main()
{
    var N : Long = readln().toLong()
    println(fibo(N)[1][0])
}
fun fibo(n : Long) : Array<LongArray>
{
    if(n == 1L)
    {
        return base
    }
    val tmp = fibo(n/2)
    if(n % 2 == 1L)
    {
        return matrixMul(matrixMul(tmp,tmp),base)
    }
    else
    {
        return matrixMul(tmp, tmp)
    }
}
fun matrixMul(l1 : Array<LongArray>, l2 : Array<LongArray>) : Array<LongArray>
{
    val tmp = Array(2) {LongArray(2){0} }
    for(i in l1.indices)
    {
        for(j in l1.indices)
        {
            for(k in l1.indices)
            {
                tmp[i][j] += l1[i][k] * l2[k][j]
                tmp[i][j] %= 1000000L
            }
        }
    }
    return tmp
}