/*
https://www.acmicpc.net/problem/11404
 */

import java.lang.Integer.min
import java.util.*

val inf = 987654321
var dist = Array(101){Array(101) {inf}}

fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    var n: Int = sc.nextInt()
    var m: Int = sc.nextInt()

    for(i in 1 until n+1){
        dist[i][i] = 0
    }

    for(i in 0 until m){
        var a: Int = sc.nextInt()
        var b: Int = sc.nextInt()
        var c: Int = sc.nextInt()

        dist[a][b] = min(dist[a][b], c)
    }

    for(k in 1 until n+1){
        for(i in 1 until n+1){
            for(j in 1 until n+1){
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    for(i in 1 until n+1) {
        for(j in 1 until n+1) {
            if(dist[i][j] == inf) {
                print(0)
                print(" ")
            }
            else {
                print(dist[i][j])
                print(" ")
            }
        }
        println()
    }
}

