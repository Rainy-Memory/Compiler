package MiddleEnd;

public class Optimize {
    protected static boolean doOptimize = false;

    public static void enable() {
        doOptimize = true;
    }

    public static void disable() {
        doOptimize = false;
    }
}
