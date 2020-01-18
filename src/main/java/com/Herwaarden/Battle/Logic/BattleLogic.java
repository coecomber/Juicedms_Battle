package com.Herwaarden.Battle.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BattleLogic {

    @Autowired
    private RestTemplate restTemplate;

    public float FightMonster(int characterId){
        float timeToKill = 1000;



        return timeToKill;
    }
}
