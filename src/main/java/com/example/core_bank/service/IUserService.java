package com.example.core_bank.service;

import com.example.core_bank.dto.AccountReponse;
import com.example.core_bank.dto.UserAccountVO;
import com.example.core_bank.entity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<AccountReponse> findByJoinAccount();

    List<AppUser> getAllUser();

    List<AppUser> findUserWithSorting(String field);

    Page<AppUser> findUserWithPagination(int offset, int pageSize);

    Page<AppUser> findUserWithPaginationAndSort(int offset, int pageSize,String sort);

    Page<AppUser> findPaginated(Pageable pageable);

    void saveUser(AppUser appUser);

    void deleteUser(Long id);

    void deleteAll();

    Optional<AppUser> findUserById(Long id);

}
