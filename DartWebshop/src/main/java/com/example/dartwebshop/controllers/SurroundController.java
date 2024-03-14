package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.SurroundDAO;
import com.example.dartwebshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/surrounds")
public class SurroundController {
    @Autowired
    private SurroundDAO surroundDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> custom(){return this.surroundDAO.getAllSurrounds();}
}
