import java.util.Scanner;

public class AnaMenu implements AnaMenuInterface {

    static Scanner scan = new Scanner(System.in);

    public static void giris() {

        AnaMenu obj = new AnaMenu();

        System.out.println("====================================");
        System.out.println("ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("====================================");
        System.out.println("Lutfen secimi yapiniz");
        System.out.println("1-Ogrenci İslemleri\n2-Ogretmen İslemleri\nQ-Cikis");

        String scm = scan.next().toUpperCase();

        switch (scm){
            case "1":
                obj.ogrenciIslemleri();
                break;
            case "2":
                obj.ogretmenIslemleri();
                break;
            case "Q":
                obj.cikis();
                break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz");
                giris();


        }





    }

    @Override
    public void ogrenciIslemleri() {
        Islemler.islemlerMenu(1);

    }

    @Override
    public void ogretmenIslemleri() {
        Islemler.islemlerMenu(2);

    }

    @Override
    public void cikis() {
        System.out.println("Tekrar bekleriz");

    }
}
