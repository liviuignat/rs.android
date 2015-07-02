package com.c24.rs.common.formatters;

public class GradeTextFormatter {
    public String get(Double grade) {
        if (grade <= 1.0) {
            return "exzellent";
        } else if (grade < 1.5) {
            return "sehr gut";
        } else if (grade < 2.5) {
            return "gut";
        } else {
            return "befriedigend";
        }
    }
}
