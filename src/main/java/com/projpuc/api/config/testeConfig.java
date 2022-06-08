package com.projpuc.api.config;

import com.projpuc.api.repository.PerfilRepositorio;
import com.projpuc.api.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class testeConfig implements CommandLineRunner {
    @Autowired
    private PerfilRepositorio repositorio;

    @Override
    public void run(String... args) throws Exception {
        Perfil perfil = new Perfil(null, "Rubens", "123456", "Masc", "rubens@", "999999999", "28-04-1974", "ADM");
        Perfil perfil2 = new Perfil(null, "Rubens Leme", "123456", "Masc", "rubens@", "999999999", "28-04-1974", "ADM");
        repositorio.saveAll(Arrays.asList(perfil, perfil2));

    }
}
