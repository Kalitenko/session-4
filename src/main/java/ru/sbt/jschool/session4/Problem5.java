package ru.sbt.jschool.session4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.Collectors.joining;
import static java.util.stream.StreamSupport.stream;

/**
 */
public class Problem5 {
    private Map<String, String> codonTable = new HashMap<>();

    public Problem5() {
        Scanner sc = new Scanner(Problem5.class.getResourceAsStream("/RNA_codon_table.txt"))
            .useDelimiter(Pattern.compile("\\s+"));

        while(sc.hasNext())
            codonTable.put(sc.next(), sc.next());
    }

    private String rnaToProtein(String rna) {
        return stream(spliteratorUnknownSize(new TripleIterator(rna), ORDERED), false)
            .takeWhile(r -> !codonTable.get(r).equals("Stop"))
            .map(r -> codonTable.get(r))
            .collect(joining());
    }

    private static class TripleIterator implements Iterator<String> {
        private String str;

        private int idx;

        public TripleIterator(String str) {
            this.str = str;
        }

        @Override public boolean hasNext() {
            return str.length() > idx;
        }

        @Override public String next() {
            idx += 3;

            return str.substring(idx-3, idx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem5.class.getResourceAsStream("/rosalind_prot.txt"));

        Problem5 p = new Problem5();

        System.out.println(p.rnaToProtein(sc.nextLine()));
    }
}
