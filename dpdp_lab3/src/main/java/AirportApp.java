public class AirportApp {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("dpdp_lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
    }
}
