import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String FirstName;
    private String LastName;
    private String Birthdate;
    private String Address;
    private String ClassName;
    private Map<String, Double> Scores;

    public Student(String FirstName, String LastName, String Birthdate, String Address, String ClassName, Map<String, Double> Scores) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthdate = Birthdate;
        this.Address = Address;
        this.ClassName = ClassName;
        this.Scores = Scores;
    }

    public String getFullName() {
        return LastName + " " + FirstName;
    }    

    public Double getAverageScore() {
        if (Scores == null || Scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Double score : Scores.values()) {  
            total += score;
        }
        return total / Scores.size();
    }
    
    public String getGradeRank(){
        Double avg = getAverageScore();
        if (avg >= 8.5)
            return "A";
        else if (avg >= 7.0)
            return "B";
        else if (avg >= 5.5)
            return "C";
        else if (avg >= 4.0)
            return "D";
        else return "F";
    }

    public void displayInfo() {
        System.out.printf("%-20s %-10s %-10.2f\n", getFullName(), getGradeRank(), getAverageScore());
    }
}

class Classroom {
    private String ClassId;
    private List<Student> students;

    public Classroom(String ClassId) {
        this.ClassId = ClassId;
        this.students = new ArrayList<>();
    }

    public String getClassId() {
        return ClassId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    
    public void displayStudents() {
        System.out.println("Danh sach sinh vien lop " + ClassId + ":");
        System.out.printf("%-20s %-10s %-10s\n", "Ho va Ten", "Xep Loai", "Diem Trung Binh");
        for (Student student : students) {
            student.displayInfo();
        }
    }
    
    
    public void summarizeRanks() {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF_ = 0;
    
        for (Student student : students) {
            String rank = student.getGradeRank();
            switch (rank) {
                case "A" -> countA++;
                case "B" -> countB++;
                case "C" -> countC++;
                case "D" -> countD++;
                default -> countF_++;
            }
        }
    
        System.out.println("\nTong ket xep loai:");
        System.out.println("Rank A: " + countA + " sinh viên");
        System.out.println("Rank B: " + countB + " sinh viên");
        System.out.println("Rank C: " + countC + " sinh viên");
        System.out.println("Rank D: " + countD + " sinh viên");
        System.out.println("Rank <D: " + countF_ + " sinh viên");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Classroom> classrooms = new ArrayList<>();
        
Classroom classCNTT1 = new Classroom("CNTT1");
    classCNTT1.addStudent(new Student("Nguyen", "An", "2001-05-10", "Hà Nội", "CNTT1", Map.of(
    "LTHDT", 8.5, "QLDA", 7.5, "Hoc May", 9.0, "CSDL", 8.0, "LTUDTBD", 8.5)));
    classCNTT1.addStudent(new Student("Tran", "Binh", "2002-09-12", "HCM", "CNTT1", Map.of(
    "LTHDT", 6.0, "QLDA", 5.5, "Hoc May", 7.0, "CSDL", 6.5, "LTUDTBD", 6.0)));
    classCNTT1.addStudent(new Student("Le", "Chi", "2003-02-20", "Đà Nẵng", "CNTT1", Map.of(
    "LTHDT", 4.0, "QLDA", 3.5, "Hoc May", 5.0, "CSDL", 4.5, "LTUDTBD", 4.0)));
    classCNTT1.addStudent(new Student("Pham", "Duy", "2001-12-10", "Huế", "CNTT1", Map.of(
    "LTHDT", 9.0, "QLDA", 8.5, "Hoc May", 9.5, "CSDL", 9.0, "LTUDTBD", 9.0)));
    classCNTT1.addStudent(new Student("Hoang", "Minh", "2000-08-25", "HCM", "CNTT1", Map.of(
    "LTHDT", 7.0, "QLDA", 7.5, "Hoc May", 8.0, "CSDL", 7.5, "LTUDTBD", 7.0)));
    classCNTT1.addStudent(new Student("Do", "Huyen", "2002-11-30", "Hải Phòng", "CNTT1", Map.of(
    "LTHDT", 5.5, "QLDA", 6.0, "Hoc May", 5.5, "CSDL", 5.0, "LTUDTBD", 6.0)));
    classrooms.add(classCNTT1);

Classroom classCNTT2 = new Classroom("CNTT2");
    classCNTT2.addStudent(new Student("Ly", "Hanh", "2000-08-15", "Hà Nam", "CNTT2", Map.of(
    "LTHDT", 7.0, "QLDA", 7.5, "Hoc May", 7.0, "CSDL", 7.0, "LTUDTBD", 7.5)));
    classCNTT2.addStudent(new Student("Nguyen", "Thuy", "2003-06-22", "Hải Phòng", "CNTT2", Map.of(
    "LTHDT", 6.0, "QLDA", 6.5, "Hoc May", 5.5, "CSDL", 6.0, "LTUDTBD", 6.0)));
    classCNTT2.addStudent(new Student("Tran", "Nam", "2002-07-01", "HCM", "CNTT2", Map.of(
    "LTHDT", 8.0, "QLDA", 7.0, "Hoc May", 8.5, "CSDL", 8.0, "LTUDTBD", 7.5)));
    classCNTT2.addStudent(new Student("Bui", "Quang", "2001-03-10", "Huế", "CNTT2", Map.of(
    "LTHDT", 5.0, "QLDA", 4.5, "Hoc May", 5.5, "CSDL", 5.0, "LTUDTBD", 5.5)));
    classCNTT2.addStudent(new Student("Hoang", "Lan", "2000-09-18", "Đà Nẵng", "CNTT2", Map.of(
    "LTHDT", 9.0, "QLDA", 8.5, "Hoc May", 9.5, "CSDL", 9.0, "LTUDTBD", 9.5)));
    classCNTT2.addStudent(new Student("Do", "Long", "2003-12-25", "HCM", "CNTT2", Map.of(
    "LTHDT", 4.5, "QLDA", 4.0, "Hoc May", 3.5, "CSDL", 4.0, "LTUDTBD", 4.5)));
    classCNTT2.addStudent(new Student("Vo", "Hieu", "2002-05-05", "Hà Nội", "CNTT2", Map.of(
    "LTHDT", 7.5, "QLDA", 7.0, "Hoc May", 7.0, "CSDL", 7.5, "LTUDTBD", 7.0)));
    classrooms.add(classCNTT2);

Classroom classCNTT3 = new Classroom("CNTT3");
    classCNTT3.addStudent(new Student("Nguyen", "Hai", "2001-10-20", "Huế", "CNTT3", Map.of(
    "LTHDT", 6.5, "QLDA", 6.0, "Hoc May", 6.5, "CSDL", 6.0, "LTUDTBD", 6.5)));
    classCNTT3.addStudent(new Student("Le", "Tuan", "2003-02-28", "Hải Phòng", "CNTT3", Map.of(
    "LTHDT", 8.0, "QLDA", 8.5, "Hoc May", 8.5, "CSDL", 8.0, "LTUDTBD", 8.5)));
    classCNTT3.addStudent(new Student("Hoang", "Ngoc", "2000-06-15", "Hà Nam", "CNTT3", Map.of(
    "LTHDT", 7.5, "QLDA", 7.0, "Hoc May", 7.0, "CSDL", 7.5, "LTUDTBD", 7.0)));
    classCNTT3.addStudent(new Student("Bui", "Hieu", "2002-03-10", "HCM", "CNTT3", Map.of(
    "LTHDT", 9.0, "QLDA", 8.5, "Hoc May", 9.5, "CSDL", 9.0, "LTUDTBD", 9.5)));
    classCNTT3.addStudent(new Student("Pham", "Hoa", "2001-09-05", "Đà Nẵng", "CNTT3", Map.of(
    "LTHDT", 4.0, "QLDA", 4.5, "Hoc May", 4.5, "CSDL", 4.0, "LTUDTBD", 4.5)));
    classCNTT3.addStudent(new Student("Tran", "Minh", "2003-12-30", "Huế", "CNTT3", Map.of(
    "LTHDT", 6.5, "QLDA", 6.0, "Hoc May", 6.5, "CSDL", 6.0, "LTUDTBD", 6.5)));
    classCNTT3.addStudent(new Student("Vo", "Duc", "2002-07-15", "HCM", "CNTT3", Map.of(
    "LTHDT", 7.5, "QLDA", 7.0, "Hoc May", 7.0, "CSDL", 7.5, "LTUDTBD", 7.0)));
    classCNTT3.addStudent(new Student("Nguyen", "Khang", "2000-11-11", "Hà Nội", "CNTT3", Map.of(
    "LTHDT", 9.0, "QLDA", 8.5, "Hoc May", 9.5, "CSDL", 9.0, "LTUDTBD", 9.5)));
    classrooms.add(classCNTT3);

        Map<String, Classroom> classMap = new HashMap<>();
        for (Classroom classroom : classrooms) {
            classMap.put(classroom.getClassId(), classroom);
        }

        while (true) {
            System.out.println("\nDanh sach cac lop:");
            for (String classId : classMap.keySet()) {
                System.out.println("- " + classId);
            }
            System.out.print("Nhap ma lop de xem chi tiet: ");
            String input;
            try {
                input = scanner.nextLine().trim();
            } catch (Exception e) {
                System.out.println("Loi nhap lieu! Vui long thu lai.");
                continue;
            }

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Classroom selectedClass = classMap.get(input);
            if (selectedClass == null) {
                System.out.println("Khong tim thay lop co ma " + input);
            } else {
                selectedClass.displayStudents();
                selectedClass.summarizeRanks();
            }
        }
        scanner.close();
    }
}
