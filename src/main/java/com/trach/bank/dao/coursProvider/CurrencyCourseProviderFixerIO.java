package com.trach.bank.dao.coursProvider;

import com.trach.bank.model.Currency;
import com.trach.bank.utils.JsonReader;
import org.json.JSONObject;



public class CurrencyCourseProviderFixerIO implements  CurrencyСourseProvider {
    private final String access_key;

    private final String baseUrl;


    public CurrencyCourseProviderFixerIO(String access_key, String baseUrl) {
        this.access_key = access_key;
        this.baseUrl = baseUrl;


    }

    @Override
    public float getCourse(Currency of) {
        String url = baseUrl + "?access_key=" + access_key + "&symbols=" + of.toString();
        JsonReader jsonReader = new JsonReader();
        JSONObject jsonObject = jsonReader.readJsonFromUrl(url);
        JSONObject rates = jsonObject.getJSONObject("rates");

       return rates.getFloat(of.toString());

        }



}
