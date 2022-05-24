package br.com.zup.flyway.example.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zup.flyway.example.domains.Livro;
import br.com.zup.flyway.example.repositories.CategoriaRepository;
import br.com.zup.flyway.example.repositories.LivroRepository;
import br.com.zup.flyway.example.services.BuscarCategoriaPorNomeService;
import br.com.zup.flyway.example.services.SalvarLivroService;

@Configuration
public class SalvarLivro implements ApplicationRunner {
	private final static Logger LOGGER = LoggerFactory.getLogger(SalvarLivro.class);
	private final LivroRepository livroRepository;
	private final CategoriaRepository categoriaRepository;

	public SalvarLivro(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
		this.livroRepository = livroRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Livro livro = new Livro();
		livro.setTitulo("Harry Poitter");
		livro.setAutor("J K ");

		BuscarCategoriaPorNomeService buscarCategoriaPorNomeService = new BuscarCategoriaPorNomeService(
				categoriaRepository, "Romance");
		SalvarLivroService salvarLivroService = new SalvarLivroService(livro, livroRepository,
				buscarCategoriaPorNomeService);

		salvarLivroService.executar();

		LOGGER.info("execute - id do livro : {}", livro.getId());
	}

}
