import java.util.Scanner;

public class GameLoop {


    public static void main(String[] args) {
        while (true){
            System.out.println("Das Spiel beginnt!");
            System.out.println("Was willst du machen? (1) rennen (2) reden (3)kämpfen (4) stehlen");

            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            if(eingabe.isEmpty()){
                continue;

            }
            if(Integer.parseInt(eingabe) == 0){
                continue;
            }
            switch (Integer.parseInt(eingabe)){
                case 1: System.out.println("Du rennst!");
                    break;
                case 2: System.out.println("Du redest!");
                    break;
                case 3: System.out.println("Du kämpfst");
                    break;
                case 4: System.out.println("Du Dieb!");
                    break;
                default:
                    System.out.println("Falsche Eingabe");
            }
        }
    }
}
