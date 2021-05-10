package com.mtts.teams.controller.v1;

import com.mtts.teams.model.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/teams/v1")
public class TeamController {

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable final String id) {
        return Team.builder().withId(42L).withName("SuperTeam").build();
    }

    @PostMapping("/")
    public Team createTeam(@RequestBody final Team team) {
        return Team.builder().withId(43L).withName("AnotherSuperTeam").build();
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable final Long id, @RequestBody final Team team) {
        return Team.builder().withId(44L).withName("Yay!-Team").build();
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable final Long id) {

    }
}
