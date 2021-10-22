//package com.example.bookstore.services;
//
//import com.example.bookstore.dao.MemberRepository;
//import com.example.bookstore.models.Member;
//import com.example.bookstore.views.IMemberService;
//import com.example.bookstore.views.IRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Service
//public class MemberService implements UserDetails,UserDetailsService, IMemberService {
//    private static final long serialVersionUID = 1L;
//
//
//    @Autowired
//    private IRoleService roleService;
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    private BCryptPasswordEncoder bcryptEncoder;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    private static final Logger logger = Logger.getLogger(MemberService.class);
//
//    private Long id;
//
//    private String username;
//
//    private String email;
//
//    @JsonIgnore
//    private String password;
//
//    //implementing IMemberRepository
//    @Override
//    public List<Member> retrieveAllMembers() {
//        List<Member> memberList = new ArrayList<>();
//        memberRepository.findAll().forEach(memberList::add);
//        logger.info("all members");
//        return memberList;
//    }
//
//    @Override
//    public Member addMember(Member m) {
//       //m.setPassword(bcryptEncoder().encode(m.getPassword()));
//        m.setPassword(bcryptEncoder.encode(m.getPassword()));
//
//        return memberRepository.save(m);
//    }
//
//    @Override
//    public void deleteMember(String id) {
//        memberRepository.deleteById(Long.parseLong(id));
//    }
//
//    @Override
//    public Member updateMember(Member u) {
//
//        return null;
//    }
//
//    @Override
//    public Member retrieveMemberById(String id) {
//       Optional<Member> mb = memberRepository.findById(Long.parseLong(id));
//       if(mb.get()==null)
//           logger.error("this "+id+"dose not exist");
//       else
//           logger.info("the member is :" + mb.get());
//       return mb.get();
//    }
//
//    @Override
//    public List<Member> retrieveMemberByRole(String role) {
//        List<Member> mb = this.retrieveAllMembers().stream()
//               .filter(member -> member.getRoles().toString().contains(role))
//                .collect(Collectors.toList());
//        if (mb==null)
//            logger.warn("this member doesn't exist !");
//        else
//            logger.info("retrieved member: "+mb);
//        return mb;
//
//    }
//
//    //implementing UserDetailsInterface
//    public MemberService(){}
//    public MemberService(Long id, String username, String email, String password,
//                           Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static MemberService build(Member user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());
//
//        return new MemberService(
//                user.getId(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        MemberService user = (MemberService) o;
//        return Objects.equals(id, user.id);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s)  {
//        Member user = memberRepository.findByUsername(username);
//               // ( new UsernameNotFoundException("User Not Found with username: " + username));
//
//        return MemberService.build(user);
//    }
//}
