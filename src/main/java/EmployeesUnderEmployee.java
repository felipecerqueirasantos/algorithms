import java.util.*;

/**
 * Created by sky on 5/26/15.
 */
public class EmployeesUnderEmployee {
    public static final class Cia {
        Map<String, List<String>> hierarchy = new HashMap<>();

        public Cia() {

        }

        public void add(String manager, String employee) {
            List<String> l = hierarchy.get(manager);
            if (l == null) {
                l = new ArrayList<>();
                l.add(employee);
                hierarchy.put(manager, l);

                return;
            }

            l.add(employee);
        }

        public List<String> getEmployees(String manager) {
            Queue<String> queue = new ArrayDeque<>();
            List<String> employees = new ArrayList<>();
            Set<String> visited = new HashSet<>();

            List<String> l = hierarchy.get(manager);
            if (l == null)
                return employees;

            for (String e: l) {
                queue.add(e);
            }

            while (!queue.isEmpty()) {
                String e = queue.remove();

                if (visited.contains(e))
                    continue;

                visited.add(e);

                employees.add(e);

                l = hierarchy.get(e);
                if (l != null) {
                    queue.addAll(l);
                }
            }

            return employees;
        }

        private void getEmployees(String manager, List<String> employees) {
            List<String> l = hierarchy.get(manager);
            if (l == null) return;


        }
    }

    public static void main(String[] args) {
        Cia cia = new Cia();
        cia.add("Marcio", "Felipe");
        cia.add("Felipe", "Edgar");
        cia.add("Felipe", "Silvia");
        cia.add("Felipe", "Fernanda");
        cia.add("Felipe", "Henrique");
        cia.add("Rafael", "Marcio");
        cia.add("Raquel", "Felipe");

        List<String> l = cia.getEmployees("Raquel");
        for (String e: l)
            System.out.println(e);
    }
}
