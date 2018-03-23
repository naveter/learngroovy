package scripts

def path = "../../resourse/"
def file1Map = [:]
def intersect = []

println "File 1: " + args[0]
println "File 2: " + args[1]

def file = new File(path + args[0])
if(!file.exists()) throw new Exception("File 1 does not exists")
file.eachLine { file1Map[it] = file1Map.get(it, 0) + 1 }
//file.eachLine { file1Map[it] = 1 }

println("File 1 contain " + file1Map.size())

file = new File(path + args[1])
if(!file.exists()) throw new Exception("File 2 does not exists")

file.eachLine {
    if (file1Map[it] != null) intersect << it
}

println "Equals words in both files:"
intersect.each {println(it)}
