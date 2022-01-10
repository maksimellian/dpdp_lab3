import org.apache.spark.api.java.function.Function2;

public class MergeValue implements Function2<Stats, String, Stats> {
    @Override
    public Stats call(Stats stats, String delay) throws Exception {
        return stats.mergeValue(delay);
    }
}