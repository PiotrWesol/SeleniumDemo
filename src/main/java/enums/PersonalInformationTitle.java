package enums;

public enum PersonalInformationTitle {

    MR("Mr."),MRS("Mrs.");

    private String value;

    PersonalInformationTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
