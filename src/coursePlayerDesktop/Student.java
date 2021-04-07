package coursePlayerDesktop;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends Person {
    private ArrayList<Course> joinedCourses;
    private LinkedList<Lesson> watchLaterLessonList;

    public Student(String name, String status, String username) {
        super(name, status, username);
        joinedCourses = new ArrayList<>();
        watchLaterLessonList = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "joinedCourses=" + joinedCourses +
                ", watchLaterLessonList=" + watchLaterLessonList +
                '}';
    }

    public ArrayList<Course> getJoinedCourses() {
        return joinedCourses;
    }

    public LinkedList<Lesson> getWatchLaterLessonList() {
        return watchLaterLessonList;
    }

    public void joinCourse(Course javaKursu) {
        if (javaKursu.kursYayindaKontrol()) {
            javaKursu.getStudentsInCourse().add(this);
            joinedCourses.add(javaKursu);
            System.out.println(this.getName() + " istifadəçisi " + javaKursu.getNameOfCourse() + " kursuna qatıldı");
        } else {
            System.out.println(javaKursu.getNameOfCourse() + " adlı  kurs  online deyil, qatıla bilməzsiz");
        }
    }

    public void watchLaterLessonAdd(Lesson watchLaterLesson) {
        boolean findLesson = false;
        if (joinedCourses.size() > 0) {
            for (Course a : joinedCourses) {
                if (a.getLessonsInCourse().contains(watchLaterLesson)) {
                    System.out.println(" Izləniləcək dərs  siyahısına  " + a.getNameOfCourse() + " kursunda var olan  " + watchLaterLesson.getLessonTitle() + " dərs əlavə olundu");
                    watchLaterLessonList.add(watchLaterLesson);
                    findLesson = true;
                    break;
                }
            }

            if (!findLesson) {
                System.out.println("Girilen dərs kurslarda tapılmadı və yaxud sizin giriş icazəniz yoxdu ");
            }
        }
    }
}