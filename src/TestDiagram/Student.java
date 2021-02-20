package TestDiagram;

public class Student extends Person{

    String classNumber;

    Course course;

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public void setCourse(Course course) {
        this.course = course;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
