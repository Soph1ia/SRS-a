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
        this.listOfModules = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
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
        if (!listOfModules.contains(m)) {
            listOfModules.add(m);
            m.addCourse(this);
        }
    }

    public void removeModuleFromCourse(Module m) {
        if (listOfModules.contains(m)) {
            listOfModules.remove(m);
            m.removeCourse(this);
        }
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void addStudentsToCourse(Student s) {
        if (!listOfStudents.contains(s)) {
            listOfStudents.add(s);
            s.setCourse(this);
        }

    }

    public void removeStudentFromCourse(Student s) {
        if (listOfStudents.contains(s)) {
            listOfStudents.remove(s);
            s.removeFromCourse();
        }

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
        return "Programme { " +
                "Course-Name=" + courseName +
                ", \n Associated-Modules=" + listOfModules +
                ", \n Students-Registered=" + listOfStudents +
                ",\n Start-Date=" + startDate.toLocalDate() +
                ", End-Date=" + endDate.toLocalDate() +
                " }";
    }
}
