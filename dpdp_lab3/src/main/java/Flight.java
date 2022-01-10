import java.io.Serializable;

public class Flight implements Serializable {
    private int originAirportId;
    private int destinationAirportId;
    private String delay;
    private double cancellationStatus; // if cancelled 1.00, 0.00 else

    public Flight() {}

    public Flight(int originAirportId, int destinationAirportId, String delay, double cancellationStatus) {
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
        this.delay = delay;
        this.cancellationStatus = cancellationStatus;
    }

    public int getOriginAirportId() {
        return this.originAirportId;
    }

    public int getDestinationAirportId() {
        return this.destinationAirportId;
    }

    public String getDelay() {
        return this.delay;
    }

    public double getCancellationStatus() {
        return this.cancellationStatus;
    }
}
