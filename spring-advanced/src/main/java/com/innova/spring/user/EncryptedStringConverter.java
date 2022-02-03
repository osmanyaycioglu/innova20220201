package com.innova.spring.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Converter
public class EncryptedStringConverter implements AttributeConverter<EncryptedString, String> {

    @Autowired
    private StringEncryptor se;

    @Override
    public String convertToDatabaseColumn(final EncryptedString attributeParam) {
        String clearStrLoc = attributeParam.getClearStr();
        String encryptLoc = this.se.encrypt(clearStrLoc);
        attributeParam.setEncStr(encryptLoc);
        return encryptLoc;
    }

    @Override
    public EncryptedString convertToEntityAttribute(final String dbDataParam) {
        EncryptedString encryptedStringLoc = new EncryptedString();
        encryptedStringLoc.setEncStr(dbDataParam);
        String decryptLoc = this.se.decrypt(dbDataParam);
        encryptedStringLoc.setClearStr(decryptLoc);
        return encryptedStringLoc;
    }


}
