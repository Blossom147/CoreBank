package com.example.core_bank.service.impl;

import com.example.core_bank.dto.PageableRequest;
import com.example.core_bank.dto.UserAccountVO;
import com.example.core_bank.repository.AccountRepo;
import com.example.core_bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
   @Autowired
   private AccountRepo accountRepo;


   @Override
   public Page<UserAccountVO> accountVOList(PageableRequest pageableRequest, String keyword) {
      Pageable pageable = PageRequest.of(pageableRequest.getPageIndex() , pageableRequest.getPageSize());

      pageableRequest.setOffset(pageable.getOffset());

      List<UserAccountVO> accountVOList = accountRepo.findByJoinAccountLimit(pageableRequest);

      long count  = accountRepo.countByJoinAccount();

      return new PageImpl<>(accountVOList , pageable , count);

   }

   @Override
   public List<UserAccountVO> accountVOList() {
      return null;
   }
}
