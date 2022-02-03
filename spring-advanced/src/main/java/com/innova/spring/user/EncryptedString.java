package com.innova.spring.user;


public class EncryptedString {

    private String clearStr;
    private String encStr;


    public EncryptedString() {
    }


    public EncryptedString(final String clearStrParam) {
        super();
        this.clearStr = clearStrParam;
    }


    public String getClearStr() {
        return this.clearStr;
    }

    public void setClearStr(final String clearStrParam) {
        this.clearStr = clearStrParam;
    }

    public String getEncStr() {
        return this.encStr;
    }

    public void setEncStr(final String encStrParam) {
        this.encStr = encStrParam;
    }


}
