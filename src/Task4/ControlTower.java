package Task4;

import Task1.Airplane;

class ControlTower {
    public static void main(String[] args) {
        Airplane flight1 = new Airplane("Flight MAS01 EL-MARIACHI", Thread.MAX_PRIORITY);
        Airplane flight2 = new Airplane("Flight MAS02 EUDORA", Thread.NORM_PRIORITY);
        Airplane flight3 = new Airplane("Flight MAS03 DEJAVU", Thread.MIN_PRIORITY);
        Airplane flight4 = new Airplane("Flight MAS04 UTOPIA", Thread.NORM_PRIORITY);

        flight1.start();
        flight2.start();
        flight3.start();
        flight4.start();

        try {
            // Control Tower waits for all flights to finish before shutdown
            flight1.join();
            flight2.join();
            flight3.join();
            flight4.join();
            System.out.println("All flights completed. Control Tower closing operations.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
