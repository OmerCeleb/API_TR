package gmi_bank;

import baseUrl.GMIBankBaseUrl;
import org.junit.Test;
import pojos.gmibank.CountryPojo;
import pojos.gmibank.StatesPojo;

import java.util.ArrayList;
import java.util.List;

public class PostCountry extends GMIBankBaseUrl {

    /*
    https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dökumanini kullanarak en az 3 tane "state" iceren
    bir "country" olusturan bir otomasyon testi yaziniz
    Not: Autherization icin headers'a "Authorization" = Bearer abc123 seklinde Bearer token giriniz.

     */


    /*
            Given
                https://gmibank.com/api/tp-countries
            And
                {
                    "name": "Muz Cumhuriyeti",
                    "states": [
                        {
                            "id": 1,
                            "name": "Elma"
                        },
                        {
                            "id": 2,
                            "name": "Armut"
                        },
                        {
                            "id": 3,
                            "name": "Portakal"
                        }
                    ]
                }
                When
                    Kullanici POST Request gönderir
                Then
                    Status Code: 201
                And
                                           {
                        "id": 199122,
                        "name": "Muz Cumhuriyeti",
                        "states": [
                            {
                                "id": 1,
                                "name": "Elma",
                                "tpcountry": null
                            },
                            {
                                "id": 2,
                                "name": "Armut",
                                "tpcountry": null
                            },
                            {
                                "id": 3,
                                "name": "Portakal",
                                "tpcountry": null
                            }
                        ]
                    }
     */

    @Test
    public void post01() {
        // Set the URL
        spec.pathParams("first", "api", "second", "tp-countries");

        // Set the expected data
        StatesPojo state1 = new StatesPojo(1, "Elma");
        StatesPojo state2 = new StatesPojo(2, "Armut");
        StatesPojo state3 = new StatesPojo(3, "Portakal");

        List<StatesPojo> stateList = new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        // 2. yol
//        List<StatesPojo> stateList2 = List.of(
//                new StatesPojo(1, "Elma")
//                , new StatesPojo(2, "Armut")
//                , new StatesPojo(3, "Portakal")
//        );

        CountryPojo payload = new CountryPojo("Muz Cumhuriyeti", stateList);



    }
}
