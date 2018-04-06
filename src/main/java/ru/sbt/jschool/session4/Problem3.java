package ru.sbt.jschool.session4;

import java.util.Scanner;

import static java.util.stream.Collectors.joining;

/**
 */
public class Problem3 {
    private String reverseComplement(String dna) {
        return new StringBuilder(dna).reverse().chars().mapToObj(c -> (char)c).map(c -> {
            switch (c) {
                case 'G': return 'C';
                case 'C': return 'G';
                case 'T': return 'A';
                case 'A': return 'T';
                default: return c;
            }
        }).map(Object::toString).collect(joining());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem3.class.getResourceAsStream("/rosalind_revc.txt"));

        Problem3 p = new Problem3();

        System.out.println(p.reverseComplement(sc.nextLine()));
    }
}
