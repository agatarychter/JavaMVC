package views;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private static final String menuTop = "1 - Add movie\n2 - Find movie\n3 - Update movie\n4 - Delete movie\n5 - Add rental\n6 - Find rental\n7 - " +
            "Update rental\n8 - Delete rental\n9 - Display movies\n10 - Display rentals\n11 - Display movie's rentals\n0 - Quit" ;

    public View()
    {
        scanner = new Scanner(System.in);

    }
    public int getMenuOption()
    {
        System.out.println(menuTop);
        return scanner.nextInt();
    }
}
