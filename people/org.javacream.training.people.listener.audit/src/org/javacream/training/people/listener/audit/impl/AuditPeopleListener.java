package org.javacream.training.people.listener.audit.impl;

import java.util.Date;

import org.javacream.training.people.base.types.api.Person;
import org.javacream.training.people.listener.api.PeopleListener;

public class AuditPeopleListener implements PeopleListener {

    @Override
    public void handleSave(Person p) {
	System.out.println("AUDIT: saving person " + p + " at " + new Date());
    }

}
