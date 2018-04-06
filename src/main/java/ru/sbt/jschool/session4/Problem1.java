package ru.sbt.jschool.session4;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * @author NIzhikov
 */
public class Problem1 implements Consumer<Character> {
    private int a;
    private int c;
    private int g;
    private int t;

    private void countDNA(String str) {
        str.chars().mapToObj(c -> (char)c).forEach(this);
    }

    @Override public void accept(Character ch) {
        switch (ch) {
            case 'A': a++; break;

            case 'C': c++; break;

            case 'G': g++; break;

            case 'T': t++; break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem1.class.getResourceAsStream("/rosalind_dna.txt"));

        Problem1 p = new Problem1();

        p.countDNA(sc.nextLine());

        System.out.println(p.a + " " + p.c + " " + p.g + " " + p.t);
    }
}
