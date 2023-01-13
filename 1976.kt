package BJ_1976

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent : IntArray
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = br.readLine().toInt()
    var M = br.readLine().toInt()

    parent = IntArray(N,{it})
    repeat(N)
    {
        i ->
        val tmp = br.readLine().split(" ").map { it.toInt() }
        for(j in tmp.indices)
        {
            if(tmp[j] == 0) continue
            if(getParent(i) == getParent(j)) continue
            union(i,j)
        }
    }
    val tmp = br.readLine().split(" ").map { it.toInt() }
    for(i in 0 until tmp.size-1)
    {
        if(getParent(tmp[i]-1) != getParent(tmp[i+1]-1)){
            bw.write("NO")
            bw.flush()
            bw.close()
            return
        }
    }
    bw.write("YES")
    bw.flush()
    bw.close()
}

fun getParent(x : Int) : Int
{
    if(parent[x] == x) return x
    parent[x] = getParent(parent[x])
    return parent[x]
}
fun union(x: Int, y : Int)
{
    val x = getParent(x)
    val y = getParent(y)
    if(x>=y) parent[x] = y;
    else parent[y] = x;
}