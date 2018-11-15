package pl.msoroka.javaee.kolokwium1.service;

import pl.msoroka.javaee.kolokwium1.domain.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsletterService {
    private List<Newsletter> db = new ArrayList<Newsletter>();

    public void addNewsletter(Newsletter newsletter) {
        Newsletter newNewsletter = new Newsletter(newsletter.getName(), newsletter.getFrom(), newsletter.getTo(), newsletter.getFrequency(), newsletter.getSubjects());
        db.add(newNewsletter);
    }

    public List<Newsletter> getAllNewsletters() {
        return db;
    }

    public void removeNewsletter(Newsletter newsletter) {
        db.remove(newsletter);
    }
}
