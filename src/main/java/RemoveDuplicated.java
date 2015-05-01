import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sky on 28/04/15.
 */
public class RemoveDuplicated {
    public static void main(String[] args) throws Exception {
        Reader in = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(in);

        Writer out = new FileWriter(args[1]);
        BufferedWriter writer = new BufferedWriter(out);

        String line;
        Set<String> set = new HashSet<>();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            // arr[0] = id
            // arr[1] = msisdn

            if (set.contains(arr[1])) {
                String s = "DELETE from tb_mailing_ta_ivr_carga where ROWID = " + arr[0] + ";\r\n";

                writer.write(s);
                writer.write("COMMIT;\r\n");
            } else {
                set.add(arr[1]);
            }
        }

        br.close();
        in.close();

        writer.close();
        out.close();
    }
}
