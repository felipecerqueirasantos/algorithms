import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 13/05/15.
 */
public class CombineFirewallRulesTimOCSG {
    public static final class Host {
        private String host;
        private String ip;
        public Host(String host, String ip) {
            this.host = host;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return "[Host: " + host + ", " + ip + "]";
        }
    }

    public static enum Protocol {
        TCP, UDP;
    }

    public static final class Service {
        private int port;
        private String desc;
        private Protocol protocol;

        public Service(int port, Protocol protocol, String desc) {
            this.port = port;
            this.protocol = protocol;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "[Service: " + port + " (tcp), desc" + desc + "]";
        }
    }

    public static void combine(String description, List<Host> sources, List<Host> destinations, List<Service> services) {
        System.out.println(description);

        for (Host s: sources) {
            for (Host d: destinations) {
                for (Service service: services) {
                    System.out.println(s.host + ","  + s.ip + "," + d.host + "," + d.ip + "," +
                            service.port + " " + service.protocol + "," + service.desc);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Host> apaches = new ArrayList<>();
        apaches.add(new Host("SNELNXL01", "10.169.31.179"));
        apaches.add(new Host("OCSGATWEB01", "10.169.31.180"));
        apaches.add(new Host("SNELNXL02", "10.169.31.181"));
        apaches.add(new Host("OCSGATWEB02", "10.169.31.182"));

        List<Host> ats = new ArrayList<>();
        ats.add(new Host("SNELNXL03", "10.160.2.89"));
        ats.add(new Host("OCSGAT01", "10.160.2.90"));

        ats.add(new Host("SNELNXL04", "10.160.2.91"));
        ats.add(new Host("OCSGAT02", "10.160.2.92"));

        ats.add(new Host("SNELNXL05", "10.160.2.93"));
        ats.add(new Host("OCSGAT03", "10.160.2.94"));

        ats.add(new Host("SNELNXL06", "10.160.2.95"));
        ats.add(new Host("OCSGAT04", "10.160.2.96"));

        List<Host> nts = new ArrayList<>();
        nts.add(new Host("SNELNXL07", "10.161.3.156"));
        nts.add(new Host("OCSGNT01", "10.161.3.157"));

        nts.add(new Host("SNELNXL08", "10.161.3.158"));
        nts.add(new Host("OCSGNT02", "10.161.3.159"));

        nts.add(new Host("SNELNXL09", "10.161.3.160"));
        nts.add(new Host("OCSGNT03", "10.161.3.161"));

        nts.add(new Host("SNELNXL10", "10.161.3.162"));
        nts.add(new Host("OCSGNT04", "10.161.3.163"));

        List<Host> consoles = new ArrayList<>();
        consoles.add(new Host("SNELNXL03", "10.160.2.89"));
        consoles.add(new Host("OCSGAT01", "10.160.2.90"));

        List<Host> portals = new ArrayList<>();
        portals.add(new Host("SNELNXL11", "10.160.2.97"));
        portals.add(new Host("OCSGPT01", "10.160.2.98"));
        portals.add(new Host("SNELNXL12", "10.160.2.99"));
        portals.add(new Host("OCSGPT02", "10.160.2.100"));

        List<Host> reports = new ArrayList<>();
        reports.add(new Host("SNELNXL13", "10.160.2.101"));
        reports.add(new Host("OCSGRPT01", "10.160.2.102"));
        reports.add(new Host("SNELNXL14", "10.160.2.103"));
        reports.add(new Host("OCSGRPT02", "10.160.2.104"));

        List<Host> databasesReport = new ArrayList<>();
        databasesReport.add(new Host("SNELNXL16", "10.161.4.146"));


        // Services
        Service httpService = new Service(8080, Protocol.TCP, "HTTP/Webservices");
        Service nodeManagerService = new Service(5556, Protocol.TCP, "CharNode manager");
        Service consoleService = new Service(7000, Protocol.TCP, "CharNode manager");
        Service databaseService = new Service(1521, Protocol.TCP, "Oracle listener");

        List<Service> apacheVsAts = new ArrayList<>();
        apacheVsAts.add(httpService);

        List<Service> atsVsNts = new ArrayList<>();
        atsVsNts.add(httpService);

        List<Service> ntsVsAts = new ArrayList<>();
        ntsVsAts.add(httpService);

        List<Service> consoleVsNts = new ArrayList<>();
        consoleVsNts.add(nodeManagerService);

        List<Service> consoleVsPortals = new ArrayList<>();
        consoleVsPortals.add(nodeManagerService);

        List<Service> ntsVsConsoles = new ArrayList<>();
        ntsVsConsoles.add(consoleService);

        List<Service> portalsVsConsoles = new ArrayList<>();
        portalsVsConsoles.add(consoleService);

        List<Service> portalsVsNts = new ArrayList<>();
        portalsVsNts.add(httpService);

        List<Service> reportsVsNts = new ArrayList<>();
        reportsVsNts.add(httpService);

        List<Service> reportsVsOracleSingle = new ArrayList<>();
        reportsVsOracleSingle.add(databaseService);

        combine("Apache vs ATS", apaches, ats, apacheVsAts);
        combine("ATS vs NTS", ats, nts, atsVsNts);
        combine("NTS vs ATS", nts, ats, ntsVsAts);
        combine("Portals vs NTs", portals, nts, portalsVsNts);
        combine("Console vs NTs (nodemanager)", consoles, nts, consoleVsNts);
        combine("Console vs Portals (nodemanager)", consoles, portals, consoleVsPortals);
        combine("NTs vs Console", nts, consoles, ntsVsConsoles);
        combine("Portals vs Console", portals, consoles, portalsVsConsoles);
        combine("Report vs NTs", reports, nts, reportsVsNts);
        combine("Report vs NTs", reports, nts, reportsVsNts);
        combine("Report vs Oracle single", reports, databasesReport, reportsVsOracleSingle);

    }
}
