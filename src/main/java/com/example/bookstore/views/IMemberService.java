//package com.example.bookstore.views;
//
//
//import com.example.bookstore.models.Book;
//import com.example.bookstore.models.Member;
//import com.example.bookstore.models.Review;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//import java.util.List;
//
//public interface IMemberService {
//    List<Member> retrieveAllMembers();
//    Member addMember(Member m);
//    void deleteMember(String id);
//    Member updateMember(Member u);
//    Member retrieveMemberById(String id);
//    List<Member> retrieveMemberByRole(String role);
//
//    Collection<? extends GrantedAuthority> getAuthorities();
//    Book addReviewToBook(Review review, String isbn);
//}
