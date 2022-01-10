import java.io.Serializable;

public class Stats implements Serializable {
    private double maxDelay;
    private int totalFlights;
    private int lateFlights;
    private int cancelledFlights;
    private final static int INITIAL_FLIGHTS = 1;
    private final static int PERCENT = 100;
    private final static String FLOAT_INPUT_FORMAT = "%.2f";

    public Stats(double maxDelay, int lateFlights, int cancelledFlights, int totalFlights) {
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

    public static Stats createCombiner(String delay) {
        boolean isCancelled = delay.isEmpty();
        double maxDelay = isCancelled ? 0 : Double.parseDouble(delay);
        boolean isDelayed = maxDelay > 0;
        return new Stats(maxDelay, isDelayed ? 1 : 0, isCancelled ? 1 : 0, INITIAL_FLIGHTS);
    }

    public static Stats mergeValue(String delay) {
        Stats st1 = Stats.createCombiner(delay);
        return mergeCombiners(stats, st1);
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
        if (this.totalFlights > 0) {
            double lateFlightsPercent = lateFlights / totalFlights * PERCENT;
            String formattedLateFlightsPercent = String.format(FLOAT_INPUT_FORMAT, lateFlightsPercent);
            double cancelledFlightsPercent = cancelledFlights / totalFlights * PERCENT;
            String formattedCancelledFlightsPercent = String.format(FLOAT_INPUT_FORMAT, cancelledFlightsPercent);
            return "maxDelay = " + this.maxDelay + " lateFlightsPercent = " + lateFlightsPercent
                    + " cancelledFlightsPercent = " + cancelledFlightsPercent;
        }
        return null;
    }
}
