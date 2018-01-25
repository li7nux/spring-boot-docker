package com.craftcoder.repository;

import com.craftcoder.entity.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-23 14:20
 * Description:
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
