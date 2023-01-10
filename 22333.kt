package BJ_22333

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashSet
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var tmp = br.readLine().split(" ").map {it.toInt()}
    var N = tmp[0]
    var M = tmp[1]

    var keywordHashSet = HashSet<String>()
    repeat(N)
    {
        i ->
        keywordHashSet.add(br.readLine())
    }
    repeat(M)
    {
        i ->
        var tmp = br.readLine().split(",")
        for (keyword in tmp)
        {
            keywordHashSet.remove(keyword)
        }
        bw.write(keywordHashSet.size.toString() + "\n")
    }
    bw.flush()
    bw.close()
}