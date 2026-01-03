public class LC134_GasStation {
    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        System.out.println("Can or Not "+canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCos = 0;
        for (int val : gas) {
            totGas += val;
        }

        for (int val : cost) {
            totCos += val;
        }

        if (totGas < totCos) {
            return -1;
        }


        int start = 0;
        int currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += (gas[i] - cost[i]);
            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }
        return start;
    }
}

