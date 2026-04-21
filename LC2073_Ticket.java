public class LC2073_Ticket {
    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;

        System.out.println("Time taken: " + timeRequiredToBuy(tickets, k));
    }

    private static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }
        return time;
    }

//    🔑 The Key Insight
//    Instead of simulating the whole queue round-by-round, we use a math trick:
//
//    The queue stops the moment person k buys their last ticket.
//
//    So ask: "How many times does each person get to buy before k is done?"
//
//    Person at index i <= k (same position or before k in line):
//    They get to buy at most target tickets (because they're ahead or at k, so they go before k in each round).

//    Person at index i > k (after k in line):
//    They only get target - 1 turns (because the queue stops when k finishes, and k finishes before they get their turn in the last round).



// Also
//    Why Math.min()?
//    Because a person can't buy more tickets than they want.
//
//    Person B wants 3 but only gets 2 rounds → min(3, 2) = 2
//    If someone wanted only 1 ticket → min(1, 2) = 1 (they leave early)
}
