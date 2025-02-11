package exercises.advanced.composition.exercise1;

class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}

class Date {
    private final int day;
    private final int month;
    private final int Year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.Year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return Year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + Year;
    }
}


class Exam {
    private String subject;
    private String classroom;
    private Time time;
    private Date date;

    public Exam(String subject, String classroom, Time time, Date date) {
        this.subject = subject;
        this.classroom = classroom;
        this.time = time;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Asignatura: " + subject + ", Aula: " + classroom + ", Hora: " + time + ", Dia: " + date;
    }
}

public class CompositionExercise1 {

    public static void main(String[] args) {
        Time time = new Time(12, 25);
        System.out.println(time);

        Date date = new Date(25, 12, 2015);
        System.out.println(date);

        Exam exam = new Exam("Programacion", "010", time, date);

        exam.setTime(new Time(13, 30));
        exam.getTime().setMinute(45);
        exam.setDate(new Date(25, 2, 2025));

        System.out.println(exam);
    }
}
