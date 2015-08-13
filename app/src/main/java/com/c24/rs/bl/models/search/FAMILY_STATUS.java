package com.c24.rs.bl.models.search;

import java.io.Serializable;

public enum FAMILY_STATUS implements Serializable {
    SINGLE(1),
    SINGLE_WITH_CHILD (2),
    COUPLE (3),
    FAMILY (4),;

    private final int value;

    FAMILY_STATUS(final int newValue) {
        value = newValue;
    }

    public Integer getValue() { return value; }
}
