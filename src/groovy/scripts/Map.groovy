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