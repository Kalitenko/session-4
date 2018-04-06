package ru.sbt.jschool.session4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author NIzhikov
 */
public class Problem9 {
    private List<String> variants = new ArrayList<>();

    private void generate(List<String> alphabet, int cnt) {
        variants = gen0(alphabet, cnt);
    }

    private List<String> gen0(List<String> alphabet, int cnt) {
        if (cnt == 1) {
            List<String> res = new ArrayList<>();

            res.addAll(alphabet);

            return res;

        } else {
            List<String> res = new ArrayList<>();

            for (int i=0; i<alphabet.size(); i++) {
                String first = alphabet.get(i);

                List<String> res0 = gen0(alphabet, cnt-1);

                for (String r : res0)
                    res.add(first + r);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem9.class.getResourceAsStream("/rosalind_lexf.txt"));

        Problem9 p = new Problem9();

        String[] alphabet = sc.nextLine().split(" ");

        Arrays.sort(alphabet);

        p.generate(Arrays.asList(alphabet), sc.nextInt());

        for (String variant : p.variants)
            System.out.println(variant);
    }
}
