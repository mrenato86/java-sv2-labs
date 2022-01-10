package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Vote {

    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> votes) {
        Map<VoteResult, Integer> result = new HashMap<>();
        for (VoteResult voteValue : votes.values()) {
            int newSum = result.containsKey(voteValue) ? result.get(voteValue) + 1 : 1;
            result.put(voteValue, newSum);
        }
        return result;
    }

}
