package BJ_1167

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

lateinit var tree : ArrayList<ArrayList<Pair<Int,Int>>>
lateinit var visit : BooleanArray
var ans = 0
var V = 0
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    tree = arrayListOf()
    V = br.readLine().toInt()
    repeat(V){tree.add(arrayListOf())}
    repeat(V)
    {
        val tmp = br.readLine().split(" ").map{it.toInt()}
        val idx = tmp[0]-1
        for (j in 0 until (tmp.size/2-1))
        {
            tree[idx].add(Pair(tmp[j*2+1],tmp[j*2+2]))
        }
    }
    visit = BooleanArray(V){false}
    visit[0] = true
    dfs(0)
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun dfs(idx : Int) : Int
{
    if(idx == V) return 0

    if(tree[idx].size == 1)
    {
        if(visit[tree[idx][0].first - 1]) return 0
        visit[tree[idx][0].first-1] = true
        val tmp = tree[idx][0].second + dfs(tree[idx][0].first-1)
        ans = max(ans, tmp)
        return tmp
    }
    var pq = ArrayList<Int>()
    repeat(tree[idx].size)
    {
        i ->
        if(!visit[tree[idx][i].first - 1])
        {
            visit[tree[idx][i].first-1] = true
            pq.add(tree[idx][i].second + dfs(tree[idx][i].first-1))
        }
    }
    if(pq.size==0) return 0
    if(pq.size==1) {
        ans = max(pq[0],ans)
        return pq[0]
    }
    pq.sortDescending()
    ans = max(pq[0] + pq[1], ans)
    return pq[0]
}