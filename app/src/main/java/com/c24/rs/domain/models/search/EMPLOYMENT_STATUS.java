package com.c24.rs.domain.models.search;

import java.io.Serializable;

public enum EMPLOYMENT_STATUS implements Serializable {
    NOT_SPECIFIED(0),
    EMPLOYED (1),
    UNEMPLOYED (2),
    GOVERNMENT_EMPLOYED (3),
    PENSIONEER (4),
    FREELANCER (5),
    STUDENT (6);

    private final int value;

    EMPLOYMENT_STATUS(final int newValue) {
        value = newValue;
    }

    public Integer getValue() { return value; }
}
