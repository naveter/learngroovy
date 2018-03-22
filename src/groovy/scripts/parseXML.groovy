package scripts

//def result = '../../resourse/parseXML.xml'.toURL().text
//def catalog = new XmlSlurper().parseText(result)
def catalog = new XmlSlurper().parse("../../resourse/parseXML.xml")
catalog.children().each { println it.toString() }

