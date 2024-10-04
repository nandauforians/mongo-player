package com.uforians.mongo.service;

import com.uforians.mongo.model.Player;
import com.uforians.mongo.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {

        return playerRepository.save(player);
    }

    public Optional<Player> getPlayerById(String id) {
        return  playerRepository.findById(id);
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepository.findByTeam(teamName);
    }

    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();

        for (int i=0; i < players.size(); i++) {
            System.out.println("Player " + i + "---" + players.get(i));
        }

        return players;
    }

}
