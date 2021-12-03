import kotlinx.coroutines.*

fun main(args: Array<String>) {
    runBlocking{
        println("   'before start': I'm working in thread ${Thread.currentThread().name}")
        launch {
            println("   'before fetchFlight': I'm working in thread ${Thread.currentThread().name}")
            fetchFlight()
            println("   'after fetchFlight': I'm working in thread ${Thread.currentThread().name}")
        }
        println("   'before finish': I'm working in thread ${Thread.currentThread().name}")
    }
}

suspend fun fetchFlight() = withContext(Dispatchers.IO) {
    println("   'before delay': I'm working in thread ${Thread.currentThread().name}")
    delay(2000)
    println("   'after delay': I'm working in thread ${Thread.currentThread().name}")
}


//fun main(args: Array<String>) {
//    runBlocking{
//        println("Start")
//        launch {
//            println("before fetchFlight")
//            fetchFlight()
//            println("after fetchFlight")
//        }
//        println("Finish")
//    }
//}
//
//suspend fun fetchFlight() = coroutineScope {
//
//    val flight = async {
//        println("inside async before delay")
//        delay(2000)
//        println("inside async after delay")
//    }
//
//    delay(5000)
//    println("before flight.await")
//    flight.await()
//    println("after flight.await")
//}
