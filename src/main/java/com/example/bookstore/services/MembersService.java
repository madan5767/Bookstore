package com.example.bookstore.services;

import com.example.bookstore.dao.BookRepository;
import com.example.bookstore.dao.MembersRepository;
import com.example.bookstore.dao.ReviewRepository;
import com.example.bookstore.models.Book;
import com.example.bookstore.models.Members;
import com.example.bookstore.models.Review;
import com.example.bookstore.views.IMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MembersService implements IMembersService {
    @Autowired
    MembersRepository memberRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Members> retrieveAllMembers() {
        List<Members> memberList = new ArrayList<>();
        memberRepository.findAll().forEach(memberList::add);
        return memberList;
    }

    @Override
    public Members addMember(Members member) {

        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Members updateMember(Members member) {
        return null;
    }

    @Override
    public Members retrieveMemberById(String id) {
       Optional<Members> mb = memberRepository.findById(Long.parseLong(id));
       return mb.get();
    }

    @Override
    public List<Members> retrieveMemberByRole(String role) {
        List<Members> mb = this.retrieveAllMembers().stream()
               .filter(member -> member.getRole().toString().contains(role))
                .collect(Collectors.toList());
        return mb;
    }


    @Override
    public Book addReviewToBook(Review review, String isbn) {
        Book book = bookRepository.getById(isbn);
        List<Review> reviews = book.getReviews();
        reviews.add(review);
        double totalReviews = reviews.size();
        double sumRating = reviews.stream().mapToInt(Review::getRating).sum();
        book.setAverageRating(sumRating / totalReviews);
        reviewRepository.save(review);
        return book;
    }
}
