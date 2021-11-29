# ADR 002:Proposta de utilização do modelo Cliente-servidor
No modelo proposto na ADR 1, a aplicação do lado cliente se comportaria como um thin client, isto é, todo o processamento se daria do lado do servidor, que serviria para o lado cliente (navegador) uma view contendo as informações solicitadas. Por outro lado, em um modelo cliente-servidor, uma parte do processamento poderá ocorrer no lado cliente, que por sua vez pode solicitar as informações necessárias para o servidor de maneira assíncrona e transparente para o usuário. Embora o projeto inicial consista em uma aplicação web, o modelo cliente-servidor possibilita que a implementação da comunicação com o servidor ocorra através de uma API que, mais a frente, pode ser aproveitada para o desenvolvimento de um aplicativo mobile ou desktop.  O desenvolvimento de um aplicativo mobile/desktop mostra-se interessante por possibilitar a utilização de um cache que permita o acesso offline às informações obtidas pelo servidor, garantindo maior disponibilidade do serviço. A orientação a objetos permanece como estilo arquitetural subjacente para promover modularidade, encapsulamento de dados e possibilitar a implementação dos princípios e padrões de design. 
## Decisão
A ADR foi aprovada por unanimidade após debate entre todos os membros da equipe. 
## Status: Aceito 
## Consequências
Reconfiguração do projeto. 
