import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class ModuleTest {
    private Student student1,student2;
    private Module ct417_module;
    private Programme bct_course,ece_course;

    @Before
    public void setup() {
        student1 = new Student("test1", 22, "12/10/1997", 123123);
        student2 = new Student("test2", 30, "12/01/1990", 555555);
        ct417_module = new Module("CT417");
        bct_course = new Programme("BCT", new DateTime("2020-09-28T07:22:05Z"),new DateTime("2020-12-18T07:22:05Z"));
        ece_course = new Programme("ECE", new DateTime("2020-09-28T07:22:05Z"),new DateTime("2020-12-18T07:22:05Z"));
    }

    @Test
    public void check_returns_true_when_students_added(){
        //Given
        ct417_module.addStudentsToModule(student1);
        //When
        List<Student> actualResult = ct417_module.getListOfStudents();
        //Then
        assert(actualResult.contains(student1));
        assertFalse(actualResult.contains(student2));
    }

    @Test
    public void check_module_added_correctly_to_course() {
        //Given
        ct417_module.addCourse(bct_course);
        ct417_module.addCourse(ece_course);
        bct_course.addModule(ct417_module);
        //When
        List<Programme> actualResult = ct417_module.getCoursesAssociated();
        //Then
        assert(actualResult.contains(bct_course));
        assert(actualResult.contains(ece_course));
        assert(bct_course.getListOfModules().contains(ct417_module));
    }

}