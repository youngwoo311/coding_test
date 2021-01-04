/* N과M
https://www.acmicpc.net/problem/15649
 */

fun main(args: Array<String>){
    var n: List<String> = readLine()!!.split(" ")
    var a:IntArray = IntArray(8)
    var k:Int = n[0].toInt()
    var cnt:Int = n[1].toInt()


    dfs(0, 0, k, cnt, a)


}

fun dfs(i:Int, j:Int, k:Int, cnt:Int, a:IntArray){
    if(i==cnt){
        for(j in 0 until cnt){
            print(a[j] + 1)
            print(" ")
        }
        println()
        return
    }

    var bool:BooleanArray = BooleanArray(8)
    a[i] = j+1
    for(j in 0 until i){
        var check:Int = a[j]
        bool[check] = true
    }

    for(j in 0 until k){
        if(bool[j]) continue
        bool[j] = true
        a[i] = j
        dfs(i+1, j, k, cnt, a)
        bool[j] = false
    }


}