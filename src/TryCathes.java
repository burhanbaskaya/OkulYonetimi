import java.util.Scanner;

public class TryCathes {
    public static int integerGiris(){

        Scanner scan = new Scanner(System.in);
        int giris = 0;
        boolean flag = false;

        do {
            System.out.println("Lutfen giris yapiniz");
            if (flag==true){
                scan.nextLine();
                flag=false;
            }

                                                // ctrl+alt+t
            try {
                giris = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Hatali giris yaptiniz");
                flag = true;
                integerGiris();
            }


        }while (flag);

        return giris;
    }
}
