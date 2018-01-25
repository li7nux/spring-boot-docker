package com.craftcoder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-22 16:05
 * Description:
 */

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String no;

    public Player() {
    }

    public Player(String name, String no) {
        this.name = name;
        this.no = no;
    }

    public Player(Long id, String name, String no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id:\"" + id + "\", " +
                "\"name\"" + name + "\", " +
                "\"no=\"" + no + "\", " +
                "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
