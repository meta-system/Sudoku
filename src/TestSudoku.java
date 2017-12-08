import java.io.*;
public class TestSudoku {
    public static void main(String[] args) throws IOException {
        Sudoku mySudoku = new Sudoku("src/beispiel.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean victory = false;
        int zeile=0, spalte=0, wert=0;
        do {
            mySudoku.print();

            System.out.print("Zeile:  ");
            zeile = Integer.parseInt(br.readLine());

            System.out.print("\nSpalte:  ");
            spalte = Integer.parseInt(br.readLine());

            System.out.print("\nWert:  ");
            wert = Integer.parseInt(br.readLine());

            switch (mySudoku.setze(zeile, spalte, wert)){
                case 'p' : System.out.print("Als Zeilen und Spalten sind nur Werte zwischen 1 und 9 zulässig !"); break;
                case 'w' : System.out.print("Der Wert muss zwischen 1 und 9 liegen !"); break;
                case 'q' : System.out.print("Der Wert muss zwischen 1 und 9 liegen !"); break;
                case '' : System.out.print("Der Wert muss zwischen 1 und 9 liegen !"); break;
                case 'f' : System.out.print("Der Wert muss zwischen 1 und 9 liegen !"); break;
                case 'l' : System.out.print("Der Wert muss zwischen 1 und 9 liegen !"); break;

            }

        } while (!victory);

        mySudoku.print();
    }

    public static boolean setze (){

    }
}
