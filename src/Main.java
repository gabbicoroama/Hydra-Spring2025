import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GameMap gm = new GameMap();
        Scanner input = new Scanner(System.in);

        while (true) {
            gm.loadGameData("item.txt", "puzzles.txt", "Enemy.txt", "NPC.txt",
                    "Map.txt");
            break;
        }
        input.close();
    }
}
