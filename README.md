# IntervalPartitioning-Scheduling
Algorithm Practice for "CS260 - Algorithms"

Has an implementation and tests for Interval Scheduling and Interval Partitioning problems. Written using Java8, through the use of Comparators (Tuple::getSecond).

## Interval Scheduling
Given a set of Tuples to represent the time in which a job can be completed, this algorithm will calculate a set of jobs which are completely compatible, and is the optimal set, i.e. there is no other ordering which will contain more jobs than this returns. It is a greedy algorithm that orders the set of jobs by finishing times, and then loops through the list, checking if it is compatible with the current last accepted finishing time, and if it is, add it to the optimal set.

This algorithm takes O(n log(n)) time, due to the sorting section, which takes O(n log(n)) time. The following loop takes O(n) time, in order to iterate over all of the jobs in the sorted list, and compare them to the end time of the current latest job. The sorting is asymptopically harder than the comparisons, so there is nothing in the algorithm that impacts the time complexity.

## Interval Partitioning
Similar to the Interval Scheduling algorithm, instead this will schedule all Tuples (Jobs) given to it, in as little "rooms" or venues as possible. The venues themselves have no limit to how many jobs can be scheduled within them. First it orders the jobs by start time, then checks to see if the next job is compatible with one of the rooms we have already. If not, we create a new room and add the job, otherwise we can add it to the first room we have that accepts it. The algorithm then returns the 'depth' which is the amount of rooms that need to be used in order to schedule all events.

The time complexity of this algorithm is O(n log(n)) due to the sorting call, using the comparator, which takes O(n log(n)) time. The following loop takes O(n) time, since it needs to loop through the (now sorted) list of jobs once per job.

### Future Improvements
Modify Interval Partitioning such that it returns the schedule of each room as well as the amount of rooms necessary.
