import java.util.*
import kotlin.math.max

/*
https://www.acmicpc.net/problem/12865
 */

var dp = Array(101) {Array(100001) {0} }
var W = IntArray(101)
var V = IntArray(101)

fun main(args:Array<String>){
    val sc = Scanner(System.`in`)
    var n:Int = sc.nextInt()
    var k:Int = sc.nextInt()

    for(i in 1 until n+1){
        W[i] = sc.nextInt()
        V[i] = sc.nextInt()
    }

    for(i in 1 until n+1){
        for(j in 1 until k+1){
            dp[i][j] = dp[i-1][j]
            if(j-W[i]<0) continue
            dp[i][j] = max(dp[i][j], dp[i-1][j-W[i]] + V[i])
        }
    }

    println(dp[n][k]);
}