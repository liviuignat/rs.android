package com.c24.rs.app.screens.search;

import com.c24.rs.common.KeyValueElement;
import com.c24.rs.domain.models.search.EMPLOYMENT_STATUS;
import com.c24.rs.domain.models.search.FAMILY_STATUS;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

@EBean
public class SearchOptionsFactory {
    public KeyValueElement<FAMILY_STATUS, String>[] getFamilyStatuses() {
        return new KeyValueElement[]{
                new KeyValueElement<>(FAMILY_STATUS.SINGLE, "Single"),
                new KeyValueElement<>(FAMILY_STATUS.SINGLE_WITH_CHILD, "Single mit Kind"),
                new KeyValueElement<>(FAMILY_STATUS.COUPLE, "Paar"),
                new KeyValueElement<>(FAMILY_STATUS.FAMILY, "Familie")
        };
    }

    public KeyValueElement<EMPLOYMENT_STATUS, String>[] getEmploymentStatuses() {
        return new KeyValueElement[]{
                new KeyValueElement<>(EMPLOYMENT_STATUS.EMPLOYED, "Arbeitnehmer"),
                new KeyValueElement<>(EMPLOYMENT_STATUS.FREELANCER, "Selbstständig/Freiberuflich"),
                new KeyValueElement<>(EMPLOYMENT_STATUS.GOVERNMENT_EMPLOYED, "Öffentlicher Dienst"),
                new KeyValueElement<>(EMPLOYMENT_STATUS.STUDENT, "Azubi/Student"),
                new KeyValueElement<>(EMPLOYMENT_STATUS.PENSIONEER, "Rentner"),
                new KeyValueElement<>(EMPLOYMENT_STATUS.UNEMPLOYED, "Ohne berufliche Tätigkeit"),
        };
    }

    public KeyValueElement<Double, String>[] getRentIncomes() {
        return new KeyValueElement[]{
                new KeyValueElement<>(3000.0D, "0 € - 3.000 €"),
                new KeyValueElement<>(6000.0D, "3.000 € – 6.000 €"),
                new KeyValueElement<>(9000.0D, "6.000 € – 9.000 €"),
                new KeyValueElement<>(12000.0D, "9.000 € – 12.000 €"),
                new KeyValueElement<>(15000.0D, "12.000 € – 15.000 €"),
                new KeyValueElement<>(18000.0D, "15.000 € – 18.000 €"),
                new KeyValueElement<>(24000.0D, "18.000 € – 24.000 €"),
                new KeyValueElement<>(30000.0D, "24.000 € – 30.000 €"),
                new KeyValueElement<>(50000.0D, "40.000 € – 50.000 €"),
                new KeyValueElement<>(60000.0D, "50.000 € – 60.000 €"),
                new KeyValueElement<>(70000.0D, "60.000 € – 70.000 €"),
                new KeyValueElement<>(80000.0D, "70.000 € – 80.000 €"),
                new KeyValueElement<>(90000.0D, "80.000 € – 90.000 €"),
                new KeyValueElement<>(100000.0D, "90.000 € – 100.000 €"),
        };
    }

    public KeyValueElement<Integer, String>[] getRentNumberOfRooms() {
        ArrayList<KeyValueElement<Integer, String>> list = new ArrayList<>();
        for(int index = 0; index < 10; index++) {
            list.add(new KeyValueElement<>(index + 1, new Integer(index + 1).toString()));
        }
        return list.toArray(new  KeyValueElement[list.size()]);
    }

    public KeyValueElement<Integer, String>[] getNumberOfEmployees() {
        ArrayList<KeyValueElement<Integer, String>> list = new ArrayList<>();
        list.add(new KeyValueElement<>(0, "Nur Inhaber"));
        for(int index = 0; index < 10; index++) {
            list.add(new KeyValueElement<>(index + 1, new Integer(index + 1).toString()));
        }
        return list.toArray(new  KeyValueElement[list.size()]);
    }
}
