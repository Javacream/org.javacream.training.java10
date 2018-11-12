import org.javacream.training.people.listener.api.PeopleListener;
import org.javacream.training.people.listener.audit.impl.AuditPeopleListener;

/**
 * 
 */
/**
 * @author rainer
 *
 */
module org.javacream.training.people.listener.audit {
    requires org.javacream.training.people.listener;
    provides PeopleListener with AuditPeopleListener;
}