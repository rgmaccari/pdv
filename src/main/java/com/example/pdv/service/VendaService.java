package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.ItemVenda;
import com.example.pdv.domain.Produto;
import com.example.pdv.domain.Venda;
import com.example.pdv.dto.ItemVendaDTO;
import com.example.pdv.dto.InsertVendaDTO;
import com.example.pdv.dto.UpdateVendaDTO;
import com.example.pdv.repository.VendaRepository;
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
    private ClienteService clienteService;

    public Venda insert(InsertVendaDTO dto){
        Venda venda = new Venda(dto);

        List<ItemVenda> listaItens = new ArrayList<>();
        for(ItemVendaDTO itemDto : dto.getItensVenda()){
            Produto produto = produtoService.findById(itemDto.getProdutoId());

            ItemVenda itemVenda = new ItemVenda(itemDto);
            itemVenda.setVenda(venda);
            itemVenda.setProduto(produto);

            listaItens.add(itemVenda);
        }

        Cliente cliente = clienteService.findById(dto.getClienteId());

        venda.setCliente(cliente);
        venda.setItensVenda(listaItens);

        venda = vendaRepository.save(venda);
        return venda;
    }

    public Venda update(Integer id, UpdateVendaDTO dto){
        Optional<Venda> venda = vendaRepository.findById(id);
        Venda vendaAtualizada = new Venda();
        vendaAtualizada = venda.get();

        vendaAtualizada.setObservacao(dto.getObservacao());
        vendaAtualizada.setData(dto.getData());


        return vendaRepository.save(vendaAtualizada);
    }

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Integer id){
        return vendaRepository.findById(id);
    }

    public void delete(Integer id){
        vendaRepository.deleteById(id);
    }
}
