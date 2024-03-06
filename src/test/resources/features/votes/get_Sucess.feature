# language: pt

Funcionalidade: Valida ações do GET no /votes

@smoke
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
    Quando o HttpStatusCode sera 200
    Entao  eu valido o contrato

    Exemplos: Parametros para votos
    | vote_id |
    | 31102   |



