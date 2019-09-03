package Blatt09.sizeWatcher;

/**
 * Hooked Thread
 * Prints an Info MSG if the Main-Thread ended
 */
public class WatchEnd extends Thread {

    private long time;

    @Override
    public void run() {
        super.run();
        System.out.println("Dateigroeßenueberwachung beendet...");
        time = (System.nanoTime()-SizeWatcher.start)/1000000000;
        System.out.print("Inerhalb von " + time + " Sekunden wurden " );
        if(SizeWatcher.difference>=0){
            System.out.println(SizeWatcher.difference + " byte geschieben");
        }else{
            System.out.println(Math.abs(SizeWatcher.difference) + " byte freigegeben");
        }
    }
}
