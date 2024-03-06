package com.cat.bdd.api.stepdefinitions;

import com.cat.bdd.api.support.api.VotoApi;
import com.cat.bdd.api.support.util.ResponseValidator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DeleteValidationSteps {
    private VotoApi votoApi;
    private Post_ValidationSteps postVali;
    private Response respoData;

    private static String postId;

    @Before
    public void setup() {
        votoApi = new VotoApi();
        postVali = new Post_ValidationSteps();
        respoData = postVali.getResponseBody();  // Initialize it here if needed in setup
    }

    @Dado("validar o votoId")
    public void validar_o_voto_id() {
        postId = Post_ValidationSteps.getPostId();
        System.out.println("ID extraído da resposta: " + postId);
    }


    @Quando("faço um DELETE")
    public void faço_um_delete() {
        respoData = votoApi.deletaVoto(postId);

    }

    @Entao("eu valido o HttpStatusCode para delete")
    public void eu_valido_o_HttpStatusCode(DataTable dataTable) {
        List<Map<String, String>> listData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : listData) {
            int statusCodeEsperado = Integer.parseInt(data.get("StatusCode"));
            System.out.println(statusCodeEsperado);
            int statusCodeAtual = respoData.getStatusCode();
            System.out.println(statusCodeAtual);
            Assert.assertEquals(statusCodeEsperado, statusCodeAtual);
        }
    }
}
