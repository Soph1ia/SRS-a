import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ProgrammeTest {
    private Student student1,student2;
    private Module ct417_module;
    private Programme bct_course;

    @BeforeEach
    public void setup() {
        student1 = new Student("test1", 22, "12/10/1997", 123123);
        student2 = new Student("test2", 30, "12/01/1990", 555555);
        ct417_module = new Module("CT417");
        bct_course = new Programme("BCT", new DateTime("2020-09-28T07:22:05Z"),new DateTime("2020-12-18T07:22:05Z"));
    }

    @Test
    public void check_student_correctly_removed(){
        //Given
        bct_course.addStudentsToCourse(student1);
        //When
        List<Student> actualResult = bct_course.getListOfStudents();
        //Then
        assert (actualResult.contains(student1));
        assertFalse(actualResult.contains(student2));
    }

    @Test
    public void check_module_correctly_removed() {
        //Given
        bct_course.addModule(ct417_module);
        bct_course.removeModuleFromCourse(ct417_module);
        //When
        List<Module> actualResult = bct_course.getListOfModules();
        //Then
        assertFalse(actualResult.contains(ct417_module));
    }
}