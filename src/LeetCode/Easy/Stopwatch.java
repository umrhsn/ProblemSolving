package LeetCode.Easy;

public class Stopwatch {
    private static final long NANOS_IN_MILLI = 1_000_000L;
    private static final long MILLIS_IN_SECOND = 1_000L;
    private static final long SECONDS_IN_MINUTE = 60L;
    private static final long MINUTES_IN_HOUR = 60L;
    private static final long HOURS_IN_DAY = 24L;

    private long start;

    public Stopwatch() {
        this.start = System.nanoTime();
    }

    private long elapsedNanos() {
        return System.nanoTime() - start;
    }

    private long nanos() {
        return elapsedNanos() % NANOS_IN_MILLI;
    }

    private long millis() {
        return (elapsedNanos() / NANOS_IN_MILLI) % MILLIS_IN_SECOND;
    }

    private long seconds() {
        return (elapsedNanos() / (NANOS_IN_MILLI * MILLIS_IN_SECOND)) % SECONDS_IN_MINUTE;
    }

    private long minutes() {
        return (elapsedNanos() / (NANOS_IN_MILLI * MILLIS_IN_SECOND * SECONDS_IN_MINUTE)) % MINUTES_IN_HOUR;
    }

    private long hours() {
        return (elapsedNanos() / (NANOS_IN_MILLI * MILLIS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR)) % HOURS_IN_DAY;
    }

    private long days() {
        return elapsedNanos() / (NANOS_IN_MILLI * MILLIS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY);
    }

    public void reset() {
        this.start = System.nanoTime();
    }

    @Override
    public String toString() {
        return String.format("Elapsed time:\t%03d:%02d:%02d:%02d:%03d:%06d\n",
                days(), hours(), minutes(), seconds(), millis(), nanos());
    }
}
