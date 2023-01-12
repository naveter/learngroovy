package scripts

import groovy.transform.MapConstructor

@MapConstructor
class ManFinal {
    final String name // AST трансформация поддерживает финальные поля.
    final int age
}
def adamFinal = new ManFinal(name: 'Adam', age: 30)
assert adamFinal.age == 30

@MapConstructor
class WomanFinal {
    // не финальные поля!
    String name
    int age
    WomanFinal(int age, String name) {
        this.name = name
        this.age = age
    }
}
//теперь наш класс может принимать параметр типа Map
def evaFinal = new WomanFinal(name: 'Eva', age: 19)
assert evaFinal.age == 19
//также можем вызвать и наш собственный конструктор
def diana = new WomanFinal(20, 'Diana')
assert diana.age == 20


