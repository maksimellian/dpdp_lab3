import java.io.Serializable;

public class Flight implements Serializable {
    private int originAirportId;
    private int destinationAirportId;

    public Flight() {}

    public Flight(int originAirportId, int destinationAirportId) {
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
    }
}
