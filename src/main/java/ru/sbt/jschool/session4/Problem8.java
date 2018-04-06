package ru.sbt.jschool.session4;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Problem8 {
    private List<List<Long>> variants = new LinkedList<>();

    private List<List<Long>> gen0(List<Long> tail) {
        if (tail.size() == 1) {
            List<List<Long>> res = new LinkedList<>();

            List<Long> tailClone = new LinkedList<>();
            tailClone.add(tail.get(0));

            res.add(tailClone);

            return res;
        } else {
            List<List<Long>> res = new LinkedList<>();

            for (int i=0; i<tail.size(); i++) {
                Long head = tail.remove(i);

                List<List<Long>> res0 = gen0(tail);

                for (List<Long> r : res0) {
                    r.add(0, head);

                    res.add(r);
                }

                tail.add(i, head);
            }

            return res;
        }
    }

    private void generate(int num) {
        List<Long> source = new LinkedList<>();

        for (long i=1; i<=num; i++)
            source.add(i);

        variants = gen0(source);
    }

    public static void main(String[] args) {
        Problem8 p = new Problem8();

        p.generate(7);

        System.out.println(p.variants.size());

        for (List<Long> variant : p.variants) {
            for (long v : variant)
                System.out.print(v + " ");

            System.out.println();
        }
    }
}
