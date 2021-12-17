import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class AirportApp {
    private static String AIRPORTS_PATH = "L_AIRPORT_ID.csv";
    private static String FLIGHTS_PATH = "L_AIRPORT_ID.csv";
    private static String QUOTE = "\"";
    private static String COMMA = ",";
    private static int ORIGIN_AIRPORT_ID = 11;
    private static int DEST_AIRPORT_ID = 14;
    public static final int DELAY = 18;
    private static int AIRPORT_CODE = 0;
    private static int AIRPORT_DESCRIPTION = 1;

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("dpdp_lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airports = sc.textFile(AIRPORTS_PATH);
        airports = removeHeader(airports);
        JavaPairRDD<String, String> airportPairs = airports.mapToPair(row -> {
            String[] rowFields = row.split(COMMA);
            return new Tuple2<>(removeQuotes(rowFields[AIRPORT_CODE]), removeQuotes(rowFields[AIRPORT_DESCRIPTION]));
        });
        final Broadcast<Map<String, String>> airportsBroadcasted = sc.broadcast(airportPairs.collectAsMap());

        JavaRDD<String> flights = sc.textFile(FLIGHTS_PATH);
        flights = removeHeader(flights);
        // TODO JavaPairRDD<Tuple2>
    }

    public static String removeQuotes(String str) {
        return str.replaceAll(QUOTE, "");
    }

    public static JavaRDD<String> removeHeader(JavaRDD<String> rows) {
        String rowsHeader = rows.first();
        return rows.filter(row -> !row.equals(rowsHeader));
    }
}
