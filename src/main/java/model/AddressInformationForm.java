package model;

import enums.Country;
import enums.State;
import lombok.Data;

@Data
public class AddressInformationForm {

    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private State selectState;
    private String city;
    private String postCode;
    private Country country;
    private String additionalInformation;
    private String mobilePhone;


}
