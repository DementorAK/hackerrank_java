import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    private Queue<Student> queue;
    public List<Student> getStudents(List<String> events) {
        queue = new PriorityQueue<Student>(
                Comparator.comparing(Student::getCGPA).reversed().
                    thenComparing(Student::getName).
                        thenComparing(Student::getId));

        for (String event: events) {
            if (event.equals("SERVED")){
                if (queue.size()>0)
                    queue.poll();
            } else {
                String[] tokens = event.split(" ");
                if (tokens[0].equals("ENTER")){
                    queue.add(new Student(
                            Integer.parseInt(tokens[3]),
                            tokens[1],
                            Double.parseDouble(tokens[2])));
                }
            }
        }

        List<Student> result = new ArrayList<>();
        while (!queue.isEmpty())
            result.add(queue.poll());

        return result;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}