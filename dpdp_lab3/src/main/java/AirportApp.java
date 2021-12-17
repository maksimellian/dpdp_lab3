import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
public class AirportApp {
    private static String AIRPORTS_PATH = "L_AIRPORT_ID.csv";
    private static String FLIGHTS_PATH = "L_AIRPORT_ID.csv";
    private static String QUOTE = "\"";
    private static int ORIGIN_AIRPORT_ID = 11;
    private static int DEST_AIRPORT_ID = 14;
    public static final int DELAY = 18;

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("dpdp_lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airports = sc.textFile(AIRPORTS_PATH);
        airports = removeHeader(airports);



        JavaRDD<String> flights = sc.textFile(FLIGHTS_PATH);
    }

    public static String deleteQuotes(String str) {
        return str.replaceAll(QUOTE, "");
    }

    public static JavaRDD<String> removeHeader(JavaRDD<String> rows) {
        String rowsHeader = rows.first();
        return rows.filter(row -> !row.equals(rowsHeader));
    }
}
