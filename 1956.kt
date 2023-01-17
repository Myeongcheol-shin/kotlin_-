package BJ_1956

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

var V = 0
var E = 0
lateinit var arr : ArrayList<IntArray>
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ").map{it.toInt()}
    V = tmp[0]
    E = tmp[1]

    arr = arrayListOf()
    repeat(V){
        i ->
        arr.add(IntArray(V){Int.MAX_VALUE})
        arr[i][i] = 0
    }
    repeat(E)
    {
        val tmp = br.readLine().split(" ").map{it.toInt()}
        arr[tmp[0]-1][tmp[1]-1] = tmp[2]
    }

    for(k in 0 until V)
    {
        for(i in 0 until  V)
        {
            for(j in 0 until V)
            {
                if(arr[i][k] == Int.MAX_VALUE || arr[k][j] == Int.MAX_VALUE ) continue
                if(arr[i][k] + arr[k][j] < arr[i][j]) arr[i][j] = arr[i][k] + arr[k][j]
            }
        }
    }
    var ans = Int.MAX_VALUE
    for(i in 0 until V-1)
    {
        for(j in i+1 until V)
        {
            if(arr[i][j] == Int.MAX_VALUE || arr[j][i] == Int.MAX_VALUE) continue
            ans = min(ans, arr[i][j] + arr[j][i])
        }
    }
    if(ans == Int.MAX_VALUE) bw.write("-1")
    else bw.write(ans.toString())
    bw.flush()
    bw.close()
}
