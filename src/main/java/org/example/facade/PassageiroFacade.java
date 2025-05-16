package org.example.facade;

import org.example.entities.Passageiro;
import org.example.repositories.PassageiroRepository;
import org.example.services.PassageiroService;

import java.util.List;

public class PassageiroFacade {
    private PassageiroRepository repository = new PassageiroRepository();
    private PassageiroService service = new PassageiroService();
    private int contagemPassageiros = 1;

    public boolean cadastrarPassageiro(String nome, String cpf, String email) {
        if (!service.validarCpf(cpf) || !service.validarEmail(email)) {
            return false;
        }
        Passageiro passageiro = new Passageiro(contagemPassageiros++, nome, cpf, email);
        repository.salvar(passageiro);
        return true;
    }

    public List<Passageiro> listar() {
        return repository.listarTodos();
    }
}
