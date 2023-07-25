import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

lateinit var dp : MutableList<Int>
lateinit var seq : MutableList<Int>
lateinit var lis : MutableList<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    seq = mutableListOf<Int>(0)
    seq.addAll(br.readLine().split(" ").map { it.toInt() })
    dp = MutableList(N+1){0}
    lis = mutableListOf()

    if(N==1){
        bw.write("1\n${seq[1]}")
        bw.flush()
        bw.close()
        return
    }

    lis.add(seq[1])

    for(i in 2..N){
        if(seq[i] > lis.get(lis.size-1)){
            lis.add(seq[i])
            dp[i] = lis.size - 1
        }
        else {
            binarySearch(i)
        }
    }
    bw.write("${lis.size}\n")
    var s = Stack<Int>()
    var tmp = lis.size - 1
    for(i in N downTo 1){
        if(tmp < 0) break
        if(dp[i] == tmp){
            tmp--
            s.push(seq[i])
        }
    }
    while (s.isNotEmpty()){
        bw.write(s.pop().toString() + " ")
    }
    bw.flush()
    bw.close()
}


fun binarySearch(idx : Int) {
    var start = 0
    var end = lis.size - 1
    while (start < end){
        val mid = (start + end) / 2
        if(lis.get(mid) >= seq[idx]){
            end = mid
        }
        else {
            start = mid+1;
        }
    }
    lis.set(start, seq[idx])
    dp[idx] = start
}
