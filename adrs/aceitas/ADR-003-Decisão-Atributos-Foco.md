# ADR 003:Decisão dos atributos foco

Feita a decisão do estilo arquitetural, nos voltamos para definir quais atributos seriam essenciais para nosso projeto e quais não necessitam de dedicação e tempo do projeto. Identificamos que os atributos relacionados a um projeto são disponibilidade, modificabilidade, performance, segurança e usabilidade. Com os atributos definidos concluímos que a disponibilidade, modificabilidade e usabilidade são atributos essenciais para o projeto. Como acessar o aplicativo a qualquer momento e ele seja localizado dependendo em que  país ele seja acessado, sua disponibilidade, a possibilidade de exportar o aplicativo para outras plataformas na forma de um aplicativo mobile ou desktop, sua modificabilidade, e ele ser de fácil uso é essencial para sua implantação e difusão, pois os usuários vão ser de diferentes grupos e até mesmo de outras línguas, sua usabilidade. Os aspectos de segurança e performance não serão essenciais pela escolha da arquitetura e decisões de como os dados dos usuários serão tratados. Como nenhum dado além de um usuário será armazenado no banco de dados do sistema não existe preocupação de vazamento ou mau uso dos dados dos usuários, além disso parte do processamento do aplicativo será feito na máquina do próprio usuário, reduzindo a carga nos servidores do aplicativo, fazendo com que a performance não ser um foco do desenvolvimento.

## Decisão
A ADR foi aceita após levar os requisitos para o engenheiro de software.

## Status: Aceito

## Consequências
O foco do desenvolvimento foi definido.
