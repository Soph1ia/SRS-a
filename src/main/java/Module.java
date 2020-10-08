import java.util.ArrayList;
import java.util.List;

public class Module {

    private String id;
    private List<Student> listOfStudents;
    private List<Programme> coursesAssociated;

    public Module(String id) {
        this.id = id;
        this.coursesAssociated = new ArrayList<Programme>();
        this.listOfStudents = new ArrayList<Student>();
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Add student to list
    public void addStudentsToModule(Student s) {
        listOfStudents.add(s);
    }

    public void removeStudentFromModule(Student s) {
        listOfStudents.remove(s);
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<Programme> getCoursesAssociated() {
        return coursesAssociated;
    }

    public void setCoursesAssociated(List<Programme> coursesAssociated) {
        this.coursesAssociated = coursesAssociated;
    }

    public void addCourse(Programme p) {
        coursesAssociated.add(p);
    }

    public void removeCourse(Programme p) {
        coursesAssociated.remove(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        return id != null ? id.equals(module.id) : module.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id='" + id  +
                ", listOfStudents=" + listOfStudents +
                ", coursesAssociated=" + coursesAssociated +
                '}';
    }
}
