package com.example.dartwebshop.controllers;

import com.example.dartwebshop.dao.BoardDAO;
import com.example.dartwebshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/boards")
public class BoardController {
    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> custom(){return this.boardDAO.getAllBoards();}
}
