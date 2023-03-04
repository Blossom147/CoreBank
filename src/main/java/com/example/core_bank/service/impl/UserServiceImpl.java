package com.example.core_bank.service.impl;

import com.example.core_bank.dto.AccountReponse;
import com.example.core_bank.dto.UserAccountVO;
import com.example.core_bank.entity.AppUser;
import com.example.core_bank.repository.AccountRepo;
import com.example.core_bank.repository.IAppUserRepository;
import com.example.core_bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<AccountReponse> findByJoinAccount() {
        return accountRepo.findByJoinAccount();
    }

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
        Page<AppUser> appUsers = appUserRepository.findAll(PageRequest.of(0,10));
        return appUsers;
    }

    @Override
    public Page<AppUser> findUserWithPaginationAndSort(int offset, int pageSize, String sort) {
        Page<AppUser> appUsers = appUserRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(sort)));
       return appUsers;
    }
    public Page<AppUser> findPaginated(Pageable pageable) {

        List<AppUser> appUsers = appUserRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<AppUser> list;

        if (appUsers.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, appUsers.size());
            list = appUsers.subList(startItem, toIndex);
        }

        Page<AppUser> userPage = new PageImpl<AppUser>(list, PageRequest.of(currentPage, pageSize), appUsers.size());

        return userPage;
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
