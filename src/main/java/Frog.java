public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        if (steps + position < 0 || steps + position > 10) {
            return false;
        }
        position += steps;
        return true;
    }
}