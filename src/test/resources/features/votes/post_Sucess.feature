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













