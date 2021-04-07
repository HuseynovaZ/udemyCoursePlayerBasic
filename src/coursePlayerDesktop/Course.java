package coursePlayerDesktop;

import java.util.ArrayList;

public class Course {
    private String nameOfCourse;
    private ArrayList<Lesson> lessonsInCourse;
    private ArrayList<Teacher> teachersInCourse;
    private ArrayList<Student> studentsInCourse;
    //ders sayi en az 5 ve toplam  60 dakika
    private boolean online;

    public Course(String nameOfCourse, Teacher headTeacher) {
        this.nameOfCourse = nameOfCourse;
        this.lessonsInCourse = new ArrayList<>();
        this.teachersInCourse = new ArrayList<>();
        this.studentsInCourse = new ArrayList<>();
        teachersInCourse.add(0, headTeacher);
        this.online = false;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public ArrayList<Lesson> getLessonsInCourse() {
        return lessonsInCourse;
    }

    public ArrayList<Teacher> getTeachersInCourse() {
        return teachersInCourse;
    }

    public boolean isOnline() {
        return online;
    }

    public ArrayList<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "nameOfCourse='" + nameOfCourse + '\'' +
                ", lessonsInCourse=" + lessonsInCourse +
                ", teachersInCourse=" + teachersInCourse +
                ", studentsInCourse=" + studentsInCourse +
                ", online=" + online +
                '}';
    }

    public void addTeacherToCourse(Teacher newTeacher) {
        if (!teachersInCourse.contains(newTeacher)) {
            teachersInCourse.add(newTeacher);
            System.out.println(newTeacher.getName() + " kursa müəllim olaraq əlavə olundu");
        } else {
            System.out.println(newTeacher.getName() + " bu müəllim kursda mövcuddur");
        }
    }

    public void deleteTeacherFromCourse(Teacher deleteTeacher) {
        if (deleteTeacher.getName().equals(teachersInCourse.get(0).getName())) {
            System.out.println(deleteTeacher.getName() + "  müəllim kursun baş müəllimidir,ona görə silinə bilməz ");
        } else {
            teachersInCourse.remove(deleteTeacher);
            System.out.println(deleteTeacher.getName() + " müəllim kursdan çıxarıldı");
        }

    }

    public void addLessonToCourse(Lesson addLesson) {
        lessonsInCourse.add(addLesson);
    }

    public int numberOfLessonInCourse() {
        return lessonsInCourse.size();
    }

    private int NumberOfMinutesOfTotalLessonsInCourse() {
        double totalTime = 0;
        for (Lesson lesson : lessonsInCourse) {
            totalTime = totalTime + lesson.getMinute();
        }
        return (int) totalTime;
    }

    public boolean kursYayindaKontrol() {
        if (lessonsInCourse.size() >= 5 && NumberOfMinutesOfTotalLessonsInCourse() >= 60) {
            online = true;
            return true;
        } else return false;
    }
}