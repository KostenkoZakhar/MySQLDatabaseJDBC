package mysqlconfig.enums;

public enum ADRESSFIELDS {
    ID("id"), USERNAME("userName"), USERSURNAME("userSurname"), COUNTRY("country"),EMAIL("email");
    String fieldName;

    private ADRESSFIELDS(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
