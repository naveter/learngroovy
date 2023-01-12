package scripts

print "start: "

// Реализация интерфейса как замыкания
def mainRunnable = {
    run:{
        try {
            int i = 5
            while (i>0) {
                sleep(1000)
                print "\r${i--} "
            }
        } catch (InterruptedException ex) {
            // error
        }
    }
} as Runnable

new Thread(mainRunnable).start()

new Thread([run: {
    try {
        int i = 5
        while (i>0) {
            sleep(1500)
            print "\r${i--} "
        }
    } catch (InterruptedException ex) {
        // error
    }
}] as Runnable).start();