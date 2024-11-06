package gmi_bank;

import org.junit.Test;

public class GetCustomer {

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
     */

    @Test
    public void getCustomer() {
        // Set the expected data


    }
}
