package br.com.zup.flyway.example.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zup.flyway.example.domains.Categoria;
import br.com.zup.flyway.example.repositories.CategoriaRepository;
import br.com.zup.flyway.example.services.SalvarCategoriaService;

@Configuration
public class SalvarCategoria implements ApplicationRunner {
	private final static Logger LOGGER = LoggerFactory.getLogger(SalvarCategoria.class);
	private final CategoriaRepository categoriaRepository;

	public SalvarCategoria(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setNome("Drama");

		SalvarCategoriaService salvarCategoriaService = new SalvarCategoriaService(this.categoriaRepository, categoria);
		salvarCategoriaService.executar();

		LOGGER.info("Salvar categoria - id : {}", categoria.getId());
	}

}
