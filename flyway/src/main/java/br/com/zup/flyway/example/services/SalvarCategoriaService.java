package br.com.zup.flyway.example.services;

import br.com.zup.flyway.example.domains.Categoria;
import br.com.zup.flyway.example.repositories.CategoriaRepository;

public class SalvarCategoriaService {

	private final CategoriaRepository categoriaRepository;
	private final Categoria categoria;

	public SalvarCategoriaService(CategoriaRepository categoriaRepository, Categoria categoria) {
		this.categoriaRepository = categoriaRepository;
		this.categoria = categoria;
	}

	public Categoria executar() {
		return this.categoriaRepository.save(this.categoria);
	}
}
