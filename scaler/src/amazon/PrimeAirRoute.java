package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeAirRoute {

    public static void main(String[] args) {
        // sample input
        System.out.println(getIdPairsForOptimal(
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000),
                        Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 9000), Arrays.asList(3, 5000)), 10000));
    }

    static List<List<Integer>> forwardList;
    static List<List<Integer>> backwardList;
    public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardlist,
                                                           List<List<Integer>> backwardlist, int maxDistance) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        forwardList = forwardlist.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
                .collect(Collectors.toList());
        backwardList = backwardlist.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
                .collect(Collectors.toList());
        int maxDist = maxDistance;
        int bend= backwardList.size();
        int fend= forwardList.size();

        int ans = -1;

        Item item = new Item(0,0);

        Queue<Item> queue = new PriorityQueue<>();

        queue.add(item);

        Set<Item> set = new HashSet<>();
        while(!queue.isEmpty() && queue.peek().sum>maxDist){
            Item curr = queue.poll();
            List<Integer> a = curr.a;
            List<Integer> b = curr.b;

            int i=curr.i;
            int j=curr.j;


            if(i+1<fend){
                Item nexta = new Item(i + 1, j);
                if(!set.contains(nexta)){
                    queue.add(nexta);
                    set.add(nexta);
                }
            }
            if(j+1<bend){
                Item nextb = new Item(i , j+1);
                if(!set.contains(nextb)) {
                    queue.add(nextb);
                    set.add(nextb);
                }
            }

        }

        int max = queue.peek().sum;
        while(!queue.isEmpty() && queue.peek().sum==max){
            Item curr = queue.poll();
            List<Integer> a = curr.a;
            List<Integer> b = curr.b;
            result.add(Arrays.asList(a.get(0),b.get(0)));
        }

        return result;
    }


    static class Item implements Comparable<Item>{
        int sum;
        int i;
        int j;
        List<Integer> a;
        List<Integer> b;

        public Item(int i, int j) {
            this.i=i;
            this.j=j;
            this.a = forwardList.get(i);
            this.b = backwardList.get(j);
            sum = a.get(1)+b.get(1);
        }

        @Override
        public int compareTo(Item other) {
            return Integer.compare(other.sum,this.sum);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return i == item.i && j == item.j ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}

// brute force- check for all pairs
// can 2-pointer work here, if array is sorted
// optimise : can use heap, think why or why not can use heap,
