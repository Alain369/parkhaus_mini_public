package PH;


public class test {
    public static void main(String[] args) {


        // Parkhaus mit 4 Etagen und 5 Parkplätzen pro Etage erstellen
        Parkhaus parkhaus = new Parkhaus(4, 5);

        //Parkhaus nachträglich verändern* aktuell kann setParkplaetzProEtage() nicht größer werden als die alte zahl. wenn man mehr parkplätze braucht muss man die setEtage nutzen

        parkhaus.setEtagen(5,31);
        parkhaus.setParkplaetzeProEtage(5);

        // Drei Fahrzeuge erstellen zum testen
        Fahrzeug fahrzeug1 = new Fahrzeug("AB-123", FahrzeugTyp.AUTO);
        Fahrzeug fahrzeug2 = new Fahrzeug("CD-456", FahrzeugTyp.MOTORRAD);
        Fahrzeug fahrzeug3 = new Fahrzeug("EF-789", FahrzeugTyp.AUTO);

        // Alle Parkplätze ausgeben
        parkhaus.alleParkplaetzeAusgeben();

        // Fahrzeuge im Parkhaus parken
        parkhaus.parken(fahrzeug1);
        parkhaus.parken(fahrzeug2);
        parkhaus.parken(fahrzeug3);

        // Alle Parkplätze erneut ausgeben
        parkhaus.alleParkplaetzeAusgeben();

        // Nach Parkplatzposition von einem Fahrzeug suchen
        int[] position = parkhaus.findeParkplatzNr("AB-123");

        parkhaus.ausfahren("AB-123");

        parkhaus.freieParkplaetzeAusgeben();


    }
}
