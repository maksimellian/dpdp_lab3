import java.io.Serializable;

public class Stats implements Serializable {
    private double maxDelay;
    private int totalFlights;
    private int lateFlights;
    private int cancelledFlights;
    private double lateFlightsPercent;
    private double cancelledFlightsPercent;

    public Stats() {
        this(, , , );
    }

    public StatsData(double maxDelay, int totalFlights, int lateFlights, int cancelledFlights) {
        this.maxDelay = maxDelay;
    }
}
