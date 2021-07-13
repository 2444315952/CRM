package com.crm.service;

import com.crm.entity.Clue;

import java.util.List;

public interface ClueService {
    int addClue(Clue record);

    Clue selectByClueKey(Integer clueId);

    int updateByClueKeySelective(Clue record);

    int deleteByClueKey(Clue record);

    List<Clue> selectByClues();

    List<Clue> selectByCustomer();

    List<Clue> selectByContacts();

    List<Clue> selectByMyContacts();

    List<Clue> selectByMyClues();

    List<Clue> selectByMyCustomer();

    int updateByConversion(Clue record);

    int TakeItByEmpName(Clue record);

}
