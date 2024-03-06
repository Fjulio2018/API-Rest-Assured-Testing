# language: pt

Funcionalidade: Valida ações do GET no /votes


  Esquema do Cenario: Validar limite
    Dado que eu faca a busca com <limite>
    Quando validar o response
    Entao valido a quantidade retornada

    Exemplos: Limites de quantidade votos
      | limite |
      | 1      |
      | 2      |
      | 5      |


  Esquema do Cenário: Validacao de contrato

    Dado   que eu realize um GET com parametros <vote_id>
    Quando eu o valido o HttpStatusCode  200
    Entao  eu valido o contrato

    Exemplos: Parametros para votos
    | vote_id |
    | 31102   |



  Esquema do Cenário: Validacao retorno de erro 404 no GET

    Dado que tenha um votoId nao existente
    Dado   que eu realize um GET com parametros <vote_id>
    Entao eu o valido o HttpStatusCode  404


    Exemplos: Parametros para votos
      | vote_id |
      | xpto   |


  Esquema do Cenário: Validacao retorno de erro 401 no GET

    Dado que tenha um votoId existente e não tenha autorização
    Quando   que eu realize um GET com  <vote_id> e <x-api-key>
    Entao eu o valido o HttpStatusCode  401


    Exemplos: Parametros para votos
      | vote_id |x-api-key|
      | 31102   |xpto     |


  Esquema do Cenário: Validacao retorno de erro 405 no GET

    Dado que tenha um votoId existente
    Dado   que eu realize um POST com parametros <vote_id>
    Entao   eu valido a mensagem <message> apresentada e o statuscode 405


    Exemplos: Parametros para votos
      | vote_id |message|
      | 31102   |"405- please consult the documentation for correct url to call. https://docs.thecatapi.com/"|