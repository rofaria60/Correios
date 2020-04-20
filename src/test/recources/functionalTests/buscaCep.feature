# new feature
# Tags: optional
# language: pt
#utf-8


Funcionalidade: Buscar Cep
  Eu como cliente dos correios
  Quero procurar um endereço no Brasil
  Para saber informações do logradouro

   @codigopostal @teste1
  Esquema do Cenário: Busca endereço por Cep válido
    Dado que esteja na página de busca Cep Endereço no site dos correios
    Quando busco um "<cep>" válido
    Entao o site apresenta o resultado da busca realizada
    Exemplos:
      | cep      |
      | 05001200 |

   @codigopostal @teste2
  Esquema do Cenário: Busca logradouro com mais de um resultado
    Dado que esteja na página de busca Cep - Endereço no site dos correios
    Quando busco um "<logradouro>" válido
    Entao o site apresenta o resultado da busca realizada
    Exemplos:
      | logradouro      |
      | Ana maria costa |
