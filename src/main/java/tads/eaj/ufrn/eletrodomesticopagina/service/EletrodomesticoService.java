package tads.eaj.ufrn.eletrodomesticopagina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.eletrodomesticopagina.model.Eletrodomestico;
import tads.eaj.ufrn.eletrodomesticopagina.repository.EletrodomesticoRepository;

import java.util.List;

@Service
public class EletrodomesticoService {

    private EletrodomesticoRepository repository;

    @Autowired
    public void setRepository(EletrodomesticoRepository repository) {
        this.repository = repository;
    }

    public List<Eletrodomestico> findAll(){
        return repository.findAll();
    }

    public void save(Eletrodomestico e){
        repository.save(e);
    }

    public Eletrodomestico getById(Long id){
        return repository.getById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
