package scripts

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

// Создание JSON объекта
def json = new JsonBuilder()
json.person {
    username "Guillaume"
    age 33
    pets "Hector", "Felix"
}

println json.toString() // вывод в строку полученного объекта

// Парсинг строки в JSON формате
def someJSONString = '{"person":{"username":"Guillaume","age":33,"pets":["Hector","Felix"]}}'
println JsonOutput.prettyPrint(someJSONString) // форматированный вывод объекта

def slurper = new JsonSlurper()
def doc = slurper.parseText(someJSONString)

println doc.person.username // вывод имени
doc.person.pets.each {println it} // вывод животных
