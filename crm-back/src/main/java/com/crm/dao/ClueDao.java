package com.crm.dao;

import com.crm.entity.Clue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClueDao {
    int addClue(Clue record);

    Clue selectByClueKey(Integer clueId);

    int updateByClueKeySelective(Clue record);

    int updateByClueKey(Clue record);

    List<Clue> selectByClues();

    List<Clue> selectByCustomer();

    List<Clue> selectByMyClues();

    List<Clue> selectByMyCustomer();

    List<Clue> selectByContacts();

    List<Clue> selectByMyContacts();

    int updateByConversion(Clue record);

    int TakeItByEmpName(Clue record);

}