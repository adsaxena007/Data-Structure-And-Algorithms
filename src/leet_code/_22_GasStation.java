package leet_code;

public class _22_GasStation {

    Integer [] memo1;
    public int canComplete(int[] gas, int[] cost, int index, int currentGas, Integer startingIndex) {

        if(startingIndex !=null && index == startingIndex) {
            return startingIndex;
        }

        if(gas[index] + currentGas >= cost[index]){
            if(index + 1 == gas.length){
                if(memo1[0] == null){
                    memo1[0] = canComplete(gas, cost, 0, ((currentGas + gas[index] ) - cost[index] ), startingIndex == null ? index : startingIndex);
                }
                return memo1[0];
            }else {
                if(memo1[index] == null){
                    memo1[index] = canComplete(gas, cost, index+1, ((currentGas + gas[index] ) - cost[index] ), startingIndex == null ? index : startingIndex);
                }
                return memo1[index];
            }
        } else{
            if(memo1[index] == null){
                if(index + 1 == gas.length){
                    memo1[index] = -1;
                    return memo1[index];
                }
                if(startingIndex !=null){
                    memo1[index] = -1;
                    return memo1[index];
                }
                memo1[index] = canComplete(gas, cost, index+1, 0, null);
                return memo1[index];
            }

            return memo1[index];


        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        memo1 = new Integer[gas.length];
        for(int i = 0; i<gas.length; i++){

            if(memo1[i]==null){
                memo1 = new Integer[gas.length];
                int result =  canComplete(gas, cost, i, 0, null);
                if(result == -1)
                    continue;
                else
                    return result;
            }else {
                int result =  memo1[i];
                if(result == -1)
                    continue;
                else
                    return result;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        _22_GasStation obj = new _22_GasStation();

        System.out.println(obj.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(obj.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println(obj.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));

    }
}
