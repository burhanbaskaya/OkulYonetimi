import java.util.Scanner;

public class Islemler implements IslemlerInterface{

    static Scanner scan = new Scanner(System.in);
    static int secim = 0;
    public static void islemlerMenu(int i) {

        Islemler obj = new Islemler();
        secim = i;

        System.out.println("============= İŞLEMLER =============");
        System.out.println("Lutfen secim yapiniz");
        System.out.println("1-Ekleme\n2-Arama\n3-Listeleme\n4-Silme\n5-Ana Menu\n6-Cikis");

        int scm = TryCathes.integerGiris();

        switch(scm){

            case 1:
                obj.ekleme();
                islemlerMenu(secim);
                break;
            case 2:
                obj.arama();
                islemlerMenu(secim);
                break;
            case 3:
                obj.listeleme();
                islemlerMenu(secim);
                break;
            case 4:
                obj.silme();
                islemlerMenu(secim);
                break;
            case 5:
                obj.anaMenu();
                islemlerMenu(secim);
                break;
            case 6:
                obj.cıkıs();
                islemlerMenu(secim);
                break;
            default:
                System.out.println("Lutfen gecerli bir ifade giriniz");
                islemlerMenu(secim);

        }


    }

    @Override
    public void ekleme() {
        System.out.println("kimlik no giriniz");
        String kimlikID = scan.next();
        kimlikIDKontrol(kimlikID);
        if (secim==1){
            ogrenciBilgiAlKaydet(kimlikID);
        }else{
            ogretmenBilgiKaydet(kimlikID);
        }

    }

    private void ogretmenBilgiKaydet(String kimlikID) {
        System.out.println("ad soyad yas numara sinif giriniz");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        String yas = scan.next();
        String bolum = scan.next();
        String sicil = scan.next();
        Ogretmen obj = new Ogretmen(adSoyad,yas,bolum,sicil);
        Ogretmen.ogretmenListesiMap.put(kimlikID,obj);

    }

    private void ogrenciBilgiAlKaydet(String kimlikID) {
        System.out.println("ad soyad yas numara sinif giriniz");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        String yas = scan.next();
        String numara = scan.next();
        String sinif = scan.next();
        Ogrenci obj = new Ogrenci(adSoyad,yas,numara,sinif);
        Ogrenci.ogrenciListesiMap.put(kimlikID,obj);



    }

    private void kimlikIDKontrol(String kimlikID) {
        if(Ogrenci.ogrenciListesiMap.containsKey(kimlikID)||Ogretmen.ogretmenListesiMap.containsKey(kimlikID)){
            System.out.println("Bu ID kayit yapilmis");
            AnaMenu.giris();
        }

    }

    @Override
    public void arama() {
        System.out.println("kimlik no giriniz");
        String kimlikID = scan.next();
        if (secim==1){
            if(Ogrenci.ogrenciListesiMap.containsKey(kimlikID)){
                System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikID));
            }else System.out.println("Kayitli degil");
        }else if (secim==2){
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)){
                System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikID));
            }else System.out.println("Kayitli degil");
        }

    }

    @Override
    public void listeleme() {
        if (secim==1){
            System.out.println(Ogrenci.ogrenciListesiMap);
        }else if (secim==2){
            System.out.println(Ogretmen.ogretmenListesiMap);
        }

    }

    @Override
    public void silme() {
        System.out.println("kimlik no giriniz");
        String kimlikID = scan.next();
        if (secim==1){
            if(Ogrenci.ogrenciListesiMap.containsKey(kimlikID)){
                System.out.println(Ogrenci.ogrenciListesiMap.remove(kimlikID));
            }else System.out.println("KimlikID mevcut degil");
        }else if (secim==2){
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)){
                System.out.println(Ogretmen.ogretmenListesiMap.remove(kimlikID));
            }else System.out.println("KimlikID mevcut degil");
        }
    }

    @Override
    public void anaMenu() {
        AnaMenu.giris();

    }

    @Override
    public void cıkıs() {
        System.out.println("Bye bye");

    }
}
