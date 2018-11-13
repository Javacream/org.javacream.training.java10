module org.javacream.training.books {
    exports org.javacream.books.isbngenerator.impl;
    exports org.javacream.books.warehouse.api;
    exports org.javacream.books.isbngenerator.api;

    requires junit;
    requires org.apache.commons.lang3;
    requires org.javacream.training.store;
}