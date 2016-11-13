package me.dcatcher.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntervalScheduling {

    // Earliest Finish Time First (EFTF) greedy algorithm
    public static List<Tuple<Integer, Integer>> schedule(List<Tuple<Integer, Integer>> jobs) {
        List<Tuple<Integer, Integer>> optimalJobs = new ArrayList<>();

        // Sort the list of jobs by finishing times (second value)
        jobs.sort(Comparator.comparing(Tuple::getSecond));

        // Maintain 'position' of last job added to list
        int a = 0;

        // First job always added
        optimalJobs.add(jobs.get(0));

        for (int i = 1; i < jobs.size(); i++) {
            Tuple<Integer, Integer> currentJob = jobs.get(i);
            if (jobs.get(i).getFirst() >= jobs.get(a).getSecond()) {
                // Add Job i to optimals
                optimalJobs.add(currentJob);
                a = i;
            }
        }
        return optimalJobs;
    }

    public static void test() {
        List<Tuple<Integer,Integer>> lst = new ArrayList<>();
        // Add some 'random' tuples to test algorithm
        lst.add(new Tuple<>(8, 10));
        lst.add(new Tuple<>(14, 17));
        lst.add(new Tuple<>(3, 6));
        lst.add(new Tuple<>(1, 2));
        lst.add(new Tuple<>(15, 16));
        lst.add(new Tuple<>(5, 7));
        lst.add(new Tuple<>(9, 13));
        lst.add(new Tuple<>(1, 4));
        lst.add(new Tuple<>(1,12));

        List<Tuple<Integer, Integer>> optimals = IntervalScheduling.schedule(lst);
        // Should output {1, 2}, {3, 6}, {8, 10}, {15, 16}
        for(Tuple<Integer, Integer> current : optimals) {
            System.out.println(current.toString());
        }

    }
}
