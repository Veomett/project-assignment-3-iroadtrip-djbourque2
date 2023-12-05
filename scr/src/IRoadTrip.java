import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;

public class IRoadTrip {
    String border_txt;//borderfile
    String capdist_csv;//distancefile
    String state_name_tsv;//distancefile

    Hashtable<String, Hashtable<String, Integer>> borders;//double hashtable, wonder if this works

    public IRoadTrip (String [] args) {
        /* 0 = borders.txt
         * 1 = capdist.csv
         * 2 = state_name.tsv */

        borders = new Hashtable<>();
        border_txt = args[0];
        capdist_csv = args[1];
        state_name_tsv = args[2];

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
                name_list.put(getStateID(first[0]), -1 /*this is dist*/);//TODO: fix so not first[0]
            }
            borders.put(key, name_list);
            sHash.close();
        }
        bScan.close();


        Scanner cap_scan = new Scanner(args[1]);//todo:

        Scanner state_scan = new Scanner(args[2]);

    }

    /**
     * takes a country's alternate name and returns the common name of the country
     * @param name
     * @return
     */

    public String getStateID (String name){//also add corrections
        Scanner state = new Scanner(state_name_tsv);
        return null;
            /* Ignore/Weird:
             * Akrotiri
             * American Samoa
             * Andorra????
             * Anguilla
             * Antarctica
             * Antigua and Barbuda
             * Aruba
             * Ashmore and Cartier Islands
             * Austria-Hungary = Hungary
             * Bahamas, The = Bahamas
             * Byelorussia = Belarus (Byelorussia)
             * Bermuda
             * Bosnia = Bosnia-Herzegovina
             * Bouvet Island
             * British Indian Ocean Territory
             * British Virgin Islands
             * Burkina Faso = Burkina Faso (Upper Volta)
             * Burma = Myanmar (Burma) IS MULTI
             * Cabo Verde
             * Cambodia = Cambodia (Kampuchea)
             * Cayman Islands
             * Christmas Island
             * Clipperton Island
             * Cocos (Keeling) Islands
             * Great Columbia not mentioned
             * Congo, Republic of the IS WEIRD
             * Congo, Democratic Republic of (Zaire) IS WEIRD
             * Cook Islands
             * Coral Sea Islands
             * Cote d'Ivoire
             * Curacao
             * Czechia = Czechoslovakia
             * Dhekelia
             * Dominica
             * Egypt IS WEIRD
             * Estonia IS WEIRD
             * Eswatini
             * Falkland Islands (Islas Malvinas)
             * Faroe Islands
             * French Polynesia
             * French Southern and Antarctic Lands
             * Gambia, The = Gambia
             * Gibraltar
             * Greenland
             * Grenada
             * Guam
             * Guernsey
             * Haiti IS WEIRD
             * Heard Island and McDonald Islands
             * Holy See (Vatican City)
             * Hong Kong (boooooooo)
             * Iran = Persia
             * Isle of Man
             * Jan Mayen
             * Jersey
             * Jordan
             * Kiribati
             * Korea, North = Korea, People's Republic of
             * Korea, South = Korea, Republic of
             * Kyrgyzstan
             * Laos
             * Latvia IS WEIRD
             * Libya IS WEIRD
             * Liechtenstein
             * Lithuania IS WEIRD
             * Macau
             * Madagascar IS WEIRD
             * Marshall Islands
             * Micronesia, Federated States of
             * Monaco
             * Montenegro IS WEIRD
             * Montserrat
             * Morocco IS WEIRD
             * Nauru
             * Navassa Island
             * New Caledonia
             * Niue
             * Norfolk Island
             * North Macedonia
             * Northern Mariana Islands
             * Palau
             * Paracel
             * Pitcairn Islands
             * Barthelemy
             * Saint Helena, Ascension, and Tristan da Cunha
             * Saint Kitts and Nevis
             * Saint Lucia
             * Saint Martin
             * Saint Pierre and Miquelon
             * Saint Vincent and the Grenadines
             * Samoa
             * San Marino
             * Sao Tome and Principe
             * Serbia IS WEIRD
             * Seychelles
             * South Georgia and South Sandwich Islands
             * Spratly Islands
             * Suriname
             * Svalbard
             * Tanzania = Tanzania/Tanganyika
             * Timor-Leste
             * Tokelau
             * Tonga
             * Tunisia IS WEIRD
             * Turkey (Turkiye) = Turkey (Ottoman Empire)
             * Turks and Caicos Islands
             * Tuvalu
             * Uganda
             * United States Pacific Island Wildlife Refuges
             * Vanuatu
             * Vietnam = Vietnam, Democratic Republic of
             * Virgin Islands
             * Wake Island
             * Yemen =  Yemen (Arab Republic of Yemen)
             * Zimbabwe = Zimbabwe (Rhodesia)
             */
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

