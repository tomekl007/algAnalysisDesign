package ch4_sortingAndSearching;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class InterviewProblems {

    public static List<Pair> sortBucket(List<Pair> pairs){   //n complexity, because one iteration
        Map<String, List<Pair>> map = new LinkedHashMap<>();
        for (Pair pair : pairs) {
            List<Pair> pairList = map.get(pair.getColorName());
            addPairToMap(map, pair, pairList);
        }

        LinkedList<Pair> sortedPair = new LinkedList<>();
        for(Map.Entry<String, List<Pair>> entry : map.entrySet()){
            entry.getValue().stream().forEach(sortedPair::add);
        }

        return sortedPair;
    }

    private static void addPairToMap(Map<String, List<Pair>> map, Pair pair, List<Pair> pairList) {
        if(pairList == null){
            pairList= new LinkedList<>();
        }
        pairList.add(pair);
        map.put(pair.getColorName(), pairList);
    }


}
