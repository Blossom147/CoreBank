package com.example.core_bank.service;

import com.example.core_bank.entity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<AppUser> getAllUser();

    List<AppUser> findUserWithSorting(String field);

    Page<AppUser> findUserWithPagination(int offset, int pageSize);

    void saveUser(AppUser appUser);

    void deleteUser(Long id);

    void deleteAll();

    Optional<AppUser> findUserById(Long id);

}
