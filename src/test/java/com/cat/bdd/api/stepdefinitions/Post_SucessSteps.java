package com.cat.bdd.api.stepdefinitions;

import com.cat.bdd.api.support.api.VotoApi;
import com.cat.bdd.api.support.util.ResponseValidator;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Post_SucessSteps {

    VotoApi votoApi = new VotoApi();
    ResponseValidator responseValidate;
    Response ResponseBody;

    @Dado("que eu performar o POST com dados do body")
    public void que_eu_performar_o_post_com_dados_do_body(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> listData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : listData) {
            JSONObject requestParams = new JSONObject();

            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                requestParams.put(key, value);
            }

            ResponseBody = votoApi.realizarVoto(requestParams);

        }
    }

    @Quando("eu validar o HttpStatusCode created")
    public void eu_validar_o_http_status_code_created() {
        Assert.assertEquals(ResponseBody.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Entao("eu valido o contrato {string}")
    public void eu_valido_o_contrato(String nomeSchema)  {

        responseValidate = new ResponseValidator();
        responseValidate.fromJson(ResponseBody.asString());
        responseValidate.assertJsonSchema("/schema/" + nomeSchema);


    }
}
