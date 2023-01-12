package scripts

import groovy.transform.Immutable

// Эта аннотация которая генерирует из данного класса синглетон
@Singleton(lazy=true)
class MySingleton {
    def getHello(){
        "hello world"
    }
}

println MySingleton.instance.hello

// Эта аннотация позволяет внедрить в класс Manager поведение метода из класса Employee
class Employee {
    def doWork() { 'my work' }
}

class Manager {
    @Delegate
    Employee slave = new Employee()
}

def worker = new Manager()
println worker.doWork()

// либо можно сделать то же самое с помощью mixin
class Employee2 { def doWork() { 'my work' } }
class Manager2 {}

Manager2.mixin Employee2

println new Manager2().doWork()

// Аннотация @Immutable делает объект этого класса неизменяемым
// свойства объекта становятся readonly
@Immutable
class Person{
    String first, last
}