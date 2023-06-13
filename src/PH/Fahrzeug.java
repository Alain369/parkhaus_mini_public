package PH;
public class Fahrzeug {
    private String id;
    private FahrzeugTyp typ;

    public Fahrzeug(String id, FahrzeugTyp typ) {
        this.id = id;
        this.typ = typ;
    }

    public String getId() {
        return id;
    }

    public FahrzeugTyp getTyp() {
        return typ;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTyp(FahrzeugTyp typ) {
        this.typ = typ;
    }
}




/* mitautomatischem kennzeichengenerator

import tools.kennzeichengen;

public class Fahrzeug {
    private String id;
    private FahrzeugTyp typ;
    private kennzeichengen kennzeichenGenerator = new kennzeichengen();


    public Fahrzeug(FahrzeugTyp typ) {
        this.id = kennzeichenGenerator.generiereKennzeichen();
        this.typ = typ;
    }

    public String getKennzeichen() {
        return id;
    }

    public FahrzeugTyp getTyp() {
        return typ;
    }

    public Fahrzeug(String typ) {
        if (typ.equalsIgnoreCase("auto")) {
            this.typ = FahrzeugTyp.AUTO;
        } else if (typ.equalsIgnoreCase("motorrad")) {
            this.typ = FahrzeugTyp.MOTORRAD;
        } else {
            // Fehlerbehandlung: Wenn der Typ nicht erkannt wird, wird eine Exception geworfen.
            throw new IllegalArgumentException("Ungültiger Fahrzeugtyp: " + typ);
        }
        this.id = kennzeichenGenerator.generiereKennzeichen();
    }

}*/


