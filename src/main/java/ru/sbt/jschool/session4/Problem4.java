package ru.sbt.jschool.session4;

import java.util.Iterator;
import java.util.Scanner;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

/**
 */
public class Problem4 {
    public long hammingDistance(String str1, String str2) {
        return stream(spliteratorUnknownSize(new TwoStringIterator(str1, str2), ORDERED), false)
            .filter(chs -> chs[0] != chs[1]).count();
    }

    private static class TwoStringIterator implements Iterator<char[]> {
        private String str1;
        private String str2;

        private int idx;

        public TwoStringIterator(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        @Override public boolean hasNext() {
            return str1.length() > idx;
        }

        @Override public char[] next() {
            return new char[] {
                str1.charAt(idx),
                str2.charAt(idx++)
            };
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem4.class.getResourceAsStream("/rosalind_hamm.txt"));

        Problem4 p = new Problem4();

        System.out.println(p.hammingDistance(sc.nextLine(), sc.nextLine()));
    }
}
