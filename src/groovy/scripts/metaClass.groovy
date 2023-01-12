package scripts

import java.util.function.Consumer
import java.util.function.Supplier

class MyGroovy {}
def myGroovy = new MyGroovy()
myGroovy.metaClass.myProp = "my new property"
myGroovy.metaClass.test = { -> myProp}

try {
    println myGroovy.test()
}
catch(e) { e.toString() }


def supplierExample(Supplier<String> supplier) {
    println supplier.get()
}
def consumerExample(Consumer<Integer> consumer) {
    consumer.accept(12)
}

supplierExample({"xyz"} as Supplier<String>)
consumerExample({a-> print "int is:"+a} as Consumer<Integer>)

def player = new Expando()
player.name = "Alec"
player.greeting = { "Hello, my name is $name" }
println player.greeting()
player.name = "Max"
println player.greeting()

//или с передачей типизированных аргументов в метод:
def user = new Expando(username: 'Adam')
user.printInfo = { String format ->
    println format + username
}
user.printInfo("format:")

