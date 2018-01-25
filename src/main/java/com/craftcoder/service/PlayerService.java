package com.craftcoder.service;

import com.craftcoder.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-23 14:22
 * Description:
 */

@Service
public class PlayerService {

    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager em;

    public Player getPlayerByName(String name) {
        String sqlTemplate = "select * from Player where name = ?";
        Query query = em.createNativeQuery(sqlTemplate);
        query.setParameter(1, name);
        List<Object[]> rows = query.getResultList();
        List<Player> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new Player(new Long((Integer) row[0]), (String) row[1], (String) row[2]));
        }
        result.forEach(player -> logger.info("get result : {}", player.toString()));
        return result.size() > 0 ? result.get(0) : new Player();
    }


}
