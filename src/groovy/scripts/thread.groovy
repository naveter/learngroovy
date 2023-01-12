package scripts

Thread.start {
    println Thread.currentThread().getId()
}

@Grab(group='org.codehaus.gpars', module='gpars', version='1.2.1')
import static groovyx.gpars.GParsExecutorsPool.withPool

//С помощью GPars 5 раз сделать асинхронную загрузку страницы(и распечатать ответ)
//по url в отдельных потоках
int count = 5
withPool(count) {
    count.times {
        Closure callUrl = {"http://httpbin.org/headers".toURL().withReader {
            reader -> println reader.readLines()
        }}
        callUrl.callAsync()
    }
}
