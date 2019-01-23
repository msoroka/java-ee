package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.License;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LicenseManager {

    @PersistenceContext
    EntityManager em;

    public void addLicense(License license) {
        em.persist(license);
    }

    public License getLicense(long id){
        return em.find(License.class, id);
    }

    public License updateLicense(License transientLicense) {
        return em.merge(transientLicense);
    }

    public void deleteLicense(long id){
        em.remove(em.find(License.class, id));
    }

    public void deleteAllLicenses(){
        em.createNamedQuery("license.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<License> getAllLicenses(){
        return em.createNamedQuery("license.getAll").getResultList();
    }
}
