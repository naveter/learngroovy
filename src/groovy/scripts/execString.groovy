package scripts

new GroovyShell(getClass().classLoader).evaluate '''
class Greeter {
  def greet() {
    println "Hello from the greet() method!"
  }
}

new Greeter().greet()
'''
