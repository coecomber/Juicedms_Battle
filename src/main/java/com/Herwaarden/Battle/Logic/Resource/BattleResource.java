package com.Herwaarden.Battle.Logic.Resource;

import com.Herwaarden.Battle.Logic.BattleLogic;
import com.Herwaarden.Battle.Model.Character.CharacterModel;
import com.Herwaarden.Battle.Model.Monster.MonsterModel;
import com.Herwaarden.Battle.Model.Party.PartyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class BattleResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/public/battle/get/{characterId}")
    public float getBattleTime(@PathVariable("characterId") int characterId){
        float timeToKill = 1000;
        BattleLogic battleLogic = new BattleLogic();

        //Get the party of the character
        PartyModel partyModel = restTemplate.getForObject("http://party-service/api/public/party/get/" + characterId, PartyModel.class);

        //Calculate power of party
        int power;
        CharacterModel characterOne = restTemplate.getForObject("http://character-service/api/public/character/get/" + characterId, CharacterModel.class);

        if(partyModel != null){
            CharacterModel characterTwo = restTemplate.getForObject("http://character-service/api/public/character/get/" + partyModel.getCharacterIdTwo(), CharacterModel.class);
            power = characterOne.getPower() + characterTwo.getPower();
        } else{
            power = characterOne.getPower();
        }

        //Gets a random monster to fight with the correct floor
        MonsterModel monsterModel = restTemplate.getForObject("http://monster-service/api/public/monster/get/" + characterOne.getFloor(), MonsterModel.class);

        //Respond with a time it takes to kill the monster
        timeToKill = monsterModel.getHealth() / power;

        System.out.println("Time to kill monster: " + timeToKill);

        if (timeToKill < 10){
            //Go 1 floor higher
            characterOne.setFloor(characterOne.getFloor() + 1);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity entity = new HttpEntity(characterOne, headers);

            restTemplate.exchange("http://character-service/api/public/updateCharacter", HttpMethod.POST, entity, CharacterModel.class);
        }

        return battleLogic.FightMonster(characterId);
    }
}
