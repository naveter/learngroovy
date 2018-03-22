package scripts

def out= new File('../../resourse/readFile.txt')
// если файл не существует, то создаем файл
if(!out.exists()) throw new Exception("File does not exists")

out.eachLine { println it}

//выводим информацию о файле
println out.name
println out.isAbsolute()
println out.path 
println out.parent
println out.absolutePath 
println out.absoluteFile.toString()
println out.canonicalPath
println out.canonicalFile.toString()
println out.toURI().toString()
