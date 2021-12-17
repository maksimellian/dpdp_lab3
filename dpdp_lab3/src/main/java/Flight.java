import java.io.Serializable;

public class Flight implements Serializable {
    private int originAirportId;
    private int destinationAirportId;
    private double delay;

    public Flight() {}

    public Flight(int originAirportId, int destinationAirportId, double delay) {
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
        this.delay = delay;
    }
}
