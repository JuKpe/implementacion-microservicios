package com.juancarlos.customerservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
@Setter
@Getter
public class TestVaultController {

    //Esta propiedad (name) está guardada en VAULT.
    //Si el servidor de VAULT se apaga, el valor de name se pierde.
    @Value("${name}")
    private String valorName;

    @GetMapping(value = "testvalor")
    public String getValor() {
        return valorName;
    }

}
