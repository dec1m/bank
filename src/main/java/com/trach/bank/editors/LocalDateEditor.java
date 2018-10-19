package com.trach.bank.editors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public  class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        String[] split = text.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        System.out.println("DAY =" + day );
        System.out.println("DAY =" + day );
        System.out.println("DAY =" + day );
        System.out.println("DAY =" + day );
        setValue(LocalDate.of(year,month,day));
    }

    @Override
    public String getAsText() {
        LocalDate value = (LocalDate) getValue();
       return value.toString();
    }
}