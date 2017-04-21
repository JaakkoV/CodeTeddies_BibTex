/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import logic.Validator;

public class FieldAuthor implements Field {

    private final String fieldName = "author";
    private String fieldValue;
    // private Validator validator;
    // private final String regex = "";

    public FieldAuthor() {
        //this.validator = validator;
    }

    @Override
    public void setValue(String value) {
        fieldValue = value;

    }

    @Override
    public String getValue() {
        return fieldValue;
    }

    @Override
    public String toString() {
        return fieldName + " " + fieldValue;
    }

}
