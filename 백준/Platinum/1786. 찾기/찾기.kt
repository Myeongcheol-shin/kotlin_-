import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var T = br.readLine()
    var P = br.readLine()
    var lenT = T.length
    var lenP = P.length

    var fail = IntArray(lenP){0}
    var ans = arrayListOf<Int>()
    var i = 0
    for(j in 1 until lenP)
    {
        while(i > 0 && P[i] != P[j]) i = fail[i-1]
        if(P[i] == P[j])
        {
            i++
            fail[j] = i
        }
    }
    i = 0
    for(j in T.indices)
    {
        while (i > 0 && P[i] != T[j]) i = fail[i-1]
        if(P[i] == T[j])
        {
            i++
            if(i == lenP)
            {
                ans.add(j-i+2)
                i = fail[i-1]
            }
        }
    }
    bw.write(ans.size.toString() + "\n")
    for(i in ans)
    {
        bw.write("$i ")
    }
    bw.flush()
    bw.close()
}