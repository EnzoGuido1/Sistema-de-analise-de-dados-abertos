# Sistema de análise de dados: Senado e Câmara dos Deputados
Trabalho da disciplina de Bancos de Dados I, destinado a implementar um banco de dados e um sistema simples capaz de realizar algumas consultas básicas. Neste projeto escolhemos utilizar como conjuntos de dados as despesas orçamentais dos deputados federais e senadores do brasil. Utilizamos também outros dados complementares, com o intuito de enriquecer o banco de dados, como votações, proposições, eleições e legislaturas e, futuramente, gerar relatórios incluindo estes novos dados.

## Descrição dos conjuntos utilizados
Senador: dados do político
Deputado Federal: dados do político
Despesa: dados da despesa, tais como detalhamento, valor, tipo...
Fornecedor: dados do fornecedor de uma despesa
Partido: relação de político afilido a um partido
Eleição: resultado das eleições em seus decorrentes anos
Legislatura: dados de um mandato de um político
Votação: dados de uma votação (projeto de lei) proposta por um deputado federal

## Tecnologias utilizadas

* Postgres 14.5-1
* Jakarta EE 10.0
* NetBeans IDE 15