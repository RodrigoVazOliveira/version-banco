package br.com.zup.flyway.example.services;

import br.com.zup.flyway.example.domains.Categoria;
import br.com.zup.flyway.example.domains.Livro;
import br.com.zup.flyway.example.repositories.LivroRepository;

public class SalvarLivroService {

	private final Livro livro;
	private final LivroRepository livroRepository;
	private final BuscarCategoriaPorNomeService buscarCategoriaPorNomeService;

	public SalvarLivroService(Livro livro, LivroRepository livroRepository,
			BuscarCategoriaPorNomeService buscarCategoriaPorNomeService) {
		this.livro = livro;
		this.livroRepository = livroRepository;
		this.buscarCategoriaPorNomeService = buscarCategoriaPorNomeService;
	}

	public Livro executar() {
		Categoria categoria = this.buscarCategoriaPorNomeService.executar();
		this.livro.setCategoria(categoria);

		return this.livroRepository.save(this.livro);
	}
}
