package com.example.bookstore.controllers;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.Members;
import com.example.bookstore.models.Review;
import com.example.bookstore.views.IBookService;
import com.example.bookstore.views.IMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/member")
public class MembersController {
    @Autowired
    IMembersService membersService;

    @GetMapping("/allMembers")
    public ResponseEntity<List<Members>> getAllMembers(){
        List<Members> memberList = membersService.retrieveAllMembers();
        if (memberList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

//    @PostMapping("/review")
//    public ResponseEntity<Book> addReviewToPerfume(@Valid @RequestBody Review review,
//                                                   BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        } else {
//            Book book = IBookService.addReviewToBook(review, review.getId());
//            return ResponseEntity.ok(book);
//        }
//    }

}
