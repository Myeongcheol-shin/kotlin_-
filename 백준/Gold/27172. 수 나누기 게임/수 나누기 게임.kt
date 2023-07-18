import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private const val MAX_VALUE = 1000001
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    val has = MutableList(MAX_VALUE){-1}
    val card = br.readLine().split(" ").map { it.toInt() } as MutableList
    val score = MutableList(N){0}
    card.forEachIndexed { idx, value ->
        has[value] = idx
    }

    repeat(N) {i ->
        // 에라토스테네스의 체
        for(j in card[i] * 2 until MAX_VALUE step(card[i])){
            // 가지고 있다면
            if(has[j] != -1) {
                if(j % card[i] == 0) {
                    score[i]++
                    score[has[j]]--
                }
            }
        }
    }
    val ans = score.joinToString(" ")
    bw.write(ans)
    bw.flush()
    bw.close()

}
