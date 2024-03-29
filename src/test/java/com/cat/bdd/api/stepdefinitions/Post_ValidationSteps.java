package com.cat.bdd.api.stepdefinitions;

import com.cat.bdd.api.support.api.VotoApi;
import com.cat.bdd.api.support.util.ResponseValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Post_ValidationSteps {

    VotoApi votoApi = new VotoApi();
    ResponseValidator responseValidate;

    public Response getResponseBody() {
        return responseBody;
    }

    public Response responseBody;
    private Response response;


    private static String postId;

    public static String getPostId() {
        return postId;
    }


    @Dado("que eu performar o POST com dados do body")
    public void que_eu_performar_o_post_com_dados_do_body(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> listData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : listData) {
            JSONObject requestParams = new JSONObject();

            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();


                if ("image_id".equals(key) && "EMPTY".equalsIgnoreCase(value)) {
                    value = "";
                }

                requestParams.put(key, value);
            }


            responseBody = votoApi.realizarVoto(requestParams);
            postId = responseBody.jsonPath().getString("id");
            System.out.println("Este é o postID: " + postId);
        }
    }

    @Quando("eu validar o HttpStatusCode created")
    public void eu_validar_o_http_status_code_created() {
        Assert.assertEquals(responseBody.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @Entao("eu valido o contrato {string}")
    public void eu_valido_o_contrato(String nomeSchema) {

        responseValidate = new ResponseValidator();
        responseValidate.fromJson(responseBody.asString());
        responseValidate.assertJsonSchema("/schema/" + nomeSchema);


    }


    @Entao("eu valido o HttpStatusCode")
    public void eu_valido_o_HttpStatusCode(DataTable dataTable) {
        List<Map<String, String>> listData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : listData) {
            int statusCodeEsperado = Integer.parseInt(data.get("StatusCode"));
            int statusCodeAtual = responseBody.getStatusCode();
            Assert.assertEquals(statusCodeEsperado, statusCodeAtual);
        }
    }

    @Entao("eu valido a mensagem  retornada")
    public void eu_valido_a_mensagem_retornada(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String mensagemEsperada = data.get(0).get("mensagem");

        String mensagemAtual = responseBody.body().asString();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

}
