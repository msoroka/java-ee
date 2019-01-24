package com.msoroka.javaee.projekt.service;

import com.msoroka.javaee.projekt.domain.License;
import com.msoroka.javaee.projekt.domain.Pilot;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LicenseManager {

    @PersistenceContext
    EntityManager em;

    @EJB
    PilotManager pilotManager;

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
        License license = em.find(License.class, id);

        Pilot pilot = pilotManager.getPilotByLicenseNumber(license.getNumber());

        pilot.setLicense(null);

        em.remove(license);
    }

    public void deleteAllLicenses(){
        em.createNamedQuery("license.deleteAll").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<License> getAllLicenses(){
        return em.createNamedQuery("license.getAll").getResultList();
    }
}
