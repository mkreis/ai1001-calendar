import java.util.Scanner;

public class Kalender {

    static final int WIDTH = 4;
    static final int HEIGHT = 6;

    public static void main(String[] args) {

        var k = new Kalender();
    }


    public Kalender() {
        int[][] tuerchen = new int[HEIGHT][WIDTH];
        tuerchen = this.initCalendar(tuerchen);
        this.drawCalendar(tuerchen);
        this.getUserInput();
    }

    private void getUserInput() {
        System.out.println("Welches Türchen soll geöffnet werden?");
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Spalte? ");
            String column = s.next();
            System.out.print("Zeile? ");
            int row = s.nextInt();
            System.out.println("Ok, öffne " + column + row);
        }
        catch(java.util.InputMismatchException e) {
            System.out.print("Das war eine falsche Eingabe, kein Türchen für dich!!!");
            System.exit(0);
        }
        finally {
            s.close();
        }
    }

    private int[][] initCalendar(int[][] tuerchen) {

        int[] alleTueren = new int[WIDTH * HEIGHT];
        for(int i = 0; i < alleTueren.length; i++) {
            alleTueren[i] = i+1;
        }

        for(int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * alleTueren.length);
            int b = (int) (Math.random() * alleTueren.length);
            int x = alleTueren[a];
            alleTueren[a] = alleTueren[b];
            alleTueren[b] = x;
        }

        for(int i = 0; i < alleTueren.length; i++) {
            tuerchen[i / WIDTH][i % WIDTH] = alleTueren[i];
        }
        return tuerchen;
    }

    private void drawCalendar(int[][] tuerchen) {

        System.out.print("    | ");
        for(int i = 0; i < WIDTH; i++) {
            System.out.print(" " + (char) (i + 65) + "  | " );
        }
        System.out.println();
        System.out.println(makeLine(29));
        
        for(int i = 0; i < tuerchen.length; i++) {

            System.out.print(" " + i + "  | " );

            for(int j = 0; j < tuerchen[i].length; j++) {

                if(tuerchen[i][j] < 10) System.out.print(" ");
                System.out.print(" " + tuerchen[i][j] + " | ");
                
            }
            System.out.println();
            System.out.println(makeLine(29));
        }
    }

    private String makeLine(int length) {
        String line = "";
        for(int i = 0; i < length; i++) {
            line += "-";
        }
        return line;
    }
}