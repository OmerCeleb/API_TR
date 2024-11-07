package gmi_bank;

import baseUrl.GMIBankBaseUrl;
import org.junit.Test;
import pojos.gmibank.AccountPojo;
import pojos.gmibank.CountryPojo;
import pojos.gmibank.UserPojo;

import java.util.ArrayList;
import java.util.List;

public class GetCustomer extends GMIBankBaseUrl {

    /*
            Given
                https://gmibank.com/api/tp-customers/133986
            When
                User sends GET request
            Then
                Status code: 200
            And
                Response body be like;

                                {
                  "accounts": [
                    {
                      "accountStatusType": "ACTIVE",
                      "accountType": "CHECKING",
                      "accountlogs": [
                        {
                          "description": "string",
                          "id": 0,
                          "newBalance": 0,
                          "tpaccount": "string",
                          "transactionAmount": 0,
                          "transactionDate": "2024-11-06T21:48:45.950Z"
                        }
                      ],
                      "balance": 0,
                      "closedDate": "2024-11-06T21:48:45.950Z",
                      "createDate": "2024-11-06T21:48:45.950Z",
                      "description": "string",
                      "employee": {
                        "address": "string",
                        "city": "string",
                        "country": {
                          "id": 0,
                          "name": "string",
                          "states": [
                            {
                              "id": 0,
                              "name": "string",
                              "tpcountry": "string"
                            }
                          ]
                        },
                        "createDate": "2024-11-06T21:48:45.950Z",
                        "email": "string",
                        "firstName": "string",
                        "hireDate": "2024-11-06T21:48:45.950Z",
                        "id": 0,
                        "lastName": "string",
                        "manager": "string",
                        "mobilePhoneNumber": "string",
                        "phoneNumber": "string",
                        "ssn": "string",
                        "state": "string",
                        "user": {
                          "activated": true,
                          "email": "string",
                          "firstName": "string",
                          "id": 0,
                          "imageUrl": "string",
                          "langKey": "string",
                          "lastName": "string",
                          "login": "string",
                          "resetDate": "2024-11-06T21:48:45.950Z"
                        },
                        "zipCode": "string"
                      },
                      "id": 0
                    }
                  ],
                  "address": "string",
                  "city": "string",
                  "country": {
                    "id": 0,
                    "name": "string",
                    "

                    CustomerPojo
                    CountryPojo
                    AccountPojo
                    StatesPojo
     */

    @Test
    public void getCustomer() {
        // Set the expected data
        spec.pathParams("first", "tp-customers", "second", "133986");

        CountryPojo country = new CountryPojo(187679, "Banana", null);
        UserPojo userPojo = new UserPojo(134701, "raymundo.moen", "Danika", "Huel", "danikahuel@gmail.com", true, "en", null, null);
        AccountPojo account1 = new AccountPojo(12481, "Description", 0, "CHEKING", "ACTIVE", "2022-01-04T21:00:00Z", "2022-01-04T21:00:00Z", null, null);
        AccountPojo account2 = new AccountPojo(131776, "mfy", 546846, "CREDIT_CARD", "ACTIVE", "2022-01-18T21:00:00Z", "2022-01-18T21:00:00Z", null, null);

        List<AccountPojo> accountPojoList = new ArrayList<>();
        accountPojoList.add(account1);
        accountPojoList.add(account2);


    }
}
