package com.example.databases.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(@JsonProperty("name") String name) {
}
