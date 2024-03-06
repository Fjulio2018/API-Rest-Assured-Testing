package com.cat.bdd.api.stepdefinitions;

import com.cat.bdd.api.support.api.VotoApi;
import com.cat.bdd.api.support.util.ResponseValidator;
import io.cucumber.java.Before;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GetSucessSteps {
    Response respoData;
    int quantidadeEsperada;

    private VotoApi votoApi;
    ResponseValidator responseValidate = new ResponseValidator();



    @Before
    public void setup() {

        votoApi = new VotoApi();



    }

    @Dado("que eu faca a busca com {int}")
    public void que_eu_faca_a_busca_com(int limit) {
        System.out.println("Este é o limite: " + limit);
        quantidadeEsperada = limit;
        respoData = votoApi.realizarBuscaComLimite(limit);



    }
    @Quando("validar o response")
    public void validarResponse() {
        respoData.then()
                .statusCode(200)
                .body(notNullValue());

        responseValidate.fromJson(respoData.asString());


        responseValidate.assertSize(quantidadeEsperada);
        responseValidate.assertItemValue(0, "id", 31102);
        responseValidate.assertItemValue(0, "image_id", "39i");

        if (quantidadeEsperada == 2) {
            responseValidate.assertItemValue(1, "id", 31103);
            responseValidate.assertItemValue(1, "image_id", "3mq");

        }
    }


    @Entao("valido a quantidade retornada")
    public void validarQuantidadeRetornada() {
        List<Object> jsonResponse = respoData.jsonPath().getList("$");
        int tamanhoRecebido = jsonResponse.size();
        Assert.assertEquals(quantidadeEsperada, tamanhoRecebido);

    }

    @Dado("que eu realize um GET com parametros {int}")
    public void que_eu_realize_um_get_com_parametros_valorparam(int valorparam) {

        System.out.println(valorparam);

        respoData = votoApi.realizarBuscaComParametro(valorparam);





    }


    @Quando("o HttpStatusCode sera {int}")
    public void oHttpStatusCodeSera(int StstusCode) {
        respoData.then()
                .statusCode(StstusCode)
                .body(notNullValue());
    }

    @Entao("eu valido o contrato")
    public void eu_valido_o_contrato() {

        ResponseValidator responseValidate = new ResponseValidator();
        responseValidate.fromJson(respoData.asString());
        responseValidate.assertJsonSchema("/schema/get_schema.json");
        //responseValidate.assertJsonSchema("/schema/get_Error.json");


    }

}
