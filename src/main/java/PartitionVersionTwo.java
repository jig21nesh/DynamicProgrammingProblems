import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Jiggy on 22/06/2017.
 */
public class PartitionVersionTwo {
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    public static void main(String[] args) {
        int S[] = {10,20,15,5,25};
        int S1[] = {};
        int S2[] = {};

        PartitionVersionTwo partitionVersionTwo = new PartitionVersionTwo();
        System.out.println(partitionVersionTwo.recurrsion(S, S.length-1, S1, S2));
    }

    private int recurrsion(int[] S, int sizeOfS, int[] S1, int[] S2){

        if(sizeOfS < 0){
            return Math.abs(this.sum(S1) - this.sum(S2));
        }
        String key = "Data | "+sizeOfS;
        if(!table.contains(key)){
            int including  = this.recurrsion(S, sizeOfS - 1, this.merge(S1, S[sizeOfS]), S2);

            int excluding  = this.recurrsion(S, sizeOfS - 1, S1, this.merge(S2, S[sizeOfS]));

            table.put(key, Math.min(including, excluding));
        }
        return table.get(key);
    }

    private int[] merge(int[] S, int temp){
        int returnArray[] = new int[S.length+1];
        for(int index = 0 ; index < S.length ; ++index){
            returnArray[index] = S[index];
        }
        returnArray[S.length] = temp;
        return returnArray;
    }

    private int sum(int[] temp){
        int sum = 0;
        for(int index = 0 ; index < temp.length ; ++index){
            sum += temp[index];
        }
        return sum;
    }
}
