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

import java.util.GregorianCalendar as D
import static java.util.Calendar.getInstance as now

print (new D(2011, 11, 25).time) + ' '
print (now().time) + ' '

dateStr = "2011-06-03"
date = Date.parse("yyyy-MM-dd", dateStr)
println 'Date was ' + date.format("MM/dd/yyyy")