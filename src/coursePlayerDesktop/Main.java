package coursePlayerDesktop;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student ogr1 = new Student("Əli", "əlinin st", "ali_udemy");
        Teacher emre = new Teacher("Cavid", "emre java", "emrealtunbilek");
        Teacher deneme = new Teacher("test", "test java", "testUdemy");
        System.out.println(ogr1);
        System.out.println(emre);
        Lesson d1 = new Lesson(1, "Why to Learn java Programming?", 3.3);
        Lesson d2 = new Lesson(2, "Variable Types", 33.3);
        Lesson d3 = new Lesson(3, "Basic Operators", 33.3);
        Lesson d4 = new Lesson(4, "Loop Control", 13.3);
        Lesson d5 = new Lesson(5, "Strings Class", 19.3);
        Lesson d6 = new Lesson(6, "Objects in Java", 13.3);
        Lesson d7 = new Lesson(7, "Try catch", 18.3);
        Lesson d8 = new Lesson(8, "Recyclerview", 13.3);
        Lesson d9 = new Lesson(9, "Sharedpreferencas", 13.3);
        Lesson d10 = new Lesson(10, "Firebase", 16.3);

        Course javaKursu = new Course("advanced java course", emre);

        javaKursu.addLessonToCourse(d1);
        javaKursu.addLessonToCourse(d2);
        javaKursu.addLessonToCourse(d3);
        javaKursu.addLessonToCourse(d4);
        javaKursu.addLessonToCourse(d5);
        javaKursu.addTeacherToCourse(deneme);
        javaKursu.deleteTeacherFromCourse(emre);
        javaKursu.deleteTeacherFromCourse(deneme);

        Course androidCourse = new Course("Android Course", emre);
        androidCourse.addLessonToCourse(d6);
        androidCourse.addLessonToCourse(d7);
        androidCourse.addLessonToCourse(d8);
        androidCourse.addLessonToCourse(d9);
        androidCourse.addLessonToCourse(d10);

        ogr1.joinCourse(javaKursu);
        ogr1.joinCourse(androidCourse);
        ogr1.watchLaterLessonAdd(d6);
        ogr1.watchLaterLessonAdd(d7);
        ogr1.watchLaterLessonAdd(d8);
        ogr1.watchLaterLessonAdd(d2);
        playList(ogr1.getWatchLaterLessonList());
    }
    public static void playList(LinkedList<Lesson> willWatchLaterLesson) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean goNextLesson = true;
        ListIterator<Lesson> iterator = willWatchLaterLesson.listIterator();
        if (willWatchLaterLesson.size() == 0) {
            System.out.println(" Hələ bir dərs əlavə olunmayıb");
        } else {
            Lesson firstLesson = iterator.next();
            System.out.println("İndi  izlənən dərs: " + firstLesson.getLessonTitle() + " vaxt: " + firstLesson.getMinute());
        }
        showMenu();
        while (!exit) {
            System.out.println("Seçiminiz: ");
            int userChoose = sc.nextInt();
            switch (userChoose) {
                case 0:
                    System.out.println("proqramdan çıxılır");
                    exit = true;
                    break;
                case 1:
                    if (!goNextLesson) {
                        goNextLesson = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        Lesson firstLeson = iterator.next();
                        System.out.println("===========================================");
                        System.out.println(" İndi izlənən dərs №: " + firstLeson.getLessonNo() + " baslıq: " + firstLeson.getLessonTitle() + "vaxt :" + firstLeson.getMinute());

                        System.out.println("===========================================");

                    } else {
                        System.out.println("listin sonuna gəldiniz ");
                    }
                    break;

                case 2:
                    if (goNextLesson) {
                        goNextLesson = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();

                        }
                    }
                    if (iterator.hasPrevious()) {
                        Lesson firstLesson = iterator.previous();
                        System.out.println("===========================================");
                        System.out.println(" Hal-hazırda izlənən dərs Ders no: " + firstLesson.getLessonNo() + " başlıq: " + firstLesson.getLessonTitle() + "vaxt:" + firstLesson.getMinute());

                        System.out.println("===========================================");

                    } else {
                        System.out.println("listin basina geldiniz");

                    }
                    break;

                case 3:
                    listLessonsToWatch(willWatchLaterLesson);
                    break;
                case 9:
                    showMenu();
                    break;
            }
        }
    }
    private static void listLessonsToWatch(LinkedList<Lesson> willWatchLaterLesson) {
        ListIterator<Lesson> iterator = willWatchLaterLesson.listIterator();
        if (willWatchLaterLesson.size() == 0) {
            System.out.println("Hələ bir dərs əlavə olunmayıb");
            return;
        } else {
            while (iterator.hasNext()) {
                Lesson firstLesson = iterator.next();
                System.out.println("Dərs no: " + firstLesson.getLessonNo() + " başlıq: " + firstLesson.getLessonTitle() + " vaxt: " + firstLesson.getMinute());
            }
        }
    }
    private static void showMenu() {
        System.out.println("**************Menu***************");
        System.out.println("0-9");
        System.out.println("1-Sonrakı sonraki dərsə get");
        System.out.println("2-Əvvəlki  dərsə  get");
        System.out.println("3-Bütün listi göstər");
        System.out.println("9-menu");


    }
}
