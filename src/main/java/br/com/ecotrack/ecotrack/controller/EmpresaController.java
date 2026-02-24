package br.com.ecotrack.ecotrack.controller;

import br.com.ecotrack.ecotrack.model.Empresa;
import br.com.ecotrack.ecotrack.model.Usuario;
import br.com.ecotrack.ecotrack.model.enums.TipoEmpresa;
import br.com.ecotrack.ecotrack.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping("/teste-cadastro")
    public String testar() {
        try {
            // 1. Criando uma empresa fictícia para teste
            Empresa e = new Empresa();
            e.setRazaoSocial("EcoTrack Logística LTDA");
            e.setCnpj("12345678000100");
            e.setTipo(TipoEmpresa.ARMAZEM);

            // 2. Criando o usuário dono dessa empresa
            Usuario u = new Usuario();
            u.setNome("Fabio Administrador");
            u.setEmail("fabio@ecotrack.com");
            u.setSenha("123456");

            // 3. Chamando o service para salvar ambos no Postgres
            cadastroService.cadastrarEmpresaComDono(e, u);

            return "Sucesso! Empresa e Usuário gravados no Postgres.";

        } catch (Exception ex) {
            return "Erro ao cadastrar: " + ex.getMessage();
        }
    }
}