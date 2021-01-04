/* 설탕배달
https://www.acmicpc.net/problem/2839
 */

import java.lang.Math.min

fun main(args: Array<String>){

    var dp: IntArray = IntArray(5001)

    var n:Int = readLine()!!.toInt()
    dp[1] = 1002
    dp[2] = 1002
    dp[4] = 1002
    dp[3] = 1
    dp[5] = 1

    for(i in 6 until 5001){
        dp[i] = min(dp[i-3]+1, dp[i-5]+1);

    }
    if(dp[n]>1001) println(-1)
    else println(dp[n])
}