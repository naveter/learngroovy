package scripts

/**
 * This script will read each dir in path and look for ivy.xml files.
 * After it will read them, analise and filter it by adding to array
 */

def modulesMap = new HashMap<String, Map<String, List<String>>>();

dh = new File('../../resourse')
dh.eachFile {
    if (!it.isDirectory()) return
    println it

    ivyXml = new File('../../resourse/' + it.getName() + '/ivy.xml')
    if (!ivyXml.exists()) return

    def lines = ivyXml.readLines()
    lines.each { String line ->
        def matchDep = (line =~ '<dependency')
        if (matchDep.count == 0) return

        // <dependency org="junit" name="junit" rev="4.11" />
        def org = (line =~ 'org="([a-z0-9-]+)"')
        def name = (line =~ 'name="([a-z0-9-]+)"')
        def rev = (line =~ 'rev="([0-9.]+)"')
        if (org.count == 0 || name.count == 0) return

        if (modulesMap.get(org[0][1]) == null) {
            def tmpMap = new HashMap<String, List<String>>()
            modulesMap.put(org[0][1], tmpMap)
        }

        def nameMap = modulesMap.get(org[0][1])

        if (nameMap.size() == null) {
            def revList = new ArrayList<String>()
            if (rev.count > 0) revList.add(rev[0][1])
            nameMap.put(name[0][1], revList)
        }
        else {
            if (nameMap.get(name[0][1]) != null) {
                if (rev.count > 0 && !nameMap.get(name[0][1]).contains(rev[0][1]) ) {
                    nameMap.get(name[0][1]).add(rev[0][1])
                }
                else return
            }
            else {
                def revList = new ArrayList<String>()
                if (rev.count > 0) revList.add(rev[0][1])
                nameMap.put(name[0][1], revList)
            }
        }

    }

}

// print all filtered and ordered information
modulesMap.each {org ->
    println " "
    org.getValue().each {name ->
        println "org=" + org.getKey() + " name=" + name.getKey() + " rev=" + name.getValue().toString()
    }
}

