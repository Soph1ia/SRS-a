import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Programme {

    private String courseName;
    private List<Module> listOfModules;
    private List<Student> listOfStudents;
    private DateTime startDate;
    private DateTime endDate;

    public Programme(String courseName, DateTime startDate, DateTime endDate) {
        this.courseName = courseName;
        this.listOfModules = new ArrayList<Module>();
        this.listOfStudents = new ArrayList<Student>();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Module> getListOfModules() {
        return listOfModules;
    }

    public void setListOfModules(List<Module> listOfModules) {
        this.listOfModules = listOfModules;
    }

    public void addModule(Module m) {

        listOfModules.add(m);
    }

    public void removeModuleFromCourse(Module m) {

        listOfModules.remove(m);
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void addStudentsToCourse(Student s) {
        listOfStudents.add(s);
    }

    public void removeStudentFromCourse(Student s) {
        listOfStudents.remove(s);
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programme programme = (Programme) o;

        return courseName != null ? courseName.equals(programme.courseName) : programme.courseName == null;
    }

    @Override
    public int hashCode() {
        return courseName != null ? courseName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "courseName='" + courseName  +
                ", listOfModules=" + listOfModules +
                ", listOfStudents=" + listOfStudents +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
