package PH;
public class Parkhaus {


    private int etagen;
    private int parkplaetzeProEtage;
    private Fahrzeug[][] parkplaetze;

    public Parkhaus(int etagen, int parkplaetzeProEtage) {
        this.etagen = etagen;
        this.parkplaetzeProEtage = parkplaetzeProEtage;
        this.parkplaetze = new Fahrzeug[etagen][parkplaetzeProEtage];
    }

    public boolean hatFreieParkplaetze() {
        for (int i = 0; i < etagen; i++) {
            for (int j = 0; j < parkplaetzeProEtage; j++) {
                if (parkplaetze[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findeFreienParkplatz() {
        for (int i = 0; i < etagen; i++) {
            for (int j = 0; j < parkplaetzeProEtage; j++) {
                if (parkplaetze[i][j] == null) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public void freieParkplaetzeAusgeben() {
        System.out.println("Freie Parkplätze:");
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                if (parkplaetze[etage][parkplatz] == null) {
                    System.out.printf("Etage %d, Parkplatz %d%n", etage+1, parkplatz+1);
                }
            }
        }
    }
    public boolean parken(Fahrzeug fahrzeug) {
        if (hatFreieParkplaetze()) {
            for (int i = 0; i < etagen; i++) {
                for (int j = 0; j < parkplaetzeProEtage; j++) {
                    if (parkplaetze[i][j] != null && parkplaetze[i][j].getId().equals(fahrzeug.getId())) {

                        return false;
                    }
                }
            }

            for (int i = 0; i < etagen; i++) {
                for (int j = 0; j < parkplaetzeProEtage; j++) {
                    if (parkplaetze[i][j] == null) {
                        parkplaetze[i][j] = fahrzeug;

                        System.out.println("Das Fahrzeug mit Kennzeichen \"" + fahrzeug.getId() + "\" wurde auf Etage " + (i+1) + " Parkplatz " + (j+1) + " geparkt.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void ausfahren(String kennzeichen) {
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                Fahrzeug fahrzeug = parkplaetze[etage][parkplatz];
                if (fahrzeug != null && fahrzeug.getId().equals(kennzeichen)) {
                    parkplaetze[etage][parkplatz] = null;
                    System.out.printf("Das Fahrzeug mit Kennzeichen \"%s\" wurde ausgefahren.%n", kennzeichen);
                    return;
                }
            }
        }
        System.out.printf("Das Fahrzeug mit Kennzeichen \"%s\" wurde nicht gefunden.%n", kennzeichen);
    }

    public void setEtagen(int neueEtagenAnzahl, int neueParkplaetzeProEtage) {

        Fahrzeug[][] neueParkplaetze = new Fahrzeug[neueEtagenAnzahl][neueParkplaetzeProEtage];

        int etagen = Math.min(this.etagen, neueEtagenAnzahl);
        int parkplaetzeProEtage = Math.min(this.parkplaetzeProEtage, neueParkplaetzeProEtage);
        for (int etage = 0; etage < etagen; etage++) {
            System.arraycopy(parkplaetze[etage], 0, neueParkplaetze[etage], 0, parkplaetzeProEtage);
        }

        this.parkplaetze = neueParkplaetze;
        this.etagen = neueEtagenAnzahl;
        this.parkplaetzeProEtage = neueParkplaetzeProEtage;
    }



    public int getParkplaetzeProEtage() {
        int freieParkplaetze = 0;
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                if (parkplaetze[etage][parkplatz] == null) {
                    freieParkplaetze++;
                }
            }
        }
        return freieParkplaetze;
    }

    public void setParkplaetzeProEtage(int neueAnzahl) {
        this.parkplaetzeProEtage = neueAnzahl;
    }




    public void alleParkplaetzeAusgeben() {
        for (int etage = 0; etage < etagen; etage++) {
            System.out.println("Etage: " + (etage + 1));
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                System.out.print("p" + (parkplatz + 1) + ": ");
                if (parkplaetze[etage][parkplatz] == null) {
                    System.out.print("frei");
                } else {
                    System.out.print("belegt: id=" + parkplaetze[etage][parkplatz].getId()
                            + ", Typ=" + parkplaetze[etage][parkplatz].getTyp());
                }
                System.out.println();
            }
        }
    }

    public int[] findeParkplatzNr(String kennzeichen) {
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                Fahrzeug fahrzeug = parkplaetze[etage][parkplatz];
                if (fahrzeug != null && fahrzeug.getId().equals(kennzeichen)) {
                    int[] position = new int[]{etage + 1, parkplatz + 1};
                    System.out.printf("Das Fahrzeug mit Kennzeichen \"%s\" steht auf Etage %d Parkplatz %d.%n", kennzeichen, position[0], position[1]);
                    return position;
                }
            }
        }
        System.out.printf("Das Fahrzeug mit Kennzeichen \"%s\" wurde nicht gefunden.%n", kennzeichen);
        return null;
    }





    /*Mit Kennzeichengenerator


        public boolean parken(Fahrzeug fahrzeug, int etage, int parkplatz) {
            if (hatFreieParkplaetze() && parkplaetze[etage][parkplatz] == null) {
                parkplaetze[etage][parkplatz] = fahrzeug;
                return true;
            } else {
                return false;
            }
        }

        public void ausfahren(int etage, int parkplatz) {
            parkplaetze[etage][parkplatz] = null;
        }


        public void alleParkplaetzeAusgeben() {

            for (int etage = 0; etage < etagen; etage++) {
                System.out.println("Etage: " + (etage + 1));
                for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                    String status;
                    Fahrzeug fahrzeug = parkplaetze[etage][parkplatz];
                    if (fahrzeug == null) {
                        status = "frei";
                    } else {
                        status = "belegt: " + " id: " + fahrzeug.getKennzeichen()+" "+ fahrzeug.getTyp()  ;
                    }
                    System.out.println(" p" + (parkplatz + 1) + ": " + status);
                }
            }
        }
        */
/*
    public int[] findeParkplatzNr(String kennzeichen) {
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                Fahrzeug fahrzeug = parkplaetze[etage][parkplatz];
                if (fahrzeug != null && fahrzeug.getKennzeichen().equals(kennzeichen)) {
                    return new int[]{etage, parkplatz};
                }
            }
        }
        return null; // Kennzeichen wurde nicht gefunden
    }
    */
/*
    public int findParkplatzByKennzeichen(String kennzeichen) {
        for (int etage = 0; etage < etagen; etage++) {
            for (int parkplatz = 0; parkplatz < parkplaetzeProEtage; parkplatz++) {
                Fahrzeug fahrzeug = parkplaetze[etage][parkplatz];
                if (fahrzeug != null && fahrzeug.getKennzeichen().equals(kennzeichen)) {
                    return parkplatz + 1 + etage * parkplaetzeProEtage;
                }
            }
        }
        return -1;
    }
  */

}
