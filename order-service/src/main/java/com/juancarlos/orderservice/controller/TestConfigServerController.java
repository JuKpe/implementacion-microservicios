package com.juancarlos.orderservice.controller;

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
public class TestConfigServerController {

    @Value("${app.testProperties}")
    private String valor;

    @GetMapping(value = "testvalor")
    public String getValor() {
        return valor;
    }
}
