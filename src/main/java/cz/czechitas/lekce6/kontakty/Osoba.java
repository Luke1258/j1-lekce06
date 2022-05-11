package cz.czechitas.lekce6.kontakty;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Informace o osobě.
 */
public class Osoba {
    private String jmeno;
    private String prijmeni;

    private final Set<String> emaily = new HashSet<>();
    private final Set<String> telefony = new HashSet<>();

    private final List<String> deti = new ArrayList<>();

    public Osoba(String jmeno, String prijmeni) {
        this.jmeno = Objects.requireNonNull(jmeno);
        this.prijmeni = Objects.requireNonNull(prijmeni);
    }

    public void run() {
        pridejEmail("honza@lhota.cz");
        pridejEmail("jan@kralovstvi.cz");
        pridejEmail("kral@kralovstvi.cz");
        System.out.printf("E-maily: %s", String.join(", ", emaily)).println();

        boolean obsahujeEmail = obsahujeEmail("jan@kralovstvi.cz");
        System.out.printf("Obsahuje e-mail 'jan@kralovstvi.cz' %b?", obsahujeEmail).println();

        pridejTelefon("739198456");
        pridejTelefon("800000000");
        pridejTelefon("212345678");
        pridejTelefon("739198456");
        System.out.printf("Telefony poprvé: %s", String.join(", ", telefony)).println();

        odstranTelefon("739198456");
        System.out.printf("Telefony podruhé: %s", String.join(", ", telefony)).println();

        smazVsechnyTelefony();
        System.out.printf("Počet telefonů v seznamu: %d", telefony.size()).println();

        boolean jeSeznamTelefonuPrazdny = jeSeznamTelefonuPrazdny();
        System.out.printf("Je seznam telefonů prázdný? %b", jeSeznamTelefonuPrazdny).println();

        pridejDite("Eliška");
        pridejDite("Eva");
        pridejDite("Edita");
        pridejDite("Ester");
        System.out.printf("Děti: %s", String.join(", ", deti)).println();

        boolean eliska = jeNaSeznamuDite("Eliška");
        System.out.printf("Eliška je na seznamu dětí: %b", eliska).println();

        int edita = kolikateJe("Edita");
        System.out.printf("Edita je na seznamu dětí %d. v pořadí.", edita).println();

        int ema = kolikateJe("Ema");
        System.out.printf("Ema je na seznamu dětí %d. v pořadí.", ema).println();

        vypisDeti();
    }

    //region Metody k implementaci.
    /**
     * Přidá uvedený e-mail do seznamu e-mailů.
     * @param email
     */
    private void pridejEmail(String email) {
        //TODO
        emaily.add(email);
    }

    /**
     * Zjistí, zda seznam e-mailů obsahuje uvedenou hodnotu.
     *
     * @param email
     * @return
     */
    private boolean obsahujeEmail(String email) {
        //TODO
        return emaily.contains(email);
    }

    /**
     * Přidá telefon na seznam telefonů.
     * @param telefon
     */
    private void pridejTelefon(String telefon) {
        //TODO
        telefony.add(telefon);
    }

    /**
     * Odstraní telefon ze seznamu telefonů.
     * @param telefon
     */
    private void odstranTelefon(String telefon) {
        //TODO
        telefony.remove(telefon);
    }

    /**
     * Zjistí, zda je seznam telefonů prázdný.
     */
    private boolean jeSeznamTelefonuPrazdny() {
        //TODO
        return telefony.isEmpty();
    }

    /**
     * Smaže všechny telefony ze seznamu.
     */
    private void smazVsechnyTelefony() {
        //TODO
        telefony.removeAll(telefony);
    }

    /**
     * Přidá do seznamu další dítě.
     * @param jmeno Křestní jméno dítěte.
     */
    private void pridejDite(String jmeno) {
        //TODO
        deti.add(jmeno);
    }

    /**
     * Vrací údaj, zda dané dítě je uvedené v seznamu dětí.
     * @param jmeno Křestní jméno hledaného dítěte.
     * @return
     */
    private boolean jeNaSeznamuDite(String jmeno) {
        //TODO
        return deti.contains(jmeno);
    }

    /**
     * Vrací pořadové číslo, kolikáté je uvedené dítě na seznamu.
     *
     * Vrací pořadí v běžném číslování, tj. první dítě je 1. Pokud dítě na seznamu není, vrací -1.
     *
     * @param jmeno Křestní jméno hledaného dítěte.
     * @return Pořadí dítěte.
     */
    private int kolikateJe(String jmeno) {
        //TODO
        return deti.indexOf(jmeno);
    }

    /**
     * Vypíše jména všech dětí na standardní výstup.
     *
     * Jména dětí jsou vypsána v pořadí, v jakém jsou uvedena v seznamu.
     */
    private void vypisDeti() {
        //TODO bonusový úkol
        for (String dietatko : deti) {
            System.out.println("Zoznam deti: " + dietatko);
        }
        //Pro výpis jednoho dítěte se použije System.out.println()
        //Pro průchod celým seznamem se použije for each cyklus (s dvojtečkou) – po zadání "deti.for" IntelliJ Ieda napoví.
        //Pozor, nejde o metodu forEach()!
    }
    //endregion


    //region Implementace osoby.
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = Objects.requireNonNull(jmeno);
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = Objects.requireNonNull(prijmeni);
    }

    public Set<String> getEmaily() {
        return emaily;
    }

    public Set<String> getTelefony() {
        return telefony;
    }

    public List<String> getDeti() {
        return deti;
    }

    @Override
    public String toString() {
        return jmeno + ' ' + prijmeni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba)) return false;
        Osoba osoba = (Osoba) o;
        return jmeno.equals(osoba.jmeno) && prijmeni.equals(osoba.prijmeni) && emaily.equals(osoba.emaily) && telefony.equals(osoba.telefony) && deti.equals(osoba.deti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmeno, prijmeni, emaily, telefony, deti);
    }

    //endregion
}
