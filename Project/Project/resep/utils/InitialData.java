package resep.utils;

import java.util.ArrayList;
import resep.models.*;
import resep.models.Resep.JenisMakanan;

public class InitialData {
    private ArrayList<Bahan> dataBahan = new ArrayList<>();
    private ArrayList<User> dataUser = new ArrayList<>();
    
    public ArrayList<Bahan> initBahan(){
        Bahan tempBahan = new Bahan();
        tempBahan.setKode("BHN01");
        tempBahan.setNama("Beras");
        tempBahan.setKategori("Pokok");
        tempBahan.setJumlah(10);
        dataBahan.add(tempBahan);

        tempBahan = new Bahan();
        tempBahan.setKode("BHN02");
        tempBahan.setNama("Garam");
        tempBahan.setKategori("Bumbu");
        tempBahan.setJumlah(10);
        dataBahan.add(tempBahan);

        tempBahan = new Bahan();
        tempBahan.setKode("BHN03");
        tempBahan.setNama("Gula");
        tempBahan.setKategori("Bumbu");
        tempBahan.setJumlah(10);
        dataBahan.add(tempBahan);

        tempBahan = new Bahan();
        tempBahan.setKode("BHN04");
        tempBahan.setNama("Jahe");
        tempBahan.setKategori("Rempah");
        tempBahan.setJumlah(10);
        dataBahan.add(tempBahan);

        tempBahan = new Bahan();
        tempBahan.setKode("BHN05");
        tempBahan.setNama("Kunyit");
        tempBahan.setKategori("Rempah");
        tempBahan.setJumlah(10);
        dataBahan.add(tempBahan);

        return dataBahan;
    }

    public ArrayList<User> initUser(){
        User tempUser = new User(
            "iqbar",
            "iqbar@oop.com",
            "iqbar",
            "123456"
        );
        dataUser.add(tempUser);

        tempUser = new User(
            "dewa",
            "dewa@oop.com",
            "dewa",
            "123456"
        );
        dataUser.add(tempUser);

        tempUser = new User(
            "febri",
            "febri@oop.com",
            "febri",
            "123456"
        );
        dataUser.add(tempUser);

        tempUser = new User(
            "indra",
            "indra@oop.com",
            "indra",
            "123456"
        );
        dataUser.add(tempUser);

        return dataUser;
    }    

    public ArrayList<Makanan> initMakanan(){
        ArrayList<Makanan> dataMakanan = new ArrayList<>();

        Makanan appetizer = new Makanan(JenisMakanan.APPETIZER);
        Makanan mainCourse = new Makanan(JenisMakanan.MAIN_COURSE);
        Makanan dessert = new Makanan(JenisMakanan.DESSERT);

        Resep tempResep = new Resep(
            "Ayam Betutu",
            "Ayam, Base Genep",
            "Datang ke restoran, lalu pesan ayam betutu",
            "I Wayan Yana",
            JenisMakanan.MAIN_COURSE
        );
        mainCourse.tambahResep(tempResep);

        tempResep = new Resep(
            "Babi Guling",
            "Babi, Base Genep",
            "Datang ke restoran, lalu pesan babi guling",
            "Putu Chandra",
            JenisMakanan.MAIN_COURSE
        );
        mainCourse.tambahResep(tempResep);

        tempResep = new Resep(
            "Sup Kepala Ikan",
            "Ikan, Base Genep",
            "Datang ke restoran, lalu pesan sup ikan",
            "Mak Beng",
            JenisMakanan.MAIN_COURSE
        );
        mainCourse.tambahResep(tempResep);

        tempResep = new Resep(
            "Nasi Jinggo",
            "Nasi, Sisanya tergantung",
            "Datang ke dagang nasi jinggo, lalu beli 2 bungkus",
            "Pakde Febri",
            JenisMakanan.MAIN_COURSE
        );
        mainCourse.tambahResep(tempResep);

        tempResep = new Resep(
            "Lawar Plek",
            "Babi, Base Genep",
            "Datang ke restoran, lalu pesan lawar plek",
            "Dewa Satria",
            JenisMakanan.MAIN_COURSE
        );
        mainCourse.tambahResep(tempResep);

        // Tambahkan makanan jenis appetizer dan dessert jika ada
        appetizer.tambahResep(new Resep(
            "Salad Buah",
            "Buah-buahan segar, yogurt",
            "Campur semua bahan, lalu sajikan dingin",
            "Chef Andi",
            JenisMakanan.APPETIZER
        ));

        dessert.tambahResep(new Resep(
            "Brownies",
            "Cokelat, tepung, telur, gula",
            "Campur semua bahan, panggang selama 20 menit",
            "Chef Budi",
            JenisMakanan.DESSERT
        ));

        dataMakanan.add(appetizer);
        dataMakanan.add(mainCourse);
        dataMakanan.add(dessert);

        return dataMakanan;
    }

    public ArrayList<Resep> initResep() {
        ArrayList<Resep> dataResep = new ArrayList<>();

        dataResep.add(new Resep(
            "Ayam Betutu",
            "Ayam, Base Genep",
            "Datang ke restoran, lalu pesan ayam betutu",
            "I Wayan Yana",
            JenisMakanan.MAIN_COURSE
        ));

        dataResep.add(new Resep(
            "Babi Guling",
            "Babi, Base Genep",
            "Datang ke restoran, lalu pesan babi guling",
            "Putu Chandra",
            JenisMakanan.MAIN_COURSE
        ));

        dataResep.add(new Resep(
            "Sup Kepala Ikan",
            "Ikan, Base Genep",
            "Datang ke restoran, lalu pesan sup ikan",
            "Mak Beng",
            JenisMakanan.MAIN_COURSE
        ));

        dataResep.add(new Resep(
            "Nasi Jinggo",
            "Nasi, Sisanya tergantung",
            "Datang ke dagang nasi jinggo, lalu beli 2 bungkus",
            "Pakde Febri",
            JenisMakanan.MAIN_COURSE
        ));

        dataResep.add(new Resep(
            "Lawar Plek",
            "Babi, Base Genep",
            "Datang ke restoran, lalu pesan lawar plek",
            "Dewa Satria",
            JenisMakanan.MAIN_COURSE
        ));

        dataResep.add(new Resep(
            "Salad Buah",
            "Buah-buahan segar, yogurt",
            "Campur semua bahan, lalu sajikan dingin",
            "Chef Andi",
            JenisMakanan.APPETIZER
        ));

        dataResep.add(new Resep(
            "Brownies",
            "Cokelat, tepung, telur, gula",
            "Campur semua bahan, panggang selama 20 menit",
            "Chef Budi",
            JenisMakanan.DESSERT
        ));

        return dataResep;
    }
}
