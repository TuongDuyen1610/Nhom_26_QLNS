import java.util.*;

class Student {
    String firstName, lastName, birthDate, address, className;
    Map<String, Double> grades;

    public Student(String firstName, String lastName, String birthDate, String address, String className, Map<String, Double> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.className = className;
        this.grades = grades;
    }

    public double getAverageGrade() {
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public String getRank() {
        double avg = getAverageGrade();
        if (avg >= 8.5) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4.0) return "D";
        else return "<D";
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - Rank: " + getRank();
    }
}

class ClassRoom {
    String classCode;
    List<Student> students;

    public ClassRoom(String classCode) {
        this.classCode = classCode;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Class: " + classCode);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Map<String, Long> countByRank() {
        Map<String, Long> rankCount = new HashMap<>();
        for (Student student : students) {
            rankCount.put(student.getRank(), rankCount.getOrDefault(student.getRank(), 0L) + 1);
        }
        return rankCount;
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ClassRoom> classRooms = new ArrayList<>();

        // Sample Data
        ClassRoom class1 = new ClassRoom("CNTT-01");
        Map<String, Double> grades1 = new HashMap<>();
        grades1.put("OOP", 8.0);
        grades1.put("Project Management", 7.5);
        grades1.put("Machine Learning", 9.0);
        grades1.put("Database", 7.0);
        grades1.put("Mobile Dev", 8.5);
        class1.addStudent(new Student("Nguyen", "An", "2000-05-10", "Hanoi", "CNTT-01", grades1));

        classRooms.add(class1);

        System.out.println("Enter class code to view students: ");
        String inputClass = scanner.nextLine();
        for (ClassRoom cls : classRooms) {
            if (cls.classCode.equalsIgnoreCase(inputClass)) {
                cls.displayStudents();
                System.out.println("Rank Count: " + cls.countByRank());
            }
        }
        scanner.close();
    }
}
/*Dưới đây là chương trình Java để quản lý lớp học CNTT theo yêu cầu trong ảnh:

Quan Ly Lop Hoc

Trả lời trong đoạn chat
Chương trình trên giúp quản lý danh sách sinh viên trong lớp học CNTT. Nó bao gồm:

Lớp Student: Lưu thông tin sinh viên và tính toán điểm trung bình, xếp loại.
Lớp ClassRoom: Quản lý danh sách sinh viên trong lớp, hiển thị thông tin và thống kê số lượng sinh viên theo hạng điểm.
Lớp SchoolManagement: Chương trình chính để nhập và hiển thị thông tin lớp học.
Bạn có thể chạy chương trình và nhập mã lớp để xem danh sách sinh viên và thống kê số lượng theo hạng điểm. */