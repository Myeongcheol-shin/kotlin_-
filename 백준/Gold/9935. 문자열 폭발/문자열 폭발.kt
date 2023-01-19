import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Stack

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var s = br.readLine().toString()
    var e = br.readLine().toString()

    var boombsize = e.length
    var stack = Stack<Char>()
    for(i in s.indices)
    {
        stack.push(s[i])
        if(stack.size >= boombsize){
            var flag = false
            for(j in e.indices)
            {
                if(stack[stack.size - boombsize + j] != e[j])
                {
                    flag = true
                    break
                }
            }
            if(!flag){
                repeat(boombsize){stack.pop()}
            }
        }
    }
    if(stack.isEmpty()) bw.write("FRULA")
    else {
        bw.write(stack.toCharArray())
    }
    bw.flush()
    bw.close()
}
