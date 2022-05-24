package br.com.zup.flyway.example.services;

import java.util.Optional;

import br.com.zup.flyway.example.domains.Categoria;
import br.com.zup.flyway.example.repositories.CategoriaRepository;

public class BuscarCategoriaPorNomeService {
	private final CategoriaRepository categoriaRepository;
	private final String nome;

	public BuscarCategoriaPorNomeService(CategoriaRepository categoriaRepository, String nome) {
		this.categoriaRepository = categoriaRepository;
		this.nome = nome;
	}

	public Categoria executar() {
		Categoria categoria = this.buscarCategoriaPorNome(this.nome);

		return categoria;
	}

	private Categoria buscarCategoriaPorNome(String nome) {
		Optional<Categoria> optionalCategoria = this.categoriaRepository.findByNome(nome);

		if (optionalCategoria.isEmpty()) {
			throw new RuntimeException("Categoria com o nome informado nao existe!");
		}

		return optionalCategoria.get();
	}
}
