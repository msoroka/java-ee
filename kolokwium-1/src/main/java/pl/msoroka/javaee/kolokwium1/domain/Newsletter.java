package pl.msoroka.javaee.kolokwium1.domain;

import java.util.Date;

public class Newsletter {
    private String name;
    private Date from;
    private Date to;
    private String frequency;
    private String subjects;

    public Newsletter(String name, Date from, Date to, String frequency, String subjects) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.frequency = frequency;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
