package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.ShirtDAO;
import com.example.dartwebshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shirts")
public class ShirtController {
    @Autowired
    private ShirtDAO shirtDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> custom(){return this.shirtDAO.getAllShirts();}
}
