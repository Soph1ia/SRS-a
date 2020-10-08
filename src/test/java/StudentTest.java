import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student1,student2;
    private Module ct417_module, ct556_module;
    private Programme bct_course;

    @Before
    public void setup() {

        ct417_module = new Module("CT417");
        ct556_module = new Module("CT556");
        bct_course = new Programme("BCT", new DateTime("2020-09-28T07:22:05Z"), new DateTime("2020-12-18T07:22:05Z"));
        student1 = new Student("test1", 22, "12/10/1997", 123123,bct_course);
        student2 = new Student("test2", 22, "12/10/1997", 123123);
    }

    @Test
    public void check_username_correct() {
        //Given
        String expectedUsername = "test122";
        //When
        String actualUsername = student1.getUsername();
        //Then
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void check_student_enrolled_to_correct_module() {
        //Given
        student1.addModule(ct417_module);
        Module expectedModule = new Module("CT417");
        //When
        List<Module> actualModules = student1.getModulesEnrolled();
        //Then
        System.out.println(actualModules);
        assertTrue(actualModules.contains(expectedModule));
    }

    @Test
    public void check_student_removed_correctly_from_module() {
        //Given
        student1.addModule(ct417_module);
        student1.addModule(ct556_module);
        //When
        student1.removeStudentFromModule(ct417_module);
        //Then
        assertFalse(student1.getModulesEnrolled().contains(ct417_module));
    }

    @Test
    public void check_test_fails_when_student_not_enrolled() {
        //Given
        student1.addModule(ct417_module);
        Module expectedModule = new Module("CT4104");
        //When
        List<Module> actualModules = student1.getModulesEnrolled();
        //Then
        assertFalse(actualModules.contains(expectedModule));
    }

    @Test
    public void check_true_student_enrolled_to_correct_programme() {
        //Given
        student2.setCourse(bct_course);
        Programme expectedCourse = new Programme("BCT", new DateTime("2020-09-28T07:22:05Z"), new DateTime("2020-12-18T07:22:05Z"));
        //When
        Programme actualCourse = student1.getCourse();
        //Then
        assertTrue(actualCourse.equals(expectedCourse));
    }

    @Test
    public void check_test_fails_if_student_not_enrolled_to_programme() {
        //Given
        student2.setCourse(bct_course);
        Programme expectedCourse = new Programme("ECE", new DateTime("2020-09-28T07:22:05Z"), new DateTime("2020-12-18T07:22:05Z"));
        //When
        Programme actualCourse = student1.getCourse();
        //Then
        assertNotEquals(expectedCourse, actualCourse);
    }

}