import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by sky on 5/23/15.
 */
public class TopTenUsers {
    private static final int K = 10;
    private List<String> inputFileNames;

    private final class UserCounter {
        private String userId;
        private int count;

        public UserCounter(String userId) {
            this.userId = userId;
            this.count = 1;
        }

        public int increment() {
            return ++count;
        }

        @Override
        public String toString() {
            return "[" + userId + ", " + count + "]";
        }
    }

    public TopTenUsers(List<String> inputFileNames) throws IOException {
        this.inputFileNames = inputFileNames;
        parse();
    }

    private void parse() throws IOException {
        for (String f: inputFileNames)
            parse(f);
    }

    private static void parse(String filename) throws IOException {
        try(Reader in = new FileReader(filename); BufferedReader br = new BufferedReader(in)) {
            String line = null;

            // Format: yyyymmddHHmmss userId message
            while ((line = br.readLine()) != null) {
                if (line.isEmpty())
                    continue;

                int idxStartUserId = line.indexOf(' ');
                int idxEndUserId = line.indexOf(' ', idxStartUserId + 1);

                if (idxStartUserId == -1 || idxEndUserId == -1)
                    continue;


            }

            // BufferedReader will close reader
            br.close();
        }
    }
}
