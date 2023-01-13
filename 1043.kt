package BJ_1043

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var truth : MutableSet<Int>
lateinit var party : ArrayList<ArrayList<Int>>
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var tmp = br.readLine().split(" ").map{it.toInt()}
    var M = tmp[1]

    truth = mutableSetOf()
    party = arrayListOf()
    tmp = br.readLine().split(" ").map{it.toInt()}
    repeat(tmp[0])
    {
        i ->
        truth.add(tmp[i+1])
    }
    repeat(M)
    {
        i ->
        tmp = br.readLine().split(" ").map{it.toInt()}
        tmp = tmp.drop(1)
        party.add(ArrayList(tmp))
    }
    while(true)
    {
        val start = party.size
        val tmp = arrayListOf<ArrayList<Int>>()
        for(i in party)
        {
            if(i.intersect(truth).isNotEmpty()) tmp.add(i)
        }
        for(i in tmp) {
            party.remove(i)
            truth.addAll(i)
        }
        if(start == party.size) break
    }
    bw.write(party.size.toString())
    bw.flush()
    bw.close()
}