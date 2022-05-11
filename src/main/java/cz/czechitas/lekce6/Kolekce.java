package cz.czechitas.lekce6;

import java.util.*;

public class Kolekce {
    private List<String> seznamJmen = new ArrayList<>();
    private List<Integer> seznamCisel = new LinkedList<>();

    private Set<String> dnyVTydnu = new HashSet<>();

    public static void main(String[] args) {
        new Kolekce().test();
    }

    public void test() {
        seznamJmen.add("Eva");
        seznamJmen.add("Marie");
        seznamJmen.add("Jolana");
        seznamJmen.add("Tamara");
/*
        seznamJmen.remove("Marie");
        seznamJmen.remove(0);

        for (int i = 0; i < seznamJmen.size(); i++) {
            String jmeno = seznamJmen.get(i);
            System.out.println(jmeno);
        }
*/
        for (String jmeno : seznamJmen) {
            System.out.println(jmeno);
        }

        dnyVTydnu.add("pondělí");
        dnyVTydnu.add("úterý");
        dnyVTydnu.add("středa");
        dnyVTydnu.add("čtvrtek");
        dnyVTydnu.add("pátek");
        dnyVTydnu.add("sobota");
        dnyVTydnu.add("neděle");

        for (String den : dnyVTydnu) {
            System.out.println(den);
        }
    }

}