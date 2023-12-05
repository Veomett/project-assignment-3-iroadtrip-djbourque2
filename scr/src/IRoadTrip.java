import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;

public class IRoadTrip {
    /* wip list of weirdos
     * Akrotiri
     * Algeria
     *
     */
    Hashtable<String, Hashtable<String, Integer>> borders;//double lazy hashtable

    public IRoadTrip (String [] args) {
        /* 0 = borders.txt
         * 1 = capdist.csv
         * 2 = state_name.tsv */

        borders = new Hashtable<>();

        Scanner bScan = new Scanner(args[0]);
        while (bScan.hasNextLine()){
            String line = bScan.next("\n");
            Scanner sHash = new Scanner(line);

            String key = sHash.next("(\\w+) =\\s*");
            Hashtable<String, Integer> name_list = new Hashtable<>();

            while (sHash.hasNext("\\s*km;\\s*")){
                String splitting_str = sHash.next("\\s*km;\\s*");
                String[] first = splitting_str.split("\\s*");
                //TODO: int dist = dist between key and first[0]
                name_list.put(first[0], -1 /*this is dist*/);
            }
            borders.put(key, name_list);
            sHash.close();
        }
        bScan.close();


        Scanner cap_scan = new Scanner(args[1]);//todo:

        Scanner state_scan = new Scanner(args[2]);

    }


    public int getDistance (String country1, String country2) {
        /* Planning:
        * search capdist.csv
        * after 4 commas is km, after 5 commas is miles
        * use km
        */


        return -1;
    }


    public List<String> findPath (String country1, String country2) {

        return null;
    }


    public void acceptUserInput() {
        // Replace with your code
        System.out.println("IRoadTrip - skeleton");
    }


    public static void main(String[] args) {
        IRoadTrip a3 = new IRoadTrip(args);

        a3.acceptUserInput();
    }

}

