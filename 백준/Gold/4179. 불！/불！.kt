import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter



lateinit var arr : ArrayList<CharArray>
lateinit var fireList : ArrayList<Pair<Int, Int>>
lateinit var visit : ArrayList<BooleanArray>
var R = 0
var C = 0
var ans = 1
lateinit var start : ArrayList<Pair<Int,Int>>
var dx = listOf(0,0,1,-1)
var dy = listOf(1,-1,0,0)
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val tmp = br.readLine().split(" ").map { it.toInt() }
    R = tmp[0]
    C = tmp[1]
    arr = arrayListOf()
    visit = arrayListOf()
    fireList = arrayListOf()
    repeat(R)
    {
        visit.add(BooleanArray(C){false})
        arr.add(br.readLine().toCharArray())
    }
    start = arrayListOf()
    for(i in 0 until R)
    {
        for(j in 0 until C)
        {
            if(arr[i][j] == 'F') fireList.add(Pair(i,j))
            else if(arr[i][j] == 'J') {
                start.add(Pair(i,j))
                visit[i][j] = true
            }
        }
    }
    val x = start[0].first
    val y = start[0].second
    if(((x == 0 || x == R-1) && y in 0 until C) || (x in 0 until R &&(y == 0 || y == C-1))) bw.write("1")
    else{
        if(bfs(start, fireList)) bw.write(ans.toString())
        else bw.write("IMPOSSIBLE")
    }
    bw.flush()
    bw.close()
}

fun bfs(start : ArrayList<Pair<Int, Int>>, fireList: ArrayList<Pair<Int,Int>>) : Boolean
{
    var nextMove = arrayListOf<Pair<Int,Int>>()
    var nextFire = arrayListOf<Pair<Int,Int>>()
    ans++
    fireList.forEach()
    {
        it ->
        repeat(4)
        {
            i ->
            val nx = it.first + dx[i]
            val ny = it.second + dy[i]
            if(nx in 0 until R && ny in 0 until C && arr[nx][ny] != '#' && arr[nx][ny] != 'F')
            {
                arr[nx][ny] = 'F'
                nextFire.add(Pair(nx,ny))
            }
        }
    }
    start.forEach()
    {
        it ->
        repeat(4)
        {
            i ->
            val nx = it.first + dx[i]
            val ny = it.second + dy[i]
            if(((nx == 0 || nx == R-1) && ny in 0 until C) || (nx in 0 until R &&(ny == 0 || ny == C-1))){
                if(arr[nx][ny] == '.') return true
            }
            if(nx in 0 until R && ny in 0 until C && arr[nx][ny] == '.' && !visit[nx][ny])
            {
                visit[nx][ny] = true
                nextMove.add(Pair(nx,ny))
            }
        }
    }
    if(nextMove.size == 0) return false
    return bfs(nextMove, nextFire)
}