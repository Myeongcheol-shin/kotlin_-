package BJ_12919

fun main()
{
    var S = readLine()!!
    var T = readLine()!!
    if(check(S,T)) println(1)
    else println(0)
}
fun check(s: String, t:String) : Boolean
{
    if(s==t) return true
    if(s.length >= t.length) return false
    if(t.first() == 'B')if(check(s,t.drop(1).reversed())) return true
    if(t.last() == 'A')if(check(s,t.dropLast(1))) return true
    return false
}