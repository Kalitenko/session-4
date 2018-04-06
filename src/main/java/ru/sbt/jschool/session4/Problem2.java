package ru.sbt.jschool.session4;

import java.util.Scanner;

import static java.util.stream.Collectors.joining;

/**
 */
public class Problem2 {
    private String dnaToRna(String dna) {
        return dna.chars().mapToObj(c -> (char)c).map(c -> {
            if (c == 'T')
                return 'U';
            else
                return c;
        }).map(Object::toString).collect(joining());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem2.class.getResourceAsStream("/rosalind_rna.txt"));

        Problem2 p = new Problem2();

        System.out.println(p.dnaToRna(sc.nextLine()));
    }
}
