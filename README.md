# PIG BANK

![](https://github.com/diegojpatricio/pigbank/blob/main/assets/PIGBANK-LOGO.jpg)

## Descrição:
  A presente apicação foi desenvolvida como atividade da Disciplina de Desenvolvimento e Administração de Aplicações Web Avançadas do UNIESP.
  Refere-se a um sistema de uma instituição bancária para gerenciar suas contas, clientes e transações.</center>

### Tecnologias

PIG BANK usa alguams das tecnlogias mais recentes do mercado:

* [**JAVA**] - Linguagem multiplataforma de alto desempenho;
* [**SRPING BOOT**] - Framework para desenvolvimento de aplicações web/coporativas;
* [**POSTGRESQL**] - Banco de dados relacional de código aberto;
* [**ANGULAR**] - Framework para criar UI web com JavaScript;
* [**HEROKU**] - Plataforma em nuvem para manter as aplicações remotamente;


### API

Path's funcionando com os verbos HTTP (**GET, POST, PUT E DELETE**):

Para analizar a documentação no SWAGGER basta subir a aplicação e acessar: http://localhost:8080/swagger-ui/index.htm

* /contas
* /contas/{id}
* /cliente
* /contas/{id}
* /transacao/sacar
* /transacao/depositar
* /transacao/sacar
* /transacao/transferir

Para rodar localmente, é necessário fazer configuração do application.properties, como for de preferência;

    Configurar um username, password e url para o banco a ser usado, como a seguir:
    
        application.properties:            
            spring.datasource.url=jdbc:postgresql://localhost:5432/pigbank
            spring.datasource.username={user_name}
            spring.datasource.password={passowrd_name}
            spring.datasource.driver-class-name=org.postgresql.Driver
            spring.jpa.hibernate.ddl-auto=update
            spring.jpa.show-sql=true
            spring.jpa.properties.hibernate.formart_sql=true             
---

Maiores detalhes podem ser encontrados na documentação:
[spring-boot-documentação](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html)        
    

### INTERFACE 

![](https://github.com/diegojpatricio/pigbank/blob/main/assets/PIGBANK-HOME.jpg)

Link do Protótipo: https://www.figma.com/proto/sKoF5JSSjO778yJtxAQIEx/PIGBank?node-id=1%3A2&scaling=min-zoom

Para o desenvolvimento front-end da aplicação foi escolhido a tecnologia Angular. O projeto será desenvolvido em breve conforme orientação do protótipo.

### TODOS
* API
    - Desenvolverfront-end;
    - Desenvolver testes;
    - Adicionar segurança;


**Free Software!**

PROJETO UNIVERSITÁRIO DESENVOLVIDO POR [Diego Patrício](https://github.com/diegojpatricio)
