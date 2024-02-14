package day13;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    abstract class Person    //ABSTRACTION
    {
       private int id;
       private String name;
       private int age;
       abstract void getDetails(); //Abstract function
       Person(int id,String name,int age)
       {
           this.id=id;
           this.name=name;
           this.age=age;
       }
       //getters
        public int getId()
        {
            return id;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }
    class Student extends Person
    {
        Scanner sc = new Scanner(System.in);
        private int studentId;
        public List<String> courses=new ArrayList<>();
        Student(int id,String name,int age,int studentId)
        {
            super(id,name,age);
            this.studentId=studentId;
        }

        public int getStudentId() {
            return studentId;
        }
        public void getDetails()
        {
            System.out.println("Id="+ getId());
            System.out.println("Name="+ getName());
            System.out.println("Age="+ getAge());
            System.out.println("Student Id="+getStudentId());
            System.out.println("Enrolled Courses of Student are: ");
            for(String courseL : courses)
            {
                System.out.println(courseL);
            }
        }
        public String toString()
        {
            return "[Id: "+getId()+ " Name: "+ getName()+" Age: " + getAge()+" Student_id: "+ getStudentId()+"]";
        }
    }
    class Course
    {
        private String courseCode;
        private String courseName;
        private int creditHours;
        Course(String courseCode,String courseName,int creditHours)
        {
            this.courseCode=courseCode;
            this.courseName=courseName;
            this.creditHours=creditHours;
        }
        //getters

        public String getCourseCode() {
            return courseCode;
        }

        public String toString()
        {
            return "[Course-Code: "+ courseCode+", Course_Name: "+ courseName+", Credit_Hours: "+creditHours+"]";
        }
    }

    class Faculty extends Person
    {
        private int employeeId;
        private String department;
        private String teachCourse;
        Faculty(int id,String name,int age,int employeeId,String department,String teachCourse)
        {
            super(id,name,age);
            this.employeeId=employeeId;
            this.department=department;
            this.teachCourse=teachCourse;
        }
        //getters
        public int getEmployeeId() {
            return employeeId;
        }

        public String getDepartment() {
            return department;
        }

        public String getTeachCourse() {
            return teachCourse;
        }
        public void getDetails()
        {
            System.out.println("Id="+ getId());
            System.out.println("Name="+ getName());
            System.out.println("Age="+ getAge());
            System.out.println("Faculity Id="+getEmployeeId());
            System.out.println("Department="+ getDepartment());
            System.out.println("Teacher Courses="+ getTeachCourse());
        }
    }

    class University
    {
        List<Course> courseList;
        List<Student> studentList;
        List<Faculty>facultyList;
        University()
        {
            courseList= new ArrayList<>();
            studentList=new ArrayList<>();
            facultyList=new ArrayList<>();
        }
        //add Course
        public void addCourse(Course newCourse)
        {
            courseList.add(newCourse);
            System.out.println("Course is added successfully");
        }
        //remove Course
        public void removeCourse(String coursec)
        {
            Course coursetoDelete=null;
            for(Course course: courseList)
            {
                if(course.getCourseCode().equals(coursec))
                {
                    coursetoDelete=course;
                    break;
                }
                else {
                    System.out.println("Course does not exists");
                }
            }
            courseList.remove(coursetoDelete);
            System.out.println("Course has been deleted");
        }
        //Display Courses
        public void displayCourses()
        {
            for(Course course : courseList)
            {
                System.out.println(course);
            }
        }
        //Add Student
        public void addStudent(Student newStudent)
        {
            studentList.add(newStudent);
            System.out.println("Student  is added successfully");
        }
        //Remove Student
        public void removeStudent(int studentId)
        {
            Student studenttoRemove=null;
            for(Student student: studentList)
            {
                if(studentId==student.getStudentId())
                {
                    studenttoRemove=student;
                    break;
                }
                else
                {
                    System.out.println("Student is not enrolled in the univerrsity");
                }
            }
            studentList.remove(studenttoRemove);
            System.out.println("Student has been removed successfully! ");
        }

        //Enroll Student Course
        public void enrollCourse()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the id of Student who wants to enroll any course");
            int studentId=sc.nextInt();
            System.out.println("The availabe courses are: ");
            //Create an object of University class to access the diplay Courses method:
            displayCourses();
            sc.nextLine();
            System.out.println("Select the course in which the Student wants to enroll");
            String course=sc.next();
            Student studentEnrolling=isStudent(studentId);
            System.out.println(studentEnrolling);
            if(studentEnrolling!=null)
            {
                studentEnrolling.courses.add(course);
                System.out.println("Student has enrolled for "+ course);
                System.out.println(studentEnrolling.courses);
            }
            else
            {
                System.out.println("Student has not selected any course");
            }
        }
        //is Student present or not
        public Student isStudent(int studentId)
        {
            Student studenttoFind=null;
            for(Student student: studentList)
            {
                if(student.getStudentId()==studentId)
                {
                    studenttoFind=student;
                    break;
                }
                else
                {
                    System.out.println("Student is not registered in the university");
                }
            }
            return studenttoFind;
        }
        //Enrolled Students
        public void enrolledStudents()
        {
            for(Student student : studentList)
            {
                student.getDetails();
            }
        }
        //Add Faculty
        public void addFaculty(Faculty newFaculty)
        {
            facultyList.add(newFaculty);
            System.out.println("Faculty is added Successfully");
        }
        //Remove Teachers
        public void removeFaculty(int facultyId)
        {
            Faculty facultytoRemove=null;
            for(Faculty faculty: facultyList)
            {
                if(facultyId==faculty.getEmployeeId())
                {
                    facultytoRemove=faculty;
                    break;
                }
                else
                {
                    System.out.println("Faculty is not enrolled in the univerrsity");
                }
            }
            facultyList.remove(facultytoRemove);
            System.out.println("Faculty has been removed successfully! ");
        }
        //display Teachers
        public void displayFaculty()
        {
            for(Faculty faculty : facultyList)
            {
                faculty.getDetails();
            }
        }
    }
public class UniversityManagement
{
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        University un=new University();
        System.out.println("Welcome to the University");
        while(true)
        {
            System.out.println("Select the options");
            System.out.println("0. Exit");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Add Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Enroll Course");
            System.out.println("6. Add Faculty");
            System.out.println("7. Remove Faculty");
            System.out.println("8. Enrolled Students");
            System.out.println("9. Faculty Members");
            System.out.println("10. Available Courses ");

            int n=sc.nextInt();
            if(n==0)
            {
                System.out.println("Exiting");
                break;
            }
            switch (n)
            {
                case 1:
                {
                    Course newcourse=addCourse();
                    un.addCourse(newcourse);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the course Code that you want to remove");
                    String courseCode=sc.next();
                    un.removeCourse(courseCode);
                    break;
                }
                case 3:
                {
                    Student newstudent=addStudent();
                    un.addStudent(newstudent);
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the student Id that you want to remove");
                    int studentId=sc.nextInt();
                    un.removeStudent(studentId);
                    break;
                }
                case 5:
                {
                    un.enrollCourse();
                    break;
                }

                case 6:
                {
                    Faculty newFaculty=addFaculty();
                    un.addFaculty(newFaculty);
                    break;
                }
                case 7:
                {
                    System.out.println("Enter the id of Faculty");
                    int facultyId= sc.nextInt();
                    un.removeFaculty(facultyId);
                    break;
                }
                case 8:
                {
                    un.enrolledStudents();
                    break;
                }
                case 9:
                {
                    un.displayFaculty();
                    break;
                }
                case 10:
                {
                    un.displayCourses();
                    break;
                }
                default:
                    System.out.println("You have entered invalid option");
            }
        }
    }
    public static Course addCourse()
    {
        System.out.println("Enter the course Code");
        String courseCode=sc.next();
        sc.nextLine();
        System.out.println("Enter the course Name");
        String courseName=sc.nextLine();
        System.out.println("Enter the No. of hours for the course");
        int creditHours=sc.nextInt();
        Course newCourse= new Course(courseCode,courseName,creditHours);
        return newCourse;
    }
    public static Student addStudent()
    {
        System.out.println("Enter the Adhaar Id ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name of Student");
        String name=sc.nextLine();
        System.out.println("Enter the Age");
        int age=sc.nextInt();
        System.out.println("Enter the student Id");
        int studentId=sc.nextInt();
        Student newstudent= new Student(id,name,age,studentId);
        return newstudent;
    }
    public static Faculty addFaculty()
    {
        System.out.println("Enter the Adhaar Id ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name of Faculty");
        String name=sc.nextLine();

        System.out.println("Enter the Age");
        int age=sc.nextInt();
        System.out.println("Enter the Faculty Id");
        int facultyId=sc.nextInt();
        System.out.println("Enter the department of the faculty");
        String department=sc.next();
        System.out.println("Enter the Course that teacher Teaches");
        String teachCourse=sc.next();
        Faculty newFaculty= new Faculty(id,name,age,facultyId,department,teachCourse);
        return newFaculty;
    }
}
