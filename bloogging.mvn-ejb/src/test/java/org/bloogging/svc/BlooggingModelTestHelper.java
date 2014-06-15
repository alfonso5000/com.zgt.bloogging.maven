/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bloogging.svc;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BlooggingModelTestHelper {
    @PersistenceContext
    private EntityManager em;

    public void clean(){
        em.createNativeQuery("delete from Comment").executeUpdate();
        em.createNativeQuery("delete from Post").executeUpdate();
        em.createNativeQuery("delete from Author").executeUpdate();
        em.createNativeQuery("delete from UsersGroup").executeUpdate();
    }
}
