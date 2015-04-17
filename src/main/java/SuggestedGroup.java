import java.io.*;
import java.util.*;

/**
 * Created by sky on 4/9/15.
 */
public class SuggestedGroup {
    public static void main(String[] args) throws IOException {
        Reader in;

        if (args.length == 2) {
            in = new FileReader(args[1]);
        } else {
            in = new InputStreamReader(System.in);
        }

        Map<String, List<String>> friendshipGraph = new TreeMap<>();
        Map<String, List<String>> usersGroupGraph = new TreeMap<>();

        BufferedReader br = new BufferedReader(in);

        // Reading the input
        String line;
        while ((line = br.readLine()) != null) {
            String user = null;
            String friends = null;
            String groups = null;

            int idxUser;
            int idxGroups;

            idxUser = line.indexOf(':');
            if (idxUser > 0) {
                user = line.substring(0, idxUser);
            }

            idxGroups = line.lastIndexOf(':');
            if (idxGroups > 0) {
                friends = line.substring(idxUser + 1, idxGroups);
                groups = line.substring(idxGroups + 1);
            }

            if (user == null || friends == null || groups == null) {
                continue;
            }

            String[] friendsArr = friends.split(",");
            String[] groupsArr = groups.split(",");

            friendshipGraph.put(user, Arrays.asList(friendsArr));
            usersGroupGraph.put(user, Arrays.asList(groupsArr));
        }

        // Walking through the graph to identify groups to be suggested
        for (String user: friendshipGraph.keySet()) {
            Set<String> subscribedGroups = new HashSet<>();
            List<String> friendsList = friendshipGraph.get(user);
            Map<String, Integer> freqGroups = new HashMap<>();

            // Creating a set with user' groups
            List<String> subsGroupsList = usersGroupGraph.get(user);
            for (String subscribed: subsGroupsList) {
                subscribedGroups.add(subscribed);
            }

            // Looking at my friends list
            for (String friend: friendsList) {
                List<String> groupList = usersGroupGraph.get(friend);

                // Looking at my friends groups list
                for (String group: groupList) {
                    // Filtering groups that user is already subscribed
                    if (subscribedGroups.contains(group)) {
                        continue;
                    }

                    Integer freq = freqGroups.get(group);
                    if (freq != null) {
                        freq++;
                        freqGroups.put(group, freq);
                    } else {
                        freqGroups.put(group, 1);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(user).append(":");

            int recommended = 0;
            int required = friendsList.size();

            for (String groupName: freqGroups.keySet()) {
                Integer freq = freqGroups.get(groupName);

                // 50% or more
                if (freq >= required) {
                    if (recommended++ > 0) sb.append(",");
                    sb.append(groupName);
                }
            }

            if (recommended > 0)
                System.out.println(sb);
        }

        br.close();
        in.close();
    }
}
