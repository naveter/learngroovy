package classes

class UserTest extends GroovyTestCase {
    void setUp() {
        super.setUp()

        println("setUp")
    }

    void testGetFirstname() {
        assertEquals "Bad firstname",  new User("firstname" : "Ivan").getFirstname(), "Ivan"
    }
}
