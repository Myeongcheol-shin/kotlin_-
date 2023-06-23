import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

var N = 0
var ans = 0
lateinit var baseball : Array<MutableList<Int>>
val lineUp = MutableList<Int>(9){-1}
val visit = MutableList<Boolean>(9){false}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    N = br.readLine().toInt()
    baseball = Array(N){ mutableListOf() }

    repeat(N)
    {
        i ->
        baseball[i] = br.readLine().split(" ").map { it.toInt()} as MutableList<Int>
    }

    lineUp[3] = 0
    visit[3] = true
    dfs(1)
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun dfs(cnt : Int)
{
    if(cnt == 9)
    {
        cal()
        return
    }
    for(i in 0 until lineUp.size)
    {
        if(visit[i]) continue
        visit[i] = true
        lineUp[i] = cnt
        dfs(cnt + 1)
        visit[i] = false
    }
}

fun cal()
{
    var tmp = 0
    var status = false
    var score = 0

    repeat(N)
    {
        i ->
        var out = 0
        status = false

        var base1 = 0
        var base2 = 0
        var base3 = 0

        while(!status)
        {
            while (tmp < lineUp.size){
                val player = baseball[i][lineUp[tmp]]
                when(player)
                {
                    0 -> {
                        out++
                    }
                    1 -> {
                        score += base3
                        base3 = base2
                        base2 = base1
                        base1 = 1
                    }
                    2 -> {
                        score += (base3 + base2)
                        base3 = base1
                        base2 = 1
                        base1 = 0
                    }
                    3 -> {
                        score += (base3 + base2 + base1)
                        base1 = 0
                        base2 = 0
                        base3 = 1
                    }
                    4 -> {
                        score += (base3 + base2 + base1 + 1)
                        base1 = 0
                        base2 = 0
                        base3 = 0
                    }
                }
                tmp++
                tmp %= 9
                if(out == 3) {
                    out = 0
                    status = true
                    break
                }
            }
        }
        ans = max(ans , score)
    }
}
