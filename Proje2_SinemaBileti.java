//(AD-SOYAD = MUHAMMED ALİ YÜCESU)
//( ÖĞRENCİ NUMARASI = 250541065)





import java.util.Scanner;

public class SinemaBileti {


    public static boolean isWeekend(int gun) {

        return gun == 6 || gun == 7;
    }


    public static boolean isMatinee(int saat) {
        return saat < 12;
    }


    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun) ;
        boolean matinee = isMatinee(saat);

        if (weekend) {
            if (matinee) return 55;
            else return 85;
        } else {
            if (matinee) return 45;
            else return 65 ;
        }
    }


    public static double calculateDiscount(int yas, int meslek, int gun) {


        if (yas >= 65) {
            return 0.30;
        }


        if (yas < 12) {
            return 0.25;
        }


        if (meslek == 2 && gun == 3) {
            return 0.35;
        }


        if (meslek == 1) {

            if (gun >= 1 && gun <= 4) {
                return 0.20;
            } else {
                return 0.15;
            }
        }

        return 0.0;
    }


    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25;  // 3D
            case 3: return 35;  // IMAX
            case 4: return 50;  // 4DX
            default: return 0;  // 2D
        }
    }


    public static double calculateFinalPrice(int gun,int saat,int yas,int meslek,int filmTuru) {
        double base = calculateBasePrice(gun, saat) ;
        double discountRate = calculateDiscount(yas , meslek, gun);
        double discounted = base - (base * discountRate);
        double extra = getFormatExtra(filmTuru) ;

        return discounted + extra;
    }


    public static String generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double total = calculateFinalPrice(gun, saat, yas, meslek, filmTuru) ;

        return "----- Bilet Bilgisi -----\n" +
                "Gün: " + gun + "\n" +
                "Saat: " + saat + "\n" +
                "Yaş: " + yas + "\n" +
                "Meslek: " + meslek + "\n" +
                "Film Türü: " + filmTuru + "\n" +
                "Toplam Fiyat: " + total + " TL";
    }

    // Ana program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Gün (1-7): ");
        int gun = sc.nextInt();
        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();
        System.out.print("Yaş: ");
        int yas = sc.nextInt();
        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ") ;
        int meslek = sc.nextInt();
        System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ") ;
        int filmTuru = sc.nextInt();



        System.out.println();
        System.out.println(generateTicketInfo(gun, saat, yas, meslek, filmTuru));
    }
}

