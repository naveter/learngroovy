package scripts

import groovy.sql.DataSet
@Grapes([
        @Grab(group='org.xerial',module='sqlite-jdbc',version='3.34.0'),
        @GrabConfig(systemClassLoader=true)
])
import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:sqlite:../../resourse/sample.db", "org.sqlite.JDBC")
sql.execute("drop table if exists person")
sql.execute("create table person (id integer, name string)")
def people = sql.dataSet("person")
people.add(id:1, name:"leo")
people.add(id:2,name:'yui')

sql.eachRow("select * from person") {
    println("id=${it.id}, name= ${it.name}")
}

users = sql.dataSet("person")
users.add(id: 3, name: "Karlos") //вставка новой записи в таблицу

DataSet findedUsers = users.findAll() // получение всех записей и их вывод
findedUsers.each{ println it.name}