# language: pt

Funcionalidade: Valida ações do POST no /votes

  @skip
  Cenario:  Validar criação de votos e contrato

    Dado que eu performar o POST com dados do body
      | image_id  | sub_id          | value |
      | NmvEy8l-X | Francis-11-2024 | 15    |
      | NmvEy8l-X | Francis-12-2024 | 1     |

    Quando eu validar o HttpStatusCode created
    Entao eu valido o contrato "post_Schema.json"

  @skip
  Esquema do Cenário: Validações de campos obrigatorio no payloa
  -Até o momento a documentação não demonstra os campos
  -Partindo do principio que teodos os campos do payload são obrigatorios

    Dado que eu performar o POST com dados do body
      | image_id   | sub_id   | value   |
      | <image_id> | <sub_id> | <value> |
    Entao eu valido o HttpStatusCode
      | StatusCode   |
      | <StatusCode> |
    E  eu valido a mensagem  retornada
      | mensagem   |
      | <mensagem> |



    Exemplos: Validações de campos obrigatorio

      | Validação         | image_id  | sub_id          | value | StatusCode | mensagem                              |
      | Faltando image_id |           | Francis-11-2024 | 15    | 400        | "image_id" is required                |
      | Image_id empty    | EMPTY     | Francis-11-2024 | 15    | 400        | "image_id" is not allowed to be empty |
      | Image_id= "\"\"", | ""        | Francis-11-2024 | 15    | 400        | "image_id" is required                |
      | Faltando sub_id   | NmvEy8l-X |                 | 15    | 400        | "sub_id" is required                  |
      | Faltando sub_id   | NmvEy8l-X | EMPTY           | 15    | 400        | "sub_id" is not allowed to be empty   |
      | Faltando sub_id   | NmvEy8l-X | ""              | 15    | 400        | "sub_id" is required                  |
      | Faltando value    | NmvEy8l-X | Francis-11-2024 |       | 400        | "value" is required                   |
      | Faltando value    | NmvEy8l-X | Francis-11-2024 | EMPTY | 400        | "sub_id" is not allowed to be empty   |
      | Faltando value    | NmvEy8l-X | Francis-11-2024 | " "   | 400        | "value" is required                   |

















