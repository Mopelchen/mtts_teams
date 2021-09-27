package com.mtts.teams.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

@Container(containerName = "team", ru = "400")
public class Team {

    private final String id;

    @PartitionKey
    private final String name;

    @JsonCreator
    public Team(
            @JsonProperty final String id,
            @JsonProperty final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Team)) {
            return false;
        }

        Team team = (Team) o;
        return Objects.equals(id, team.id)
                && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    public static class TeamBuilder {

        private String id;
        private String name;

        public TeamBuilder withId(final String id) {
            this.id = id;
            return this;
        }

        public TeamBuilder withName(final String name) {
            this.name = name;
            return this;
        }
        public Team build() {
            return new Team(id, name);
        }
    }

}
