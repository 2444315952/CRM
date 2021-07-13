package com.crm.service.impl;

import com.crm.dao.ClueDao;
import com.crm.entity.Clue;
import com.crm.service.ClueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {
    @Resource
    private ClueDao clueDao;

    @Transactional
    @Override
    public int addClue(Clue record) {
        return clueDao.addClue(record);
    }

    @Override
    public Clue selectByClueKey(Integer clueId) {
        return clueDao.selectByClueKey(clueId);
    }

    @Transactional
    @Override
    public int updateByClueKeySelective(Clue record) {
        return clueDao.updateByClueKeySelective(record);
    }

    @Transactional
    @Override
    public int deleteByClueKey(Clue record) {
        return clueDao.updateByClueKey(record);
    }

    @Override
    public List<Clue> selectByClues() {
        return clueDao.selectByClues();
    }

    @Override
    public List<Clue> selectByCustomer() {
        return clueDao.selectByCustomer();
    }

    @Override
    public List<Clue> selectByContacts() {
        return clueDao.selectByContacts();
    }

    @Override
    public List<Clue> selectByMyContacts() {
        return clueDao.selectByMyContacts();
    }

    @Override
    public List<Clue> selectByMyClues() {
        return clueDao.selectByMyClues();
    }

    @Override
    public List<Clue> selectByMyCustomer() {
        return clueDao.selectByMyCustomer();
    }

    @Transactional
    @Override
    public int updateByConversion(Clue record) {
        return clueDao.updateByConversion(record);
    }

    @Transactional
    @Override
    public int TakeItByEmpName(Clue record) {
        return clueDao.TakeItByEmpName(record);
    }
}











