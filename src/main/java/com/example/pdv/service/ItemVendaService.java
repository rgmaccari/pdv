package com.example.pdv.service;

import com.example.pdv.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemVendaService {
    @Autowired
    private ItemVendaRepository itemVendaRepository;
}
