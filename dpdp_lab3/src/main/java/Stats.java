import java.io.Serializable;

public class Stats implements Serializable {
    private double maxDelay;
    private int totalFlights;
    private int lateFlights;
    private int cancelledFlights;
    private final static int INITIAL_FLIGHTS = 1;
    private final static int PERCENT = 100;
    private final static String FLOAT_INPUT_FORMAT = "%.2f";

    public Stats(double maxDelay, int totalFlights, int lateFlights, int cancelledFlights) {
        this.maxDelay = maxDelay;
        this.totalFlights = totalFlights;
        this.lateFlights = lateFlights;
        this.cancelledFlights = cancelledFlights;
    }

    public double getMaxDelay() {
        return this.maxDelay;
    }

    public int getTotalFlights() {
        return this.totalFlights;
    }

    public int getLateFlights() {
        return this.lateFlights;
    }

    public int getCancelledFlights() {
        return this.cancelledFlights;
    }

    public static Stats createCombiner(Flight value) {
        return new Stats(value.getDelay(),
                INITIAL_FLIGHTS, value.getDelay() > 0 ? 1 : 0, value.getCancellationStatus() > 0 ? 1 : 0);
    }

    public static Stats mergeValue(Stats stats, Flight flight) {
        double maxDelay = Math.max(stats.getMaxDelay(), flight.getDelay());
        int totalFlights = stats.getTotalFlights() + 1;
        int cancelledFlights = stats.getCancelledFlights();
        int lateFlights = stats.getLateFlights();
        if (flight.getCancellationStatus() > 0) {
            cancelledFlights++;
        }
        else if (flight.getDelay() > 0) {
            lateFlights++;
        }
        return new Stats(maxDelay, totalFlights, lateFlights, cancelledFlights);
    }

    public static Stats mergeCombiners(Stats st1, Stats st2) {
        double maxDelay = Math.max(st1.getMaxDelay(), st2.getMaxDelay());
        int totalFlights = st1.getTotalFlights() + st2.getTotalFlights();
        int lateFlights = st1.getLateFlights() + st2.getLateFlights();
        int cancelledFlights = st1.getCancelledFlights() + st2.getCancelledFlights();
        return new Stats(maxDelay, totalFlights, lateFlights, cancelledFlights);
    }

    @Override
    public String toString() {
        double lateFlightsPercent = lateFlights/totalFlights * PERCENT;
        String formattedLateFlightsPercent = String.format(FLOAT_INPUT_FORMAT, lateFlightsPercent);
        double cancelledFlightsPercent = cancelledFlights/totalFlights * PERCENT;
        String formattedCancelledFlightsPercent = String.format(FLOAT_INPUT_FORMAT, cancelledFlightsPercent);
        return "maxDelay = " + this.maxDelay + " lateFlightsPercent = " + lateFlightsPercent
                + " cancelledFlightsPercent = " + cancelledFlightsPercent;
    }


}
