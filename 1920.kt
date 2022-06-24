private fun main()
{
    // 입력 받기
    var N:Int = readLine()!!.toInt()
    var A = readLine()!!.split(' ').map { it.toInt()}
    var sortedA = A.sorted()

    var M:Int = readLine()!!.toInt()
    var B = readLine()!!.split(' ').map {it.toInt()}

    for (i in B)
    {
        var status = false
        var leftNum = 0
        var rightNum = N-1
        var midNum = N-1
        while (rightNum >= leftNum)
        {
            midNum = (leftNum + rightNum) / 2

            if (sortedA[midNum] == i)
            {
                status = true
                break
            }
            else if(sortedA[midNum] > i)
            {
                rightNum = midNum - 1
            }
            else if(sortedA[midNum] < i){
                leftNum = midNum + 1
            }
        }
        if (status) println(1) else println(0)
    }
}