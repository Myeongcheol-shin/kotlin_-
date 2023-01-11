package BJ_2493

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = br.readLine().toInt()
    var top = br.readLine().split(" ").map {it.toInt()}

    var st = Stack<Pair<Int, Int>>()
    var ans = IntArray(N,{0})
    for(i in N-1 downTo 1)
    {
        if(top[i] > top[i-1]){
            st.add(Pair(i,top[i]))
        }
        else{
            ans[i] = i
            while(st.isNotEmpty())
            {
                val pd = st.peek()
                if(pd.second < top[i-1]){
                    st.pop()
                    ans[pd.first] = i
                }
                else break
            }
        }
    }
    bw.write(ans.joinToString(" "))
    bw.flush()
    bw.close()
}