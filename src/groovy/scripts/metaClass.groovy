package scripts

class MyGroovy {}
def myGroovy = new MyGroovy()
myGroovy.metaClass.myProp = "my new property"
myGroovy.metaClass.test = { -> myProp}

try {
    println myGroovy.test()
}
catch(e) { e.toString() }



