package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.ItemVenda;
import com.example.pdv.domain.Produto;
import com.example.pdv.domain.Venda;
import com.example.pdv.dto.ItemVendaDTO;
import com.example.pdv.dto.VendaDTO;
import com.example.pdv.repository.ClienteRepository;
import com.example.pdv.repository.ProdutoRepository;
import com.example.pdv.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Venda insert(VendaDTO dto){
        Venda venda = new Venda();

        List<ItemVenda> listaItens = new ArrayList<>();
        for(ItemVendaDTO itemDto : dto.getItensVenda()){
            Optional<Produto> produto = produtoRepository.findById(itemDto.getProdutoId());
            if(produto.isPresent()){
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setQuantidade(itemDto.getQuantidade());
                itemVenda.setValorUnitario(itemDto.getValorUnitario());
                itemVenda.setValorTotal(itemDto.getValorTotal());
                itemVenda.setVenda(venda);
                itemVenda.setProduto(produto.get());

                listaItens.add(itemVenda);
            }else{
                return null;
            }
        }

        String observacoes = dto.getObservacao();
        Cliente cliente = dto.getCliente();
        Date data = dto.getData();
        BigDecimal valorTotal = dto.getTotal();

        venda.setCliente(cliente);
        venda.setData(data);
        venda.setObservacao(observacoes);
        venda.setItensVenda(listaItens);
        venda.setTotal(valorTotal);

        venda = vendaRepository.save(venda);
        return venda;
    }

    public Venda update(Venda venda){
        return vendaRepository.save(venda);
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
