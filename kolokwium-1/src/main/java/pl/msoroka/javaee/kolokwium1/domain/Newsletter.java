package pl.msoroka.javaee.kolokwium1.domain;

public class Newsletter {
    private String name;
    private String from;
    private String to;
    private String frequency;
    private String subjects;

    public Newsletter(String name, String from, String to, String frequency, String subjects) {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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
