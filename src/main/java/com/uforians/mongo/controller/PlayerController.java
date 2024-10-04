package com.uforians.mongo.controller;


import com.uforians.mongo.model.Player;
import com.uforians.mongo.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/player")
@Slf4j
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        System.out.println("Player Details: " + player);
        Player savedPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> findPlayerById(@PathVariable String playerId) {
        return playerService.getPlayerById(playerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping("/team/{team}")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable String team) {
        List<Player> players = playerService.getPlayersByTeam(team);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();

        for (int i=0; i < players.size(); i++) {
            System.out.println(i + "---" + players.get(i));
        }


        return ResponseEntity.ok(players);
    }

    @PostMapping("/test")
    public ResponseEntity<Player> testPlayer(@RequestBody Player player) {
        System.out.println("Player Details: " + player);
        return ResponseEntity.ok(player);
    }


}
