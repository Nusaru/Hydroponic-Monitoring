package com.lawencon.hydroponicmonitoring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao {
    protected EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em){
        this.em = em;
    }
}
