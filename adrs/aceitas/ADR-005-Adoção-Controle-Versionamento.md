# ADR 005: Adoção de Sistema de Controle de Versionamento com acesso em rede

O protótipo do sistema vem sendo feito de maneira local pelo time de desenvolvimento sem a utilização de nenhum sistema de versionamento. Levando em consideração o aumento da complexidade do projeto e a necessidade de acesso remoto continuado ao código, propõe-se a adoção de um sistema de controle de versionamento a ser hospedado em um servidor, que permita a replicação, modificação e extensão da base de código de maneira mais segura e organizada, por todos os integrantes do projeto que necessitem. Sugere-se o sistema git, por ser amplamente utilizado e bem documentado, e possibilitar o acompanhamento de todo o histórico de desenvolvimento da base de código. 

## Decisão
Aceito por unanimidade após debate entre os membros da equipe. 

## Status
Uma das opções: Aceito

## Consequências
Migração da base de código para servidor com Git. Especificamente, um repositório privado do Github.
