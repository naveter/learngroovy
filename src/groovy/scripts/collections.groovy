package scripts

def modulesMap = [:];
def orgArray = ["com", "net", "apache"]
def nameArr = ["commons", "junit", "google", "tools"]

modulesMap[orgArray[0]] = [:]
modulesMap[orgArray[0]][nameArr[0]] = [1.2, 1.3]
modulesMap[orgArray[0]][nameArr[1]] = [1.5]

if (modulesMap[orgArray[1]] == null) {
    modulesMap.put(orgArray[1], [:])
}

def com = modulesMap.get(orgArray[2])
if (com == null) println "1.com is null"
modulesMap[orgArray[2]] = [(nameArr[3]):[]]

if (modulesMap[orgArray[2]][nameArr[3]].size() == 0) {
    modulesMap[orgArray[2]][nameArr[3]].add("2.3")

    if (modulesMap[orgArray[2]][nameArr[3]].size() > 0
            && modulesMap[orgArray[2]][nameArr[3]].contains("2.3")) {
        modulesMap[orgArray[2]][nameArr[3]].add("2.4")
    }
}

println modulesMap

// множественное присвоение
def (a, b, c) = [1,2,5]
print c + ' '

def (int myint, String mystring) = [5, "hello"]
print mystring + ' '

//диапазоны значений
def list = [3, 'Some string' , new Date()]

print list[0] + ' '
print list[1] + ' '

def letters = 'a'..'z'
def numbers = 0..<10

print numbers.size()
println ''

// работа с замыканиями
3.times { print 'Hi '}
[1,2,3].each {it -> print it + ' '}
(10..1).each {print it + ' '}
[ 'a' : 1, 'b' : 2 ].each {key, value -> print key + ' '}
println ''

import static groovy.test.GroovyAssert.shouldFail

// Создаем неизменяемый список
def list2 = ['Groovy', 'Gradle', 'Micronaut'].asUnmodifiable()

shouldFail(UnsupportedOperationException) {
    // Не можем добавить новый элемент.
    list2 << 'Java'
}
//Создаем неизменяемый ассоциативный массив
def data = [name: 'Language', subject: 'Groovy'].asUnmodifiable()
shouldFail(UnsupportedOperationException) {
    // Не можем добавить новый ключ
    data.key = 'Java'
}

println list2 + ' ' + data