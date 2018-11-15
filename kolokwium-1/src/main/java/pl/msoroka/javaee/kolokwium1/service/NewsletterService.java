package pl.msoroka.javaee.kolokwium1.service;

import pl.msoroka.javaee.kolokwium1.domain.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsletterService {
    private List<Newsletter> db = new ArrayList<Newsletter>();

    public void addNewsletter(Newsletter newsletter) {
        Newsletter newNewsletter = new Newsletter(newsletter.getName(), newsletter.getFrom(), newsletter.getTo(), newsletter.getFrequency(), newsletter.getSubjects());
    }

    public List<Newsletter> getAllNewsletters() {
        return db;
    }
}
