class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var i = 0
        var j = 200000000
        while(i<=j)
        {
            val mid = (i + j) / 2
            if(check(stones,k,mid)){
                j = mid-1
            }
            else i = mid+1
        }
        
        return i
    }
    private fun check(stones: IntArray, k: Int, mid : Int):Boolean{
        var cnt = 0
        for(i in stones.indices){
            if(stones[i] <= mid) cnt++
            else cnt = 0
            if(cnt == k) return true
        }
        return false
    }
}