import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var ttt : ArrayList<ArrayList<CharArray>>
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    ttt = arrayListOf()
    var idx = 0
    while(true)
    {
        val tmp = br.readLine().toString()
        if(tmp == "end") break
        ttt.add(arrayListOf())
        for(i in 0 until 3)
        {
            ttt[idx].add(tmp.substring(i*3,3+i*3).toCharArray())
        }
        idx++
    }
    for(t in ttt)
    {
        if(tictacto(t))bw.write("valid\n")
        else bw.write("invalid\n")
    }
    bw.flush()
    bw.close()
}
fun tictacto(c : ArrayList<CharArray>) : Boolean
{
    val ct = count(c)
    val ofind = check('O',c)
    val xfind = check('X',c)
    if(ct.first + ct.second == 9 && ct.first - 1 == ct.second)
    {
        if(!ofind && !xfind) return true
        if(ofind) return false
        if(xfind) return true
        return false;
    }
    else if(ct.first + ct.second != 9)
    {
        if(ct.first - 1 == ct.second)
        {
            if(ofind) return false
            if(xfind) return true
            return false;
        }
        else if(ct.first == ct.second)
        {
            if(xfind) return false
            if(ofind) return true
            return false;
        }
    }
    return false
}
fun check(c : Char, t : ArrayList<CharArray>) : Boolean
{
    for(i in 0 until 3) {
        if (t[i][0] == c && t[i][1] == c && t[i][2] == c) return true
        if (t[0][i] == c && t[1][i] == c && t[2][i] == c) return true
    }
    if(t[0][0] == c && t[1][1] == c && t[2][2] == c) return true
    if(t[2][0] == c && t[1][1] == c && t[0][2] == c) return true
    return false
}
fun count(t : ArrayList<CharArray>) : Pair<Int,Int>
{
    var x = 0
    var o = 0
    for(i in 0 until 3)
    {
        for(j in 0 until 3)
        {
            if(t[i][j] == 'X') x++
            else if(t[i][j] == 'O') o++
        }
    }
    return Pair(x,o)
}