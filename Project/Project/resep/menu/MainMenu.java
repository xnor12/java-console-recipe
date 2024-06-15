package resep.menu;

import java.util.ArrayList;
import java.util.Scanner;
import resep.models.*;
import resep.utils.InitialData;
import resep.utils.ScreenHelper;

public class MainMenu {
    private InitialData masterData = new InitialData();
    private ArrayList<Bahan> dataBahan = masterData.initBahan();
    private ArrayList<Makanan> dataMakanan = masterData.initMakanan();
    private ArrayList<Resep> dataResep = masterData.initResep();
    private ArrayList<ResepFavorit> dataResepFavorit = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private User userAktif;
    private MenuBahan menuBahan;
    private MenuUser menuUser;
    private MenuMakanan menuMakanan;
    private MenuResepFavorit menuResepFavorit;

    public MainMenu(ArrayList<User> dataUser, User user) {
        this.userAktif = user;
        this.menuBahan = new MenuBahan(dataBahan);
        this.menuUser = new MenuUser(dataUser);
        this.menuMakanan = new MenuMakanan(dataMakanan);
        this.menuResepFavorit = new MenuResepFavorit(dataResepFavorit, dataResep, userAktif);
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                  MAIN MENU                  |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Data Bahan                              |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Data Makanan                            |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Data User                               |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Resep Favorit                           |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Logout                                  |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    menuBahan.tampilMenu();
                    break;
                case 2:
                    menuMakanan.tampilMenu();
                    break;
                case 3:
                    menuUser.tampilMenu();
                    break;
                case 4:
                    menuResepFavorit.tampilMenu();
                    break;
                case 0:
                    ScreenHelper.clearConsole();
                    System.out.println("+=============================================+");
                    System.out.println("|             KELUAR DARI PROGRAM             |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }
}
