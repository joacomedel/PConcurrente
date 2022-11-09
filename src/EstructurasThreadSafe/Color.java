package EstructurasThreadSafe;

import java.util.Random;

import javafx.scene.chart.AreaChart;

public class Color {
    private static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String WHITE = "\033[0;37m";   // WHITE
    private static final String RESET = "\033[0m";
    private static final String[] arreglo = {BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN,WHITE};
    public static String getRandomColor() {
        Random random = new Random();
        return arreglo[random.nextInt(7)];
    }
    public static String reset(){
        return RESET;
    }
}