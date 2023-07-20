import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var visited : MutableList<Boolean>
lateinit var students : MutableList<Int>
lateinit var matching : MutableList<Boolean>
var ans = 0;
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()

    repeat(N)
    {
        val size = br.readLine().toInt()
        ans = size
        visited = MutableList(size+1){false}
        matching = MutableList(size+1){false}
        students = mutableListOf<Int>(0)
        students.addAll(br.readLine().split(" ").map { it.toInt() })

        for(i in 1 .. size) {
            if(!visited[i]) dfs(i)
        }
        bw.write(ans.toString() +"\n")
    }
    bw.flush()
    bw.close()
}

fun dfs(x: Int)
{
    visited[x] = true
    var nextStudents = students[x]
    if(!visited[nextStudents]) {
        dfs(nextStudents)
    }
    else{
        if(!matching[nextStudents]) {
            ans--
            while (x != nextStudents) {
                nextStudents = students[nextStudents]
                ans--
            }
        }
    }
    matching[x] = true
}