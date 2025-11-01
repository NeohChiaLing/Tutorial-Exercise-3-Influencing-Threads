package Task3;

class Airplane extends Thread {
    private static final Object runwayLock = new Object(); // Lock for synchronizing runway access
    private String flightName;

    public Airplane(String flightName, int priority) {
        this.flightName = flightName;
        setPriority(priority);
    }

    @Override
    public void run() {
        synchronized (runwayLock) {  // Only one thread can access the runway at a time
            try {
                System.out.println(flightName + " is requesting runway access.");
                Thread.sleep(1000);

                System.out.println(flightName + " is taking off.");
                Thread.sleep(3000);

                System.out.println(flightName + " is leaving the runway.");
            } catch (InterruptedException e) {
                System.out.println(flightName + " has been interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        Airplane flight1 = new Airplane("Flight MAS01 EL-MARIACHI", Thread.MAX_PRIORITY);
        Airplane flight2 = new Airplane("Flight MAS02 EUDORA", Thread.NORM_PRIORITY);
        Airplane flight3 = new Airplane("Flight MAS03 DEJAVU", Thread.MIN_PRIORITY);
        Airplane flight4 = new Airplane("Flight MAS04 UTOPIA", Thread.NORM_PRIORITY);

        flight1.start();
        flight2.start();
        flight3.start();
        flight4.start();
    }
}
