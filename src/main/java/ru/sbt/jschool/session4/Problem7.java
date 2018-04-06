package ru.sbt.jschool.session4;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.math.RoundingMode.HALF_UP;

/**
 * @author NIzhikov
 */
public class Problem7 {
    private Map<Character, Double> mass = new HashMap<>();

    public Problem7() {
        Scanner sc = new Scanner(Problem7.class.getResourceAsStream("/mass_table.txt"))
            .useDelimiter(Pattern.compile("\\s+"))
            .useLocale(Locale.ENGLISH);

        while (sc.hasNext())
            mass.put(sc.next().charAt(0), sc.nextDouble());
    }

    private BigDecimal mass(String protein) {
        double sum = protein.chars().mapToDouble(c -> mass.get((char)c)).sum();

        return BigDecimal.valueOf(sum).setScale(3, HALF_UP);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Problem7.class.getResourceAsStream("/rosalind_prtm.txt"));

        Problem7 p = new Problem7();

        System.out.print(p.mass(sc.nextLine()));
    }
}
