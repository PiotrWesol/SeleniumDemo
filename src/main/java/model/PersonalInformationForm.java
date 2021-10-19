package model;

import enums.Month;
import enums.PersonalInformationTitle;
import lombok.Data;

@Data
public class PersonalInformationForm {

    private PersonalInformationTitle title;
    private String firstName;
    private String lastName;
    private String password;
    private String day;
    private Month month;

}
