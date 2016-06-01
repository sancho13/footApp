package com.mycompany.daos;


import com.mycompany.models.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Marseillais on 31/05/2016.
 */
public interface MatchDao extends CrudRepository<Match,Long>{

    List<Match> findById(Long id);


}
