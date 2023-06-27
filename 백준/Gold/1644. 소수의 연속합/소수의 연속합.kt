import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

lateinit var prime : MutableList<Boolean>
lateinit var prime_sum : MutableList<Int>
val MAX = 4000001
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    if(N == 1) {
        bw.write("0")
    }
    else {
        prime = MutableList(MAX){true}
        prime[1] = false
        prime[0] = false
        for(i in 2 until sqrt(MAX.toFloat()).toInt()){
            for(j in (i*2) until MAX step(i)) {
                prime[j] = false
            }
        }
        prime_sum = mutableListOf(0)
        var psum = 0
        for(i in 2 until prime.size) {
            if(prime[i]) {
                psum += i
                prime_sum.add(psum)
            }

        }

        var ans = 0
        var left = 0
        var right = 0
        while (left <= right && right < prime_sum.size){
            if(prime_sum[right] - prime_sum[left] > N){
                left++
            }
            else if(prime_sum[right] - prime_sum[left] < N) {
                right++
            }
            else{
                ans++
                right++
            }
        }
        bw.write(ans.toString())
    }

    bw.flush()
    bw.close()
}
