package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class kennzeichengen {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int KENNZEICHEN_LENGTH = 6;
    private static List<String> kennzeichenListe = new ArrayList<>();

    public static String generiereKennzeichen() {
        String kennzeichen;
        do {
            kennzeichen = generiereZufaelligeZeichenfolge(KENNZEICHEN_LENGTH);
        } while (kennzeichenListe.contains(kennzeichen));
        kennzeichenListe.add(kennzeichen);
        return kennzeichen;
    }

    private static String generiereZufaelligeZeichenfolge(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(index));
        }
        return builder.toString();
    }
}
