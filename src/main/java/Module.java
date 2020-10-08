import java.util.ArrayList;
import java.util.List;

public class Module {

    private String id;
    private List<Student> listOfStudents;
    private List<Programme> coursesAssociated;

    public Module(String id) {
        this.id = id;
        this.coursesAssociated = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
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
        if (!listOfStudents.contains(s)) {
            listOfStudents.add(s);
            s.addModule(this);
            if (s.getCourse() != null) {
                if (!coursesAssociated.contains(s.getCourse())) { // does not contain
                    coursesAssociated.add(s.getCourse()); // add to list the module is associated with
                }
            }
        }
    }

    public void removeStudentFromModule(Student s) {
        if (listOfStudents.contains(s)) {
            listOfStudents.remove(s);
            s.removeStudentFromModule(this);
        }
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

    //add only if it doesn't contain already
    public void addCourse(Programme p) {
        if (!coursesAssociated.contains(p)) {
            coursesAssociated.add(p);
            p.addModule(this);
        }
    }

    // remove only if it contains
    public void removeCourse(Programme p) {
        if (coursesAssociated.contains(p)) {
            coursesAssociated.remove(p);
            p.removeModuleFromCourse(this);
        }
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
        return
                "module-Id=" + id +
                        ", associated-courses =" + getListOfCourseNames() +
                        " students-enrolled =" + getListOfStudentNames();
    }

    private String getListOfCourseNames() {
        StringBuilder toReturn = new StringBuilder();
        for (Programme p : coursesAssociated) {
            toReturn.append(p.getCourseName() + ",");
        }
        return toReturn.toString();
    }

    private String getListOfStudentNames() {
        StringBuilder toReturn = new StringBuilder();
        for (Student s : listOfStudents) {
            toReturn.append(s.getUsername() + ",");
        }
        return toReturn.toString();
    }


}
