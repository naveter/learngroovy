package scripts

// интерфейс
interface Human{
    def HUMAN_NAME = 'Adam'//константа
    def HAIR_TYPES = ['Blondie','Brown']//массив
    int age()
    String fullInfo()
}
//классы его реализующие
class Man implements Human {
    String name=HUMAN_NAME
    int age
    String hair = HAIR_TYPES[0]
    @Override
    int age() {
        age
    }

    @Override
    String fullInfo() {
        "name:${name};age:${age};hair:${hair}"
    }
}
class Woman implements Human {
    String name
    int age
    String hair = HAIR_TYPES[1]
    @Override
    int age() {
        age
    }

    @Override
    String fullInfo() {
        Woman.class.getSimpleName()+";name:${name};age:${age};hair:${hair}"
    }
}
//использование
def adam = new Man(age: 22 ) as Human
println(adam.fullInfo())
def eva = new Woman()
eva.name = 'Eva'
eva.age = 18
println(eva.fullInfo())
//отложенная инициализация
def kain = new Man()
kain.with {
    name='Kain'
    age=5
}
println(kain.fullInfo())
// тоже самое, но тут происходит возврат этого объекта
def avel = new Man().with {
    name='Avel'
    age=2
    it
}
println(avel.fullInfo())
def irod = new Man().tap {
    name='Irod'
    age=32
    hair=HAIR_TYPES[1]
}
println(irod.fullInfo())
println("irod age:"+irod.age())
