package nova2d.engine.timer;

/**
 * Timer class for getting the current time in nanoseconds.
 */
public class Timer {
    private Timer() {}

    private final static double NANOS_PER_SECOND = 1_000_000_000;

    /**
     * Returns the current time in nanoseconds.
     * @return long nanoTime
     */
    public static long nanoTime() {
        return System.nanoTime();
    }

    /**
     * Converts a value in nanoseconds to seconds.
     * @param val
     * @return double seconds
     */
    public static double toSeconds(double val) {
        return val / NANOS_PER_SECOND;
    }
}
