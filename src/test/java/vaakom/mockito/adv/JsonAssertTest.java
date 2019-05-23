package vaakom.mockito.adv;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponce = "{" +
            "    \"id\": 1," +
            "    \"name\": \"Ball\"," +
            "    \"price\": 10," +
            "    \"quantity\": 5" +
            "}";

    @Test
    public void jsonAssertStrict() throws JSONException {

        String expectedResponce = "{" +
                "    \"id\": 1," +
                "    \"name\": \"Ball\"," +
                "    \"price\": 10," +
                "    \"quantity\": 5" +
                "}";

        JSONAssert.assertEquals(expectedResponce, actualResponce, true);
    }

    @Test
    public void jsonAssertNotStrict() throws JSONException {

        String expectedResponce = "{" +
                "    \"id\": 1," +
                "    \"name\": \"Ball\"" +
                "}";

        JSONAssert.assertEquals(expectedResponce, actualResponce, false);
    }

    @Test
    public void jsonAssertNoEscapes() throws JSONException {

        String expectedResponce = "{id: 1, name: \"Ball\", price: 10, quantity: 5}";

        JSONAssert.assertEquals(expectedResponce, actualResponce, true);
    }

}
