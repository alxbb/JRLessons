package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg0 = new Zerg();
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        Zerg zerg6 = new Zerg();
        Zerg zerg7 = new Zerg();
        Zerg zerg8 = new Zerg();
        Zerg zerg9 = new Zerg();
        Protos prot0 = new Protos();
        Protos prot1 = new Protos();
        Protos prot2 = new Protos();
        Protos prot3 = new Protos();
        Protos prot4 = new Protos();
        Terran ter0 = new Terran();
        Terran ter1 = new Terran();
        Terran ter2 = new Terran();
        Terran ter3 = new Terran();
        Terran ter4 = new Terran();
        Terran ter5 = new Terran();
        Terran ter6 = new Terran();
        Terran ter7 = new Terran();
        Terran ter8 = new Terran();
        Terran ter9 = new Terran();
        Terran ter10 = new Terran();
        Terran ter11 = new Terran();
        zerg0.name = "Zerg";
        zerg1.name = "Zerg";
        zerg2.name = "Zerg";
        zerg3.name = "Zerg";
        zerg4.name = "Zerg";
        zerg5.name = "Zerg";
        zerg6.name = "Zerg";
        zerg7.name = "Zerg";
        zerg8.name = "Zerg";
        zerg9.name = "Zerg";
        prot0.name = "Prot0";
        prot1.name = "Prot1";
        prot2.name = "Prot2";
        prot3.name = "Prot3";
        prot4.name = "Prot4";
        ter0.name = "Ter0";
        ter1.name = "Ter1";
        ter2.name = "Ter2";
        ter3.name = "Ter3";
        ter4.name = "Ter4";
        ter5.name = "Ter5";
        ter6.name = "Ter6";
        ter7.name = "Ter7";
        ter8.name = "Ter8";
        ter9.name = "Ter9";
        ter10.name = "Ter10";
        ter11.name = "Ter11";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}