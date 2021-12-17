import java.io.Serializable;

public class Stats implements Serializable {
    private double maxDelay;
    private int totalFlights;
    private int lateFlights;
    private int cancelledFlights;
    private double lateFlightsPercent;
    private double cancelledFlightsPercent;

    public Stats(double maxDelay, int totalFlights, int lateFlights, int cancelledFlights) {
        this.maxDelay = maxDelay;
        this.totalFlights = totalFlights;
        this.lateFlights = lateFlights;
        this.cancelledFlights = cancelledFlights;
    }
    
}
