import java.util.ArrayList;
import java.util.Scanner;

import resep.menu.MainMenu;
import resep.models.User;
import resep.utils.InitialData;
import resep.utils.ScreenHelper;

public class MyResep {
    private static Scanner input = new Scanner(System.in);
    private static InitialData initialData = new InitialData();
    private static ArrayList<User> dataUser;
    private static User userAktif;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        dataUser = initialData.initUser();

        while(isRunning) {
            showMenu();
        }
    }

    private static void showMenu() {
        while(userAktif == null) {
            loginMenu();
        }
        MainMenu menuResep = new MainMenu(dataUser, userAktif);
        menuResep.tampilMenu();
        
        userAktif = null;
        System.out.print("Apakah anda ingin menutup program? (y|t) : ");
        String jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("y")) {
            isRunning = false;
            System.out.print("Terima kasih telah menggunakan program ini.");
        }
    }

    private static void loginMenu() {
        ScreenHelper.clearConsole();
        String username, password;
        System.out.println("+=============================================+");
        System.out.println("|                    LOGIN                    |");
        System.out.println("+=============================================+");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        for (User temp: dataUser) {
            if (temp.login(username, password)) {
                userAktif = temp;
            }
        }           
    }
}
