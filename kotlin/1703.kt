//異なる値を返すメソッド
fun inputDifferent(a :Int):Int{
    var ans:Int
    if(a == 0){
        ans = 1
        return()
    }
    if(a == 1){
        return(0)
    }
}
fun main(args: Array<String>){
    val T = readLine()!!.toInt()
    val (N,M) = readLine()!!.split(" ").map(String::toInt)
    var A = mutableListOf<Int>()
    var B = mutableListOf<Int>()
    repeat(N){
        A.add(2)
    }
    println(A)
    repeat(M){
        var (kinds, i, j) = readLine()!!.split(" ")
        var s =i.toInt()
        var t =j.toInt()
        //Dを受け取ったとき
        if(kinds == "D"){
            if(countD == 0){
                A[s] = 0
                A[t] = 1
                countD = 1
            }
            else{
                for(i in A.indices){
                    if(A[i] == A[s]){
                        A[s]=inputDifferent(A[i])
                    }
                    else if(A[i] == A[t]){
                        A[t]=inputDifferent(A[i])
                    }
                    else{
                        B.add(A[s])
                        B.add(A[t])
                    }
                }
            }
        }
        //Aを受け取ったとき
        else{
            if(A[s] == 2 || A[t] == 2){
                println("Not sure yet.")
            }
            else if(A[s] == A[t]){
                println("In the same gangs.")
            }
            else{
                println("In different gangs.")
            }
        }
    }
}
