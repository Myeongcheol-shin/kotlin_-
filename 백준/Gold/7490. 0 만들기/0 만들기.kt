import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var N = 0
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main()
{
    repeat(br.readLine().toInt())
    {
        N = br.readLine().toInt()
        zero(2,"1","1")
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}
fun strCal(s : String) : Boolean
{
    var tmp = ""
    val sList = mutableListOf<String>()
    for(i in s)
    {
        if(i == '-' || i == '+') {
            sList.add(tmp)
            sList.add(i.toString())
            tmp = ""
        }
        else{
            tmp += i.toString()
        }
    }
    if(tmp != "") sList.add(tmp)
    var sum = sList[0].toInt()
    for (i in 1 until sList.size step 2)
    {
        if(sList[i] == "-")
        {
            sum -= sList[i+1].toInt()
        }
        else if(sList[i] == "+")
        {
            sum += sList[i+1].toInt()
        }
    }
    if(sum == 0) return true
    return false
}
fun zero(n : Int, s : String, rs : String)
{
    if(n == N+1){
        if(strCal(s)) bw.write(rs+"\n")
    }
    else
    {
        zero(n+1,s+n.toString(),rs+" "+n.toString())
        zero(n+1,s+"+"+n.toString(),rs+"+"+n.toString())
        zero(n+1,s+"-"+n.toString(),rs+"-"+n.toString())
    }
}