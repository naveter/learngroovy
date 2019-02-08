package scripts

import java.util.Timer

def count = 0
def timer = new Timer()
timer.schedule({
    println (++count)
    if (count == 2) timer.cancel()
} as TimerTask, 1000, 3000)

class TimerTaskExample extends TimerTask {
    public void run(){
        println new Date()
    }
}
//timer = new Timer()
//timer.scheduleAtFixedRate(new TimerTaskExample(), 1000, 5000)

// 12345___

