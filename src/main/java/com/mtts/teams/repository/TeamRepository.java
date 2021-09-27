package com.mtts.teams.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.mtts.teams.model.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CosmosRepository<Team, String> {

    Iterable<Team> findByName(final String teamName);
}
