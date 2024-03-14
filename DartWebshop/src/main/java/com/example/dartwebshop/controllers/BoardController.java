package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.BoardDAO;
import com.example.dartwebshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/boards")
public class BoardController {
    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> custom(){return this.boardDAO.getAllBoards();}
}
