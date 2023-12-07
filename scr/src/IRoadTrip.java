import java.util.*;

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

            String key = getStateID(sHash.next("(\\w+) =\\s*"));
            Hashtable<String, Integer> name_list = new Hashtable<>();

            while (sHash.hasNext("\\s*km;\\s*")){
                String splitting_str = sHash.next("\\s*km;\\s*");
                String[] first = splitting_str.split("\\s*");
                String stID = getStateID(first[0]);

                int dist = getDistance(key,stID);
                name_list.put(stID, dist);//TODO: fix so not first[0]
            }
            borders.put(key, name_list);
            sHash.close();
        }
        bScan.close();
    }

    /**
     * takes a country's alternate name and returns the common name of the country
     * @param name
     * @return
     */

    public String getStateID (String name){//also add corrections
        Scanner state = new Scanner(state_name_tsv);
        String ret = "";
        boolean flag = true;
        while ((flag)&&(state.hasNextLine())){
            String curr_line = state.nextLine();
            if (curr_line.contains(name)){// include correction function; state id = 456
                ret = curr_line.substring(4,6);
                flag = false;
            }
        }
        state.close();

        return nameCorrection(ret);
            /* Ignore/Weird:
             * Akrotiri;
             * American Samoa;
             * Andorra;
             * Anguilla;
             * Antarctica;
             * Antigua and Barbuda;
             * Aruba;
             * Ashmore and Cartier Islands;
             * Austria-Hungary = Hungary;
             * Bahamas, The = Bahamas;
             * Byelorussia = Belarus (Byelorussia);
             * Bermuda;
             * Bosnia = Bosnia-Herzegovina;
             * Bouvet Island;
             * British Indian Ocean Territory;
             * British Virgin Islands;
             * Burkina Faso = Burkina Faso (Upper Volta);
             * Burma = Myanmar (Burma) IS MULTI;
             * Cabo Verde;
             * Cambodia = Cambodia (Kampuchea);
             * Cayman Islands;
             * Christmas Island;
             * Clipperton Island;
             * Cocos (Keeling) Islands;
             * Great Columbia not mentioned;
             * Congo, Republic of the IS WEIRD;
             * Congo, Democratic Republic of (Zaire) IS WEIRD;
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
             * Gambia, The = Gambia;
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

    public String nameCorrection(String name){
        String ret = name;
        if (name.equals("Hungary")){//Austria-Hungary = Hungary
            ret = "Austria-Hungary";
        }
        if (name.equals("Bahamas, The")){//Bahamas, The = Bahamas
            ret = "Bahamas";
        }
        if (name.equals("Byelorussia")){//Byelorussia = Belarus (Byelorussia)
            ret = "Belarus (Byelorussia)";
        }
        if (name.equals("Bosnia")){//Bosnia = Bosnia-Herzegovina
            ret = "Bosnia-Herzegovina";
        }
        if (name.equals("urkina Faso")){//Burkina Faso = Burkina Faso (Upper Volta)
            ret = "Burkina Faso (Upper Volta)";
        }
        if (name.equals("Burma")){//Burma = Myanmar (Burma)
            ret = "Myanmar (Burma)";
        }
        if (name.equals("Cambodia")){//Cambodia = Cambodia (Kampuchea)
            ret = "Cambodia (Kampuchea)";
        }
        if (name.equals("Congo, Democratic Republic of")){//Congo, Democratic Republic of (Zaire)
            ret = "Congo, Democratic Republic of (Zaire)";
        }
        if (name.equals("Congo")){//Congo
            ret = "Congo, Republic of the";
        }
        if (name.equals("Czechia")){//Czechia = Czechoslovakia
            ret = "Czechoslovakia";
        }
        if (name.equals("Gambia, The")){//Gambia, The = Gambia
            ret = "Gambia";
        }
        if (name.equals("Iran")){//Iran = Persia
            ret = "Iran (Persia)";
        }
        if (name.equals("Korea, North")){//Korea, North = Korea, People's Republic of
            ret = "Korea, People's Republic of";
        }
        if (name.equals("Korea, South")){//Korea, South = Korea, Republic of
            ret = "Korea, Republic of";
        }
        if (name.equals("Tanzania")){//Tanzania = Tanzania/Tanganyika
            ret = "Tanzania/Tanganyika";
        }
        if (name.equals("Turkey (Turkiye)")){//Turkey (Turkiye) = Turkey (Ottoman Empire)
            ret = "Turkey (Ottoman Empire)";
        }
        if (name.equals("Vietnam")){//Vietnam = Vietnam, Democratic Republic of
            ret = "Vietnam, Democratic Republic of";
        }
        if (name.equals("Yemen")){//Yemen =  Yemen (Arab Republic of Yemen)
            ret = "Yemen (Arab Republic of Yemen)";
        }
        if (name.equals("Zimbabwe")){//Zimbabwe = Zimbabwe (Rhodesia)
            ret = "Zimbabwe (Rhodesia)";
        }
        return ret;
    }

    public int getDistance (String country1, String country2) {
        /* Planning:
        * search capdist.csv
        * after 4 commas is km, after 5 commas is miles
        * use km
        */
        Scanner cap_scan = new Scanner(capdist_csv);
        int ret = 0;
        boolean flag = true;
        while((flag)&&(cap_scan.hasNextLine())){
            String curr_line = cap_scan.nextLine();
            if ((curr_line.contains(country1)) && (curr_line.contains(country2))){
                Scanner find_dist = new Scanner(curr_line);
                find_dist.nextInt(); //this is to get past the first number;
                ret = find_dist.nextInt();
                flag = false;
                find_dist.close();
            }
        }
        cap_scan.close();
        return ret;
    }


    public List<String> findPath (String country1, String country2) {//is not complete, could not finish
        Hashtable<String, Boolean> isVisited = new Hashtable<>();
        List<String> ret = new ArrayList<>();
        isVisited.put(country1,true);

        Enumeration<String> c1_b = borders.get(country1).keys();
        while (c1_b.hasMoreElements()){
            int[] temp_dists;
            String curr = c1_b.nextElement();
            if (!isVisited.contains(curr)){//TODO: fix so that: "... or (isVisited.get(curr)==false)" such that an exception is not hit

            }
        }

        return null;
    }


    public void acceptUserInput() {//could not complete
        // Replace with your code
        System.out.println("IRoadTrip - skeleton");
    }


    public static void main(String[] args) {
        IRoadTrip a3 = new IRoadTrip(args);

        a3.acceptUserInput();
    }

}

