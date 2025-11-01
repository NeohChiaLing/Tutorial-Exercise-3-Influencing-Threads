package Task1;

public class Airplane extends Thread {
    private String flightName;

    public Airplane(String flightName) {
        this.flightName = flightName;
    }

    public Airplane(String flightName, int maxPriority) {
    }

    @Override
    public void run() {
        try {
            // Requesting runway access
            System.out.println(flightName + " is requesting runway access.");
            Thread.sleep(1000);  // Simulate time taken to request access

            // Taking off
            System.out.println(flightName + " is taking off.");
            Thread.sleep(3000);  // Simulate time taken for takeoff

            // Leaving the runway
            System.out.println(flightName + " is leaving the runway.");
        } catch (InterruptedException e) {
            System.out.println(flightName + " has been interrupted.");
        }
    }
}
class AirTrafficControl {
    public static void main(String[] args) {
        Airplane flight1 = new Airplane("Flight MAS01 EL-MARIACHI");
        Airplane flight2 = new Airplane("Flight MAS02 EUDORA");
        Airplane flight3 = new Airplane("Flight MAS03 DEJAVU");
        Airplane flight4 = new Airplane("Flight MAS04 UTOPIA");

        flight1.start();
        flight2.start();
        flight3.start();
        flight4.start();
    }
}
