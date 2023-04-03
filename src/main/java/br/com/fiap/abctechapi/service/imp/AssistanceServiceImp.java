package br.com.fiap.abctechapi.service.imp;

import br.com.fiap.abctechapi.model.Assistance;
import br.com.fiap.abctechapi.repository.AssistenceRepository;
import br.com.fiap.abctechapi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImp implements AssistanceService {

    private final AssistenceRepository repository;
    @Autowired
    public AssistanceServiceImp(AssistenceRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Assistance> getAssistanceList() {
        return repository.findAll();
    }
}
