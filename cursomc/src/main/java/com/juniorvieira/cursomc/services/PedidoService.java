package com.juniorvieira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorvieira.cursomc.domain.Pedido;
import com.juniorvieira.cursomc.repositories.PedidoRepository;
import com.juniorvieira.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! "
				+ " Id: " + id + ", Tipo: " + Pedido.class.getName())
		);
	}

}