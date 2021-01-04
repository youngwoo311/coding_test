/*
https://www.acmicpc.net/problem/1149
 */

import java.util.*


fun main(args:Array<String>){
    val sc = Scanner(System.`in`)
    var n:Int = sc.nextInt()

    var R = IntArray(n)
    var G = IntArray(n)
    var B = IntArray(n)

    for(i in 0 until n){
        R[i] = sc.nextInt()
        G[i] = sc.nextInt()
        B[i] = sc.nextInt()
    }
    for(i in 1 until n ){
        if(G[i-1]<=B[i-1]) R[i] += G[i-1]
        else if (G[i-1]>B[i-1]) R[i] += B[i-1]

        if(R[i-1]<=B[i-1]) G[i] += R[i-1]
        else if(R[i-1]>B[i-1]) G[i] += B[i-1]

        if(R[i-1]<=G[i-1]) B[i] += R[i-1]
        else if(R[i-1]>G[i-1]) B[i] += G[i-1]

    }

    var k = R[n-1]
    if(k >= G[n-1]) k = G[n-1]
    if(k >= B[n-1]) k = B[n-1]

    println(k)

}