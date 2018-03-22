package scripts

def catalog = new XmlSlurper().parse("../../resourse/parseXML.xml")
catalog.children().each {println it.toString() }

