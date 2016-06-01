package com.mycompany;

import com.mycompany.daos.EquipeDao;
import com.mycompany.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Marseillais on 30/05/2016.
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/hello")
public class HelloController {

  //  @Autowired
   // CustomerRepository rep;
    @Autowired
    EquipeDao equipeDao;

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Equipe Hello( )
    {
      //  return rep.findById(1L).get(0).getName();
        return equipeDao.findById(1L).get(0);
    }

  //  @RequestMapping(value = "",method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
   // @ResponseBody
    // String greetings(@RequestBody CustomerRepository rep)
    //{
      //  return (rep.findById(1L).get(0).getName());
    //}

}
