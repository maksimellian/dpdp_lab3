import java.io.Serializable;

public class Flight implements Serializable {
    private int originAirportId;
    private int destinationAirportId;
    private double delay;
    private double cancellationStatus; // if cancelled 1.00, 0.00 else

    public Flight() {}

    public Flight(int originAirportId, int destinationAirportId, double delay, double cancellationStatus) {
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
        this.delay = delay;
        this.cancellationStatus = cancellationStatus;
    }

    
}
