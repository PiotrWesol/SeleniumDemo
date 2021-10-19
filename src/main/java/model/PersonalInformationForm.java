package model;

import enums.Month;
import lombok.Data;

@Data
public class PersonalInformationForm {

    private String firstName;
    private String lastName;
    private String password;
    private String day;
    private Month month;

}
