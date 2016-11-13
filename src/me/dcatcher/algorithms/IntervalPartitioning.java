package me.dcatcher.algorithms;

import java.util.*;

public class IntervalPartitioning {

    public static int minimumRequired(List<Tuple<Integer, Integer>> events) {
        // Have a priority queue which stores the finish time of the last event in the room
        Queue<Integer> rooms = new PriorityQueue<>();

        // Sort by starting time of events
        events.sort(Comparator.comparing(Tuple::getFirst));

        // Add first element
        rooms.add(events.get(0).getSecond());

        for (int i = 1; i < events.size(); i++) {
            Tuple<Integer, Integer> currentEvent = events.get(i);
            boolean scheduled = false;
            Iterator it = rooms.iterator();
            boolean added = false;
            while(it.hasNext() && !added) {
                Integer room = (Integer) it.next();
                if (currentEvent.getFirst() >= room) {
                    // remove that room from the list
                    rooms.remove(room);
                    // add a new room with currentEvent.getSecond().
                    rooms.add(currentEvent.getSecond());
                    added = true;
                }
            }
            if (!added) {
                // Add to a new room
                rooms.add(currentEvent.getSecond());
            }
        }
        return rooms.size();
    }

    public static void test() {
        List<Tuple<Integer, Integer>> events = new ArrayList<>();
        events.add(new Tuple<>(5, 8)); // 'd'
        events.add(new Tuple<>(1, 8)); // 'b'
        events.add(new Tuple<>(11, 16)); // 'h'
        events.add(new Tuple<>(9, 12)); // 'g'
        events.add(new Tuple<>(13, 16)); // 'j'
        events.add(new Tuple<>(1, 4)); // 'a'
        events.add(new Tuple<>(13, 16)); // 'i'
        events.add(new Tuple<>(1, 4)); // 'c'
        events.add(new Tuple<>(9, 12)); // 'f'
        events.add(new Tuple<>(5, 11)); // 'e'

        // Should return True
        System.out.println(3 == IntervalPartitioning.minimumRequired(events));
    }
}
