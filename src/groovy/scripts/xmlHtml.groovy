package scripts

//def result = '../../resourse/parseXML.xml'.toURL().text
//def catalog = new XmlSlurper().parseText(result)
def catalog = new XmlSlurper().parse("../../resourse/parseXML.xml")
catalog.children().each { println it.toString() }

import groovy.xml.MarkupBuilder

writer = new StringWriter()
builder = new MarkupBuilder(writer)
petsList = [ "Hector", "Felix"]
builder.person() {
    username("Guillaume")
    age("33")
    gender("female")
    pets(){
        for (e in petsList){pet(e)}
    }

}
println writer.toString()

import groovy.xml.MarkupBuilder
def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.html() {
    head() {
        title("This is the title")
    }

    body() {
        div("class" : "main") {
            p("this is the body")
        }
    }
}

println writer.toString()