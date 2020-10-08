import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name;
    private int age;
    private String dob;
    private int id;
    private List<Module> modulesEnrolled;
    private Programme course;

    public Student(String name, int age, String dob, int id) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id = id;
        modulesEnrolled = new ArrayList<>();
    }

    public Student(String name, int age, String dob, int id, Programme course) {
        this(name, age, dob, id);
        this.course = course;
    }

    // Getters and Setters
    public String getUsername() {
        return String.format("%s%d", name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Module> getModulesEnrolled() {
        return modulesEnrolled;
    }

    public void setModulesEnrolled(List<Module> modulesEnrolled) {
        this.modulesEnrolled = modulesEnrolled;
    }

    // Add more modules to list
    public void addModule(Module m) {
        if (!modulesEnrolled.contains(m)) {
            modulesEnrolled.add(m);
            m.addStudentsToModule(this);
        }
    }

    // remove certain modules from list
    public void removeStudentFromModule(Module m) {
        if (modulesEnrolled.contains(m)) {
            modulesEnrolled.remove(m);
            m.removeStudentFromModule(this);
        }
    }

    public Programme getCourse() {
        return course;
    }

    public void setCourse(Programme course) {
        this.course = course;
    }

    public void removeFromCourse() {
        this.course = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "name =" + name +
                ", age =" + age +
                ", dob =" + dob +
                ", id =" + id +
                ", course = " + getCourse().getCourseName() +
                ", modules-enrolled = " + getListOfModuleNames()
                ;
    }

    private String getListOfModuleNames() {
        StringBuilder toReturn = new StringBuilder();
        for (Module m : modulesEnrolled) {
            toReturn.append(m.getId() + ",");
        }
        return toReturn.toString();
    }
}
