import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs


lateinit var board : Array<MutableList<String>>
lateinit var red : marble
lateinit var blue : marble
lateinit var goal : marble

lateinit var visit : Array<Array<Array<MutableList<Boolean>>>>
lateinit var boardSize : List<Int>

var dx = listOf<Int>(0,0,-1,1)
var dy = listOf<Int>(1,-1,0,0)
data class marble(var x : Int, var y : Int, var dist : Int?)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    boardSize = br.readLine().split(" ").map { it.toInt() }

    board = Array(boardSize[0]){ mutableListOf() }
    repeat(boardSize[0])
    {
        i ->
        board[i] = br.readLine().split("") as MutableList<String>
    }

    visit = Array(boardSize[0]){Array(boardSize[1]){Array(boardSize[0]){MutableList(boardSize[1]){false} } } }

    repeat(boardSize[0])
    {
        i ->
        repeat(boardSize[1])
        {
            j ->
            if(board[i][j] == "B") blue = marble(i,j,null)
            else if(board[i][j] == "R") red = marble(i,j,null)
            else if(board[i][j] == "O") goal = marble(i,j,null)
        }
    }

    visit[blue.x][blue.y][red.x][red.y] = true

    bw.write(bfs().toString())
    bw.flush()
    bw.close()
}

fun bfs() : Int
{
    val q : Deque<Triple<marble,marble,Int>> = LinkedList()
    q.add(Triple(blue,red,0))
    while (q.isNotEmpty())
    {
        val pq = q.removeFirst()
        if (pq.third > 10) return -1
        for(i in 0..3)
        {
            var nB = move(dx[i], dy[i], pq.first)
            var nR = move(dx[i], dy[i], pq.second)

            if(nB.x == goal.x && nB.y == goal.y) continue

            if(pq.second.x == goal.x && pq.second.y == goal.y) return pq.third

            if(nB.x == nR.x && nB.y == nR.y)
            {
                if(nR.dist!! > nB.dist!!) {
                    nR.x -= dx[i]
                    nR.y -= dy[i]
                }
                else{
                    nB.x -= dx[i]
                    nB.y -= dy[i]
                }
            }


            if(!visit[nB.x][nB.y][nR.x][nR.y]) {
                visit[nB.x][nB.y][nR.x][nR.y] = true
                q.addLast(Triple(nB, nR, pq.third+1))
            }
        }
    }
    return -1
}

fun move(nx : Int, ny : Int, m : marble) : marble
{
    var x = m.x
    var y = m.y
    var dist = 0
    while(board[x + nx][y + ny] != "#")
    {
        x += nx
        y += ny
        dist += 1
        if(x == goal.x && y == goal.y) break
    }
    return marble(x, y, dist)
}