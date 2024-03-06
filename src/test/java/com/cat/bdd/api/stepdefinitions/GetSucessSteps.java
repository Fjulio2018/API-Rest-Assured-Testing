package com.cat.bdd.api.stepdefinitions;

import com.cat.bdd.api.support.api.VotoApi;
import com.cat.bdd.api.support.util.ResponseValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;
import java.util.Optional;

public class GetSucessSteps {
    Response respoData;
    String respoDataS;
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
        assertEquals(quantidadeEsperada, tamanhoRecebido);

    }

    @Dado("que eu realize um GET com parametros {}")
    public void que_eu_realize_um_get_com_parametros_valorparam(String valorparam) {

        System.out.println(valorparam);

        respoData = votoApi.realizarBuscaComParametro(valorparam);


    }


    @Quando("eu o valido o HttpStatusCode  {int}")
    public void eu_o_valido_o_http_status_code(int StstusCode) {
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

    @Dado("que tenha um votoId nao existente")
    public void que_tenha_um_voto_id_nao_existente() {
        /*
   Este cenário é apenas para contextualizar.
*/

    }
    @Dado("que tenha um votoId existente")
    public void que_tenha_um_voto_id_existente() {
        /*
   Este cenário é apenas para contextualizar.
*/
    }

    @Dado("que tenha um votoId existente e não tenha autorização")
    public void que_tenha_um_voto_id_existente_e_não_tenha_autorização() {
        /*
   Este cenário é apenas para contextualizar.
*/
    }

    @Quando("que eu realize um GET com  {} e {}")
    public void que_eu_realize_um_get_com_(String votoId, String apikey) {

        respoData = votoApi.realizarBuscaSemAutorizaçao(votoId,apikey);

    }

    @Dado("que eu realize um POST com parametros {}")
    public void que_eu_realize_um_post_com_parametros(String votoId) {

        respoData = votoApi.tentativaPostEmBusca(votoId);


    }

    @Entao("eu valido a mensagem {string} apresentada e o statuscode {int}")
    public void eu_valido_a_mensagem_apresentada_e_o_statuscode(String messagem, Integer StatusCode) throws JsonProcessingException {

        int codigoNaResposta = respoData.getStatusCode();
        Assert.assertEquals((int) StatusCode, codigoNaResposta);

        respoDataS = respoData.asString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode respostaNode = objectMapper.readTree(respoDataS);
        String mensagemNaResposta = respostaNode.get("message").asText();
        Assert.assertEquals(messagem, mensagemNaResposta);
    }

}
