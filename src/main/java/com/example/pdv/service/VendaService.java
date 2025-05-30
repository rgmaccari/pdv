package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.ItemVenda;
import com.example.pdv.domain.Produto;
import com.example.pdv.domain.Venda;
import com.example.pdv.dto.InsertItemVendaDTO;
import com.example.pdv.dto.InsertVendaDTO;
import com.example.pdv.dto.UpdateItemVendaDto;
import com.example.pdv.dto.UpdateVendaDTO;
import com.example.pdv.repository.ItemVendaRepository;
import com.example.pdv.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private ClienteService clienteService;

    public Venda insert(InsertVendaDTO dto){
        Venda venda = new Venda(dto);

        List<ItemVenda> listaItens = new ArrayList<>();
        for(InsertItemVendaDTO itemDto : dto.getItensVenda()){
            Produto produto = produtoService.findById(itemDto.getProdutoId());

            ItemVenda itemVenda = new ItemVenda(itemDto, venda, produto);
            listaItens.add(itemVenda);
        }

        Cliente cliente = clienteService.findById(dto.getClienteId());

        venda.setCliente(cliente);
        venda.setItensVenda(listaItens);

        venda = vendaRepository.save(venda);
        return venda;
    }

    public Venda update(Integer id, UpdateVendaDTO dto){
        Venda venda = findById(id);

        venda.setObservacao(dto.getObservacao());

        Cliente cliente = clienteService.findById(dto.getClienteId());
        venda.setCliente(cliente);

        //Esse método limpa os itens vendas do objeto que representa essa venda no banco.
        venda.getItensVenda().clear();

        //O for grava novamente os itens venda passados no dto.
        // Se o item Venda do dto tem id, vai ser atualizadoo registro no banco.
        //  Caso não tenha, será criado um novo registro.
        for(UpdateItemVendaDto itemDto : dto.getItensVenda()){
            Produto produto = produtoService.findById(itemDto.getProdutoId());

            if(itemDto.getId() != null){
                if(!itemVendaRepository.existsByIdAndVenda(itemDto.getId(), venda))
                    throw new EntityNotFoundException(
                            "item da venda, id " + itemDto.getId() + " não encontrado na venda informada.");
            }

            ItemVenda itemVenda = new ItemVenda(itemDto, venda, produto);

            venda.getItensVenda().add(itemVenda);
        }

        //Ao salvar essa venda,o jpa vai excluir o itens vendas gravados anteriormente e não inclusos nesse update.
        //Isso acontece devido ao orphanRemoval = true, no atributo itensVenda da entidade Venda.
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll(){
        List<Venda> vendas = vendaRepository.findAll();

        if(vendas.isEmpty())
            throw new EntityNotFoundException("Não foram encontradas vendas.");

        return vendas;
    }

    public Venda findById(Integer id){
        Optional<Venda>  venda =  vendaRepository.findById(id);

        if(venda.isEmpty())
            throw new EntityNotFoundException("Venda id " + id + " não encontrada.");

        return venda.get();
    }

    public void delete(Integer id){
        if(!vendaRepository.existsById(id))
            throw new EntityNotFoundException("Venda id " + id + " não encontrada.");

        vendaRepository.deleteById(id);
    }
}
