package com.mtts.teams.controller.v1;

import com.mtts.teams.model.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.mtts.teams.model.Team.*;

@Slf4j
@RestController("/teams/v1")
public class TeamController {

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable final Long id) {
        return builder().withId("42").withName("SuperTeam").build();
    }

    @PostMapping("/")
    public Team createTeam(@RequestBody final Team team) {
        return builder().withId("43").withName("AnotherSuperTeam").build();
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable final Long id, @RequestBody final Team team) {
        return builder().withId("44").withName("Yay!-Team").build();
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable final Long id) {

    }
}
