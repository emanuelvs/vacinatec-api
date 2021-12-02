# ADR 006:Proposta de utilização do modelo Cliente-servidor
Para garantir a Disponibilidade utilizamos as taticas de:
Monitoração:
  Log (todo nosso código precisa fazer um log de ações realizadas)
  Ping/pong por meio do Módulo de monitoramento
Recovery:
  Exception Handling: A ideia é não deixar o usuário saber que ocorreu um erro
  Retry: Caso aconteceu um erro conhecido, é possível mascarar este erro
  para o usuário por meio de um retry
Prevenção
  Caso algum servidor esteja morto, o módulo de monitoramento é o responsável
  para desativar o acesso ao nome do servidor morto nos servidores DNS. 
## Decisão
A ADR foi aprovada por ser um atributo muito importante para a equipe
## Status: Aceito 
## Consequências
refatoração de funções.
