package EstructurasThreadSafe;

import java.util.Random;


public class Color { // WHITE
    private static final String RESET = "\033[0m";
    private static final String[] arreglo = {"\033[0;30m","\033[0;31m","\033[0;32m","\033[0;33m","\033[0;34m","\033[0;35m","\033[0;36m","\033[0;37m"};
    public static String getRandomColor() {
        Random random = new Random();
        return arreglo[random.nextInt(7)];
    }
    public static String reset(){
        return RESET;
    }
    public static String getBlack() {
        return arreglo[0];
    }
    public static String getRed() {
        return arreglo[1];
    }
    public static String getGreen() {
        return arreglo[2];
    }
    public static String getYellow() {
        return arreglo[3];
    }
    public static String getBlue() {
        return arreglo[4];
    }
    public static String getPurple() {
        return arreglo[5];
    }
    public static String getCyan() {
        return arreglo[6];
    }
    public static String getWhite() {
        return arreglo[7];
    }

    
}