package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.AttributeConverter;

//will convert from the boolean object representation to the string database representation
//it must implement AttributeConverter interface + parameters Boolean and String - from Boolean to String in our ex
public class VipConverter implements AttributeConverter<Boolean,String> {

    //will convert the boolean object to String database representation
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute ? "Yes" : "No"; //true = Yes, false = No
    }


    //will convert the String data from the database to Boolean values
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Yes".equalsIgnoreCase(dbData) ? Boolean.TRUE : Boolean.FALSE;
    }
}
