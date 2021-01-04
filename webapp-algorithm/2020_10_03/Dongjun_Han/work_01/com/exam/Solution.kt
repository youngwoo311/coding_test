/* 백준 분해합
https://www.acmicpc.net/problem/2231
*/

fun main(args: Array<String>){

    var n:Int = readLine()!!.toInt()
    var check:Boolean = false
    var ans:Int = 0;
    for(x in 1 until n) {
        check = false
        var k:Int = x
        var sum:Int = 0
        sum += k

        while(k>0){
            var p:Int = k%10
            sum+=p
            k/=10
        }
        if(sum==n) {
            ans = x
            check = true
            break
        }
    }
    if(check) println(ans)
    else println(0)


}