package com.uforians.mongo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Players")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    private String id;
    private String playerName;
    private String team;
    private String battingType;
    private String bowlingType;
    private int matches;
    private int runs;
    private int wickets;
    private int catches;


    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", playerName='" + playerName + '\'' +
                ", team='" + team + '\'' +
                ", battingType='" + battingType + '\'' +
                ", bowlingType='" + bowlingType + '\'' +
                ", matches=" + matches +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", catches=" + catches +
                '}';
    }
}
