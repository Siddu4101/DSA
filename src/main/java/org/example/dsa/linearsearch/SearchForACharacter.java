package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

import static org.example.dsa.linearsearch.util.SearchUtils.linerSearchForACharacter;

@Slf4j
public class SearchForACharacter {
    public static void main(String[] args) {
        String name = "Siddu";
        char target = 'u';
        log.info("is target character {} is present in the name {} = {}", target, name, linerSearchForACharacter(name, target));
    }


}
