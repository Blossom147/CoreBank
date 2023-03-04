package com.example.core_bank.service;

import com.example.core_bank.dto.PageableRequest;
import com.example.core_bank.dto.UserAccountVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAccountService {
    List<UserAccountVO> accountVOList();

    Page<UserAccountVO> accountVOList(PageableRequest pageableRequest,String keyword);
}
