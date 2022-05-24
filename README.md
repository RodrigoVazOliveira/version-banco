# Versionamento de banco de dados na linguagem Java

O versionamento de banco de dados em aplicações e importante para manter ordem e organização
nos Scripts SQL que são executado no banco de dados. Assim, funcionando como um versionador desses
scripts.
Facilitando a sincronização da versão do banco de dados com a versão da aplicação, informar quais scirpts
foram executados, automatizar a execução dos scripts, criar banco de dados do zero (caso necessário) e
permite criar rollbacks de mudanças de banco de dados.


## 1. Ferramentas:

Nesse projeto, foi utilizado o Flyway, porém existem outras soluções como LiquiBase.
	
1. Documentação do Flyway: [docs](https://flywaydb.org/documentation/)
2. Documentação do LiquiBase: [docs](https://docs.liquibase.com/home.html)

## 2. Visão Geral do Flyway:
	
O Flyway e usado em aplicações Java, disponível para gerenciadores de pacote/dependencia como maven e glade.
Possui também possui versão CLI (Command Line).
Sendo possivel fazer sincronização no servidor, localmente, etc.

O Flyway basicamente, vocẽ escreve suas DDLs e MMLs em determinada pasta com determinado nomeclatura, assim o ele
executa esses escripts criando uma tabela com essas informações, sendo: Qual script rodou, seu checksum, data e horario de execução e 
estado da execução. Criando um histórico das versões que foram executadas.
Cada novo arquivo e uma nova versão, independentimente do comando que será feito.

Os scripts devem estar em determinada pasta e com as nomeclaturas:

![Imagem com os tipos de arquivo](tipo_arquivos_migration.png)


## 2.1. Tipos de migrations

	Existem duas formas de migrations: Regular e desfazer (undo).
	As regulares sao feitas no arquivos de que comecem com V e R, ja de desfazer e no arquivo U (disponivel apenas em versoes do Flyway Teams ou Enterprise Edition).

## 2.2. Executanto migrations:

O Flyway pode ser executado pela sua aplicacao (caso queira) ou pela linha de comando (instalando ele ou usando como plugin no maven)


Para o plugin o maven deve executar:

```console
$ mvn flyway:migrate -Dflyway.configFiles=flywayConfig.conf
```

Para executar com CLI:

```console
$ flyway migrate
```

Com o comando acima, sera executado as migrations que foram definidas nos arquivos, e sera executado em ordem das versoes.

__IMPORTANTE:__  Quando se criar um versao de arquivo V1 ou U1, nao se deve mais modificar
Para fazer uma nova modificacao sera necessario criar um nova veersao.

---

## 3. Usando Flyway com Spring Boot com JPA
	
	1. Para usar com Spring basta adicionar a dependencia no maven e o plugin (opcional) abaixo:
	
	```xml
		<dependencies>
			...
			<dependency>
				<groupId>org.flywaydb</groupId>
				<artifactId>flyway-core</artifactId>
			</dependency>
		</dependencies>
		<build>
			<plugins>
				...
				<plugin>
					<groupId>org.flywaydb</groupId>
					<artifactId>flyway-maven-plugin</artifactId>
				</plugin>
			</plugins>
		</build>
	```

__Observacao:__  A vantagem de usar o plugin e que nao e necessario rodar a aplicacao toda para executar migrations.

	2. Faca as configuracoes convesionais de banco de dados do spring com JPA. Example no arquivo application.propeties:
	
	```properties
	spring.datasource.url=jdbc:mariadb://localhost:3306/seubancodedados
	spring.datasource.username=user
	spring.datasource.password=user
	spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
	```

	3. Criar as migrations na pasta resources/db/migration conforme nomeclaturas mencionadas.

![arquivos de versao do flyway](resources.png)

	4. Executar a aplicacao spring ou usar o plugin na linha de comando. (conforme mencionado na secao 2.2)
	
![exemplo migration](example-migration.png)

## 4. Comandos do Flyway:

1. migrate - executa os scripts que existem. Tambem faz validacao, se alguma versao foi modificada.
2. validate - valida se alguma arquivo que ja foi migrado foi modificado e se existe migracao a ser feita.
3. info - exibe as informacoes das migracoes ja realizadas. 
4. clean - limpa todo o banco de dados.
5. repair - repara a tabela de historico

