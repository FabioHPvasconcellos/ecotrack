package br.com.ecotrack.ecotrack.service;

import br.com.ecotrack.ecotrack.model.Empresa; // Import atualizado
import br.com.ecotrack.ecotrack.model.Usuario;
import br.com.ecotrack.ecotrack.repository.EmpresaRepository;
import br.com.ecotrack.ecotrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void cadastrarEmpresaComDono(Empresa empresa, Usuario usuario) {
        // Primeiro salvamos a empresa no banco
        Empresa empresaSalva = empresaRepository.save(empresa);

        // Atribuímos a empresa recém-criada ao usuário
        usuario.setEmpresa(empresaSalva);

        // Salvamos o usuário
        usuarioRepository.save(usuario);
    }
}