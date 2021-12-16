import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
public class AirportApp {
    private static String AIRPORTS_PATH = "L_AIRPORT_ID.csv";
    private static String FLIGHTS_PATH = "L_AIRPORT_ID.csv";
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("dpdp_lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airports = sc.textFile(AIRPORTS_PATH);
        JavaRDD<String> flights = sc.textFile(FLIGHTS_PATH);
        JavaPairRDD<String, String> airportData = airports.mapToPair();
    }
}
