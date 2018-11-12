import org.javacream.training.people.listener.api.PeopleListener;

module org.javacream.training.people.base.controller {
    exports org.javacream.training.people.base.controller.api;
    requires transitive org.javacream.training.people.base.types;
    requires org.apache.commons.lang3;
    requires org.javacream.training.people.listener;
    uses PeopleListener;
    
}