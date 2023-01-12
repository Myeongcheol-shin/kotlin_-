package BJ_2467

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

lateinit var br : BufferedReader
lateinit var bw : BufferedWriter
fun main()
{

    br = BufferedReader(InputStreamReader(System.`in`))
    bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var arr = arrayListOf<Long>()
    var N = br.readLine().toInt()
    for(value in br.readLine().split(" ").map{it.toLong()})
    {
        arr.add(value)
    }
    var left = 0
    var right = N-1
    var ansL = arr[left]
    var ansR = arr[right]

    while (left < right)
    {
        val tmp = arr[left] + arr[right]
        if(abs(tmp) < abs(ansL + ansR)){
            ansL = arr[left]
            ansR = arr[right]
        }
        if(tmp < 0) left++
        else right--
    }
    bw.write(ansL.toString() + " " + ansR.toString())
    bw.flush()
    bw.close()
}