package coursePlayerDesktop;

public class Lesson {
    private int LessonNo;
    private String lessonTitle;
    private double minute;

    public Lesson(int lessonNo, String lessonTitle, double minute) {
        LessonNo = lessonNo;
        this.lessonTitle = lessonTitle;
        this.minute = minute;
    }

    public int getLessonNo() {
        return LessonNo;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public double getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "LessonNo=" + LessonNo +
                ", lessonTitle='" + lessonTitle + '\'' +
                ", minute=" + minute +
                '}';
    }
}
