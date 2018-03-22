package scripts

import groovy.sql.Sql
@GrabConfig(systemClassLoader=true)
@Grab(group='org.postgresql', module='postgresql', version='9.4-1205-jdbc42')

Sql sql = Sql.newInstance("jdbc:postgresql://localhost:5432/main", "postgres", "123456", "org.postgresql.Driver")

sql.eachRow("select * from public.user"){ row -> println row.firstname + " " + row.lastname }



