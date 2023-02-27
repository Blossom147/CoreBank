package com.example.core_bank.service.impl;

import com.example.core_bank.entity.AppUser;
import com.example.core_bank.repository.IAppUserRepository;
import com.example.core_bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IAppUserRepository appUserRepository;


    @Override
    public List<AppUser> getAllUser() {
        return appUserRepository.findAll();
    }

    @Override
    public List<AppUser> findUserWithSorting(String field) {
        return appUserRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Page<AppUser> findUserWithPagination(int offset, int pageSize) {
        Page<AppUser> appUsers = appUserRepository.findAll(PageRequest.of(offset,pageSize));
        return appUsers;
    }

    @Override
    public void saveUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void deleteAll() {
        appUserRepository.deleteAll();
    }



    @Override
    public Optional<AppUser> findUserById(Long id) {
        return Optional.empty();
    }




}
