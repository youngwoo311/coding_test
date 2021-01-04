import java.util.*
import kotlin.collections.ArrayList

/* DFS, BFS
https://www.acmicpc.net/problem/1260
 */
var arr = Array(1001) {Array(1001) {0} }
var n:Int = 0
var m:Int = 0
var v:Int = 0
var q:Queue<Int> = LinkedList<Int>()
var c:IntArray = IntArray(1001)

fun main(args: Array<String>){
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    v = sc.nextInt()
    //var arr:ArrayList<ArrayList<Int>>

    for(i in 0 until m){

        var a = sc.nextInt()
        var b = sc.nextInt()
        arr[a][b] = 1
        arr[b][a] = 1

    }
    c[v]=1
    dfs(v)
    for(i in 0 until n+1){
        c[i]=0
    }
    println()
    bfs(v)

}

fun dfs(k:Int){
    print(k)
    print(" ")

    for(i in 1 until n+1){
        if(c[i]!=1 && arr[k][i]==1){
            c[i]=1
            dfs(i)

        }
    }
}

fun bfs(k:Int){
    q.add(k);
    c[k]=1;
    while(!q.isEmpty()){
        var x:Int = q.first()
        q.poll()
        print(x)
        print(" ")
        for(i in 1 until n+1){
            if(c[i]!=1 && arr[x][i]==1){
                q.add(i)
                c[i]=1
            }
        }
    }
}

