package com.example.gallery.backend.controller;

import com.example.gallery.backend.entity.Item;
import com.example.gallery.backend.entity.Member;
import com.example.gallery.backend.repository.MemberRepository;
import com.example.gallery.backend.service.JwtService;
import com.example.gallery.backend.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    JwtService jwtService;

    @PostMapping("/api/account/login")
    public ResponseEntity login(
            @RequestBody Map<String, String> params,
            HttpServletResponse res
    ) {
        Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
        if(member != null){
            int id = member.getId();
            String token = jwtService.getToken("id", id);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            res.addCookie(cookie);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        throw new ResponseStatusException(  HttpStatus.NOT_FOUND);

    }

    @GetMapping("/api/account/check")
    public ResponseEntity check(@CookieValue(value="token", required = false) String token) {
       Claims claims = jwtService.getClaims(token);

       if(claims != null) {
           int id = Integer.parseInt(claims.get("id").toString());
           return new ResponseEntity<>(id, HttpStatus.OK);
       }


        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}