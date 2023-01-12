package scripts

@Grapes([
        @Grab(group='io.vertx', module='vertx-lang-groovy', version='4.1.0.Beta1'),
        @Grab(group='io.vertx', module='vertx-core', version='4.1.0.Beta1'),
        @Grab(group='io.vertx', module='vertx-web-client', version='4.1.0.Beta1')
        //@GrabExclude("org.codehaus.groovy:groovy-swing") //исключить эту зависимость
])

import io.vertx.ext.web.client.WebClient
import io.vertx.core.Vertx

def vertx = Vertx.vertx()
def httpClient = WebClient.create(vertx)
def alarm = new Timer()
alarm.runAfter(1000) {
    httpClient.get(80, 'google.com', '/').send { resp ->
        if (resp.succeeded()) {
            def httpVersion = resp.result().version()
            println "HTTP version: ${httpVersion}"
            if(resp.result().statusCode() == 200){
                println "OK:"+resp.result().statusCode()
            }else{
                println "Something went wrong " + resp.result().statusCode()
            }
        } else {
            println "error!!!"
        }
    }
}
sleep(4000)

def data = 'http://httpbin.org/headers'.toURL().text
println(data)

System.exit(0)