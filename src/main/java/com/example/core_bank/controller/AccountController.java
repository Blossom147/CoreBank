package com.example.core_bank.controller;

import com.example.core_bank.dto.PageableRequest;
import com.example.core_bank.dto.UserAccountVO;
import com.example.core_bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/accountInfo")
    public String accountInfo(@Valid PageableRequest pageableRequest , Model model) {

        Page<UserAccountVO> userAccountVOPage = accountService.accountVOList(pageableRequest);
        model.addAttribute("pageAccount" , userAccountVOPage);
        int totalPages = userAccountVOPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "listAccount";
    }


}
