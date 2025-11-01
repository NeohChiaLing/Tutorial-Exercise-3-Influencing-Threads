package Task2;

class Airplane extends Thread {
    private String flightName;

    public Airplane(String flightName, int priority) {
        this.flightName = flightName;
        setPriority(priority); // Set priority for the thread
    }

    @Override
    public void run() {
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

    public static void main(String[] args) {
        Airplane flight1 = new Airplane("Flight MAS01 EL-MARIACHI", Thread.MAX_PRIORITY); // VIP flight
        Airplane flight2 = new Airplane("Flight MAS02 EUDORA", Thread.NORM_PRIORITY); // Normal flight
        Airplane flight3 = new Airplane("Flight MAS03 DEJAVU", Thread.MIN_PRIORITY); // Low-priority flight
        Airplane flight4 = new Airplane("Flight MAS04 UTOPIA", Thread.NORM_PRIORITY); // Normal flight

        flight1.start();
        flight2.start();
        flight3.start();
        flight4.start();
    }
}
