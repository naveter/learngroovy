package scripts

import groovy.time.TimeCategory

def acceptedFormat = "yyyy-MM-dd"
def today = new Date() + 1
def tommorow = today.format(acceptedFormat)
println( "Tommorow: ${tommorow}")

// category classes
use TimeCategory, {
    def oneYear = today + 1.year
    println "One year plus: " + oneYear

    def ninetyDays = today + 1.months
    println "One month plus: " + ninetyDays
}

Object 0;

