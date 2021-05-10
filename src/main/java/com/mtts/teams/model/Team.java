package com.mtts.teams.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder(setterPrefix="with")
public class Team {

    private Long id;
    private String name;
}
