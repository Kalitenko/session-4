package ru.sbt.jschool.session4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author NIzhikov
 */
public class Problem6 {
    private String str;
    private String pattern;

    private List<int[]> possible = new ArrayList<>();

    private List<Integer> occurences = new ArrayList<>();

    public Problem6(String str, String pattern) {
        this.str = str;
        this.pattern = pattern;
    }

    private void findOccurrences() {
        for (int i=0; i<str.length(); i++) {
            Iterator<int[]> iter = possible.iterator();

            while(iter.hasNext()) {
                int[] occur = iter.next();

                if (str.charAt(i) != pattern.charAt(++occur[1]))
                    iter.remove();
                else if (occur[1]+1 == pattern.length()) {
                    occurences.add(occur[0]+1);

                    iter.remove();
                }
            }

            if (str.charAt(i) == pattern.charAt(0))
                possible.add(new int[] {i, 0});
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem6.class.getResourceAsStream("/rosalind_subs.txt"));

        Problem6 p = new Problem6(sc.nextLine(), sc.nextLine());

        p.findOccurrences();

        for (int occurrence : p.occurences)
            System.out.print(occurrence + " ");
    }
}
