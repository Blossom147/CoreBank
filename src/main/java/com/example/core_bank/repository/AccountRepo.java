package com.example.core_bank.repository;

import com.example.core_bank.dto.AccountReponse;
import com.example.core_bank.dto.UserAccountVO;
import com.example.core_bank.dto.PageableRequest;
import com.example.core_bank.dto.AccountSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AccountRepo {
    public List<UserAccountVO> findByUserJoinAccount();


    public List<AccountReponse> findByJoinAccount();

    List<UserAccountVO> findByJoinAccountLimit(PageableRequest pageableRequest);


    List<UserAccountVO> findAccountByName(PageableRequest pageableRequest, String keyword);

    public List<AccountSearch> search(String keyword);

    Long countByJoinAccount();

}
