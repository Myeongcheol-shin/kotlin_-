import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ")

    var N = tmp[0].toInt()
    var B = tmp[1].toLong()
    var arr = Array(N){IntArray(N)}
    repeat(N)
    {
        i ->
        arr[i] = (br.readLine().split(" ").map { it.toInt() }.toIntArray())
    }
    val ans = mul(arr,B)
    for(i in ans)
    {
        for(j in i)
        {
            val t = j % 1000
            bw.write("$t ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

fun mul(arr : Array<IntArray>, N : Long) : Array<IntArray>
{
    if(N == 1L) return arr
    val tmp = mul(arr,N/2)
    if(N % 2 == 1L) return matrixMul(matrixMul(tmp,tmp), arr)
    return matrixMul(tmp, tmp)
}

fun matrixMul(arr1 : Array<IntArray>, arr2 : Array<IntArray>) : Array<IntArray>
{
    val tmp = Array(arr1.size){IntArray(arr1.size){0} }
    for(i in arr1.indices)
    {
        for(j in arr1.indices)
        {
            for(k in arr1.indices)
            {
                tmp[i][j] += arr1[i][k] * arr2[k][j]
                tmp[i][j] %= 1000
            }
        }
    }
    return tmp
}