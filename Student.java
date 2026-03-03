public class Student implements Comparable<Student> {

    int rollNum;
    String name;
    double marks;

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    Student(int rollNum, String name, double marks) {
        this.rollNum = rollNum;
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student stud) {
        return Double.compare(stud.marks, this.marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
