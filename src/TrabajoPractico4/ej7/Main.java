package TrabajoPractico4.ej7;

public class Main {
    public static void main(String[] args) {
        String aNombre[] = {"Victoria","Joaquin","Adriana","Agostina","Jorge","Enrique","Pepito","Fulanito","Paula<3","Cata<3"};
        GestorCruce gestorCruce = new GestorCruce();
        Control control = new Control(gestorCruce);
        control.start();
        Coche aCoches[] = new Coche[10];
        for (int i = 0; i < 10; i++) {
            char c = 'N';
            if (i % 2 == 0) c = 'O';
            aCoches[i] = new Coche(aNombre[i],gestorCruce,c);
            aCoches[i].start();
        }
    }
}
