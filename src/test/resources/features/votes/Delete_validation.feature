# language: pt

Funcionalidade: Valida acoes do DELETE no /votes


  Esquema do Cenario:  Fluxo de criacao e delete
    Dado que eu performar o POST com dados do body
      | image_id   | sub_id   | value   |
      | <image_id> | <sub_id> | <value> |
    E validar o votoId
    Quando faço um DELETE
    Entao eu valido o HttpStatusCode para delete
      | StatusCode   |
      | <StatusCode> |

    Exemplos:

      | image_id  | sub_id          | value | StatusCode |
      | NmvEy8l-X | Francis-11-2024 | 15    | 200        |





