package com.uforians.mongo.repository;

import com.uforians.mongo.model.Player;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PlayerRepository extends MongoRepository<Player, String> {
    public List<Player> findByTeam(String team);
}
