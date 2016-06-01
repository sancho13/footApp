package com.mycompany.daos;


import com.mycompany.models.Equipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Marseillais on 31/05/2016.
 */

public interface EquipeDao extends  CrudRepository <Equipe,Long> {

        List<Equipe> findById(Long id);

}
