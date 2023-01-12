package scripts

// https://mvnrepository.com/artifact/org.apache.groovy/groovy-yaml
@Grapes(
    @Grab(group='org.apache.groovy', module='groovy-yaml', version='4.0.3')
)


import groovy.yaml.YamlBuilder

def config = new YamlBuilder()
config {
    application 'Sample App'
    version '1.0.1'
    // Вложенный элемент YAML.
    database {
        url 'jdbc:db//localhost'
    }
    // Здесь будет массив строк.
    services 'ws1', 'ws2'
}
println(config.toString())

import groovy.yaml.YamlSlurper

def configYaml = '''\
application: "Sample App"
version: "1.0.1"
services:
- "WS1"
- "WS2"
'''
def config2 = new YamlSlurper().parseText(configYaml)
assert config2.application == 'Sample App'