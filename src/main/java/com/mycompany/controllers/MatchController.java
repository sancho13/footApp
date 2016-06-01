package com.mycompany.controllers;

import com.mycompany.daos.MatchDao;
import com.mycompany.models.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Marseillais on 01/06/2016.
 */
@Controller
@RequestMapping("/matchs")
public class MatchController {


    @Autowired
    MatchDao matchDao;

    private static Iterable<Match> list=new ArrayList<Match>();


    @RequestMapping(value = "",method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Match> getAllMatchs()
    {
        list=matchDao.findAll();
        return list;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Match getMatch(@PathVariable("id") Long id)
    {
        list=matchDao.findAll();
        Match rCus=null;
        for(Match m:list)
        {
            if (m.getId().equals(id))
            {
                rCus=m;
            }
        }
        return rCus;
    }

    @RequestMapping(value ="",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addMatch(@RequestBody Match match)
    {
        matchDao.save(match);
        list=matchDao.findAll();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteMatch(@PathVariable("id")Long id)
    {
        list=matchDao.findAll();
        Match rCust=null;
        for(Match m:list)
        {
            if (m.getId().equals(id))
            {
                rCust=m;
            }
            if(rCust==null)
            {
                //Throw exception Customer not found
            }
            else {
                matchDao.delete(rCust);
                list=matchDao.findAll();

            }
        }

    }
}
