package com.example.propertityEditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lvfeibiao
 * @date 上午11:54
 */
public class MyDateEditor extends PropertyEditorSupport {
    private String format;

    public MyDateEditor(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = new SimpleDateFormat(this.format).parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
