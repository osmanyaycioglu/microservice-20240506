package org.training.microservice.msorder.resilience4j;

import java.util.function.Predicate;

public class ReserveRetryChooser implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable exp) {
         if (exp instanceof NullPointerException) {
            NullPointerException e = (NullPointerException) exp;
            return false;
        }
        return true;
    }
}
