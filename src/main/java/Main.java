import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog();
        //...
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            System.out.println("+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "<< - Undo (отмени последнюю команду)\n" +
                    ">> - Redo (повтори отменённую команду)\n" +
                    "!! - повтори последнюю команду\n" +
                    "0 - выход");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (input.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (input.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else if (input.equals("!!")) {
                if (curCommand == commands.size()) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCommand).doit();
                    curCommand++;
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    commands.clear();
                }

                if (Integer.parseInt(input) < 0) {
                    FrogCommand cmd = FrogCommands.jumpLeftCommand(frog, Integer.parseInt(input));
                    curCommand++;
                    commands.add(cmd);
                    cmd.doit();
                } else {
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, Integer.parseInt(input));
                    curCommand++;
                    commands.add(cmd);
                    cmd.doit();
                }
            }

            for (int i = 0; i <= frog.MAX_POSITION; i++)

                if (i == frog.position) {
                    System.out.print("@");
                } else {
                    System.out.print("*");
                }

            System.out.println();
        }
    }
}