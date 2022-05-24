# Versionamento de banco de dados na linguagem Java

	O versionamento de banco de dados em aplicações e importante para manter ordem e organização
	nos Scripts SQL que são executado no banco de dados. Assim, funcionando como um versionador desses
	scripts.
	Facilitando a sincronização da versão do banco de dados com a versão da aplicação, informar quais scirpts
	foram executados, automatizar a execução dos scripts, criar banco de dados do zero (caso necessário) e
	permite criar rollbacks de mudanças de banco de dados.
	

## 1. FerramentasÇ

	Nesse projeto, foi utilizado o Flyway, porém existem outras soluções como LiquiBase.
	
		1. Documentação do Flyway: [Flyway Docs](https://flywaydb.org/documentation/)
		2. Documentação do LiquiBase: [LiquiBase docs](https://docs.liquibase.com/home.html)