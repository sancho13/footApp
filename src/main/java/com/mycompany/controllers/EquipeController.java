package com.mycompany.controllers;

import com.mycompany.daos.EquipeDao;
import com.mycompany.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Marseillais on 01/06/2016.
 */
@Controller
@RequestMapping(value = "/equipes")
public class EquipeController {


    @Autowired
    EquipeDao equipeDao;



    private static Iterable<Equipe> list=new ArrayList<Equipe>();


    @RequestMapping(value = "",method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Equipe> getAllEquipes()
    {
        list=equipeDao.findAll();
        return list;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Equipe getEquipe(@PathVariable("id") Long id)
    {
        list=equipeDao.findAll();
        Equipe rCus=null;
        for(Equipe e:list)
        {
            if (e.getId().equals(id))
            {
                rCus=e;
            }
        }
        return rCus;
    }

    @RequestMapping(value ="",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addEquipe(@RequestBody Equipe equipe)
    {
        equipeDao.save(equipe);
        list=equipeDao.findAll();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteEquipe(@PathVariable("id")Long id)
    {
        list=equipeDao.findAll();
        Equipe rCust=null;
        for(Equipe e:list)
        {
            if (e.getId().equals(id))
            {
                rCust=e;
            }
            if(rCust==null)
            {
                //Throw exception Customer not found
            }
            else {
                equipeDao.delete(rCust);
                list=equipeDao.findAll();

            }
        }

    }


}
