package BJ_16234

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

lateinit var open : ArrayList<IntArray>
lateinit var arr : ArrayList<IntArray>
lateinit var sumPeople : ArrayList<Int>
lateinit var logPeople : ArrayList<Pair<Int, Int>>
var dx = listOf(0,0,1,-1)
var dy = listOf(1,-1,0,0)
var L = 0
var R = 0
var N = 0
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var read = br.readLine().split(" ").map { it.toInt() }

    N = read[0]
    L = read[1]
    R = read[2]

    arr = arrayListOf()
    repeat(N)
    {
        i ->
        val tmp = IntArray(N,{0})
        read = br.readLine().split(" ").map { it.toInt() }
        for(j in 0 until N)
        {
            tmp[j] = read[j]
        }
        arr.add(tmp)
    }
    var ans = 0
    var find = true
    while(find)
    {
        open = ArrayList()
        repeat(N){open.add(IntArray(N,{0}))}
        var count = 0
        sumPeople = arrayListOf()
        find = false
        for(i in 0 until N)
        {
            for(j in 0 until N)
            {
                logPeople = arrayListOf()
                if(open[i][j] == 0){
                    sumPeople.add(0)
                    val people = movePeople(i,j,count+1)
                    if(people > 0){
                        count++
                        find = true
                        val npeople = (sumPeople[count - 1] + arr[i][j]) / (people + 1)
                        arr[i][j] = npeople
                        for(d in logPeople) arr[d.first][d.second] = npeople
                    }
                }
            }
        }
        if(find) ans++
    }
    println(ans)
}
fun movePeople(x : Int, y : Int, count : Int) : Int
{
    val Q = LinkedList<Pair<Int, Int>>()
    var status = 0
    Q.add(Pair(x,y))
    open[x][y] = count
    while (Q.isNotEmpty())
    {
        var pq = Q.poll()
        repeat(4)
        {
            i ->
            val nx = dx[i] + pq.first
            val ny = dy[i] + pq.second
            if(nx in 0 until N && ny in 0 until N && open[nx][ny] == 0)
            {
                if(Math.abs(arr[pq.first][pq.second] - arr[nx][ny]) in L .. R){
                    open[nx][ny] = count
                    sumPeople[count-1] += arr[nx][ny]
                    status++
                    logPeople.add(Pair(nx,ny))
                    Q.add(Pair(nx,ny))
                }
            }
        }
    }
    return status
}
