import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetCommentedXml {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: <traps.xml>");
            System.exit(1);
        }

        List<String> alarms = new ArrayList<>();

        try (Reader in = new FileReader(args[0]); BufferedReader br = new BufferedReader(in)) {
            String line = null;
            StringBuilder sb = null;
            boolean beginComment = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("<!--")) {
                    sb = new StringBuilder();
                    int idx = line.indexOf("<!--");
                    sb.append(line.substring(idx));
                    beginComment = true;
                    continue;
                }
                if (line.contains("-->")) {
                    if (sb == null) continue;

                    int idx = line.indexOf("-->");
                    sb.append(line.substring(0, idx + 3));

                    String t = sb.toString();

                    if (t.contains("<alarm id="))
                        alarms.add(t);

                    sb = new StringBuilder();
                    beginComment = false;
                    continue;
                }

                if (beginComment)
                    sb.append(line);
            }

            br.close();
        }

        Set<String> alarmSet = new HashSet<>();

        for (String s: alarms) {
            int b = 0;
            int idx;

            while ((idx = s.indexOf("<alarm id=", b)) > 0) {
                int e = s.indexOf("severity", idx);
                alarmSet.add(".1.3.6.1.4.1.140.627.0." + s.substring(idx + 11, e - 2));
                b = e;
            }
        }

        try (XSSFWorkbook wb = new XSSFWorkbook(args[1])) {
            XSSFSheet ws = wb.getSheet("Tabela CNGR");

            for (int i = 0; i < ws.getLastRowNum(); i++) {
                XSSFRow row = ws.getRow(i);
                XSSFCell cell = row.getCell(5);

                String trapID = cell.toString();

                if (alarmSet.contains(trapID)) {
                    System.out.println(trapID);

                    XSSFCell cellComment = row.getCell(27);
                    cellComment.setCellValue("Alarme desativado");
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream("/tmp/workbook.xlsx")) {
                wb.write(fileOut);
                fileOut.close();
            }

            wb.close();
        }
    }
}
