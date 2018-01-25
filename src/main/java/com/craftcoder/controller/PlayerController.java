package com.craftcoder.controller;

import com.craftcoder.entity.Player;
import com.craftcoder.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-23 14:24
 * Description:
 */

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository repo;

    @RequestMapping("/players")
    public List<Player> getAllPlayer() {
        return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
