import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

lateinit var board : MutableList<MutableList<Int>>
var N = 0
var ans = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    N = br.readLine().toInt()

    board = MutableList(N){ mutableListOf() }
    repeat(N)
    {
        board[it] = br.readLine().split(" ").map { it.toInt() } as MutableList<Int>
    }

    solve(0)

    bw.write(ans.toString())
    bw.flush()
    bw.close()
}
fun solve(cnt : Int)
{
    if(cnt == 5) {
        for(i in 0 until N) {
            for(j in 0 until N){
                ans = max(ans, board[i][j])
            }
        }
        return
    }

    for(i in 1 .. 4)
    {
        val copyBoard = MutableList(N){MutableList(N){0}}
        for(i in 0 until N){
            for(j in 0 until N) {
                copyBoard[i][j] = board[i][j]
            }
        }

        move(i)
        solve(cnt + 1)
        board = copyBoard
    }
}
fun printboard(){
    for (i in 0 until N)
    {
        println(board[i])
    }
    println()
}

fun move(action : Int)
{
    when(action)
    {
        // 왼쪽
        1 ->  {
            for(i in 0 until N) {
                var q = mutableListOf<Int>()
                var tmp = -1
                for (j in 0 until N) {
                    if (board[i][j] != 0) {
                        if(tmp == -1) {
                            tmp = board[i][j]
                        }
                        else{
                            if(tmp == board[i][j]) {
                                tmp *= 2
                                q.add(tmp)
                                tmp = 0
                            }
                            else {
                                if(tmp != 0) q.add(tmp)
                                tmp = board[i][j]
                            }
                        }
                    }
                }
                if(tmp != -1) q.add(tmp)
                while(q.size < N) q.add(0)
                board[i] = q
            }
        }
        // 오른쪽
        2 -> {
            for(i in 0 until N) {
                var q = ArrayDeque<Int>()
                var tmp = -1
                for(j in N-1 downTo 0)
                {
                    if (board[i][j] != 0) {
                        if(tmp == -1) {
                            tmp = board[i][j]
                        }
                        else{
                            if(tmp == board[i][j]) {
                                tmp *= 2
                                q.addFirst(tmp)
                                tmp = 0
                            }
                            else {
                                if(tmp != 0) q.addFirst(tmp)
                                tmp = board[i][j]
                            }
                        }
                    }
                }
                if(tmp != -1) q.addFirst(tmp)
                while(q.size < N) q.addFirst(0)
                board[i] = q as MutableList<Int>
            }
        }
        // 위쪽
        3 -> {
            for(i in 0 until N)
            {
                var q = mutableListOf<Int>()
                var tmp = -1
                for(j in 0 until N)
                {
                    if(board[j][i] != 0)
                    {
                        if(tmp == -1) tmp = board[j][i]
                        else {
                            if(tmp == board[j][i]) {
                                tmp *= 2
                                q.add(tmp)
                                tmp = 0
                            }
                            else {
                                if(tmp != 0) q.add(tmp)
                                tmp = board[j][i]
                            }
                        }
                    }
                }
                if(tmp != -1) q.add(tmp)
                while (q.size < N) q.add(0)
                for(j in 0 until N)
                {
                    board[j][i] = q[j]
                }
            }
        }
        // 아래쪽
        4 ->{
            for(i in 0 until N)
            {
                var q = ArrayDeque<Int>()
                var tmp = -1
                for(j in N-1 downTo 0)
                {
                    if(board[j][i] != 0)
                    {
                        if(tmp == -1) tmp = board[j][i]
                        else {
                            if(tmp == board[j][i]) {
                                tmp *= 2
                                q.addFirst(tmp)
                                tmp = 0
                            }
                            else {
                                if(tmp != 0) q.addFirst(tmp)
                                tmp = board[j][i]
                            }
                        }
                    }
                }
                if(tmp != -1) q.addFirst(tmp)
                while (q.size < N) q.addFirst(0)
                for(j in 0 until N)
                {
                    board[j][i] = q[j]
                }
            }
        }
    }
}