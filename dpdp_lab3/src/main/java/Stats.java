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

    public Stats mergeValue(String delay) {
        Stats st = Stats.createCombiner(delay);
        return this.mergeCombiners(st);
    }

    public Stats mergeCombiners(Stats st) {
        this.maxDelay = Math.max(st.getMaxDelay(), this.maxDelay);
        this.totalFlights += st.getTotalFlights();
        this.lateFlights += st.getLateFlights();
        this.cancelledFlights += st.getCancelledFlights();
        return this;
    }

    public static String getResult()
}
