package com.UST.UserBook.controller;

import com.UST.UserBook.Exception.IDNotFoundException;
import com.UST.UserBook.entity.Book;
import com.UST.UserBook.entity.User;
import com.UST.UserBook.repository.BookRepository;
import com.UST.UserBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserBookController{
    @Autowired
    private UserRepository userrepo;
    @Autowired
    private BookRepository bookrepo;

    @PostMapping("/adduser")
    public ResponseEntity<User>createUser(@RequestBody User user){
        return ResponseEntity.ok().body(userrepo.save(user));
    }
    @PostMapping("/addbook")
    public ResponseEntity<Book>createBook(@RequestBody Book book){
        return ResponseEntity.ok().body(bookrepo.save(book));
    }
    @GetMapping("/getuser")
    public ResponseEntity <List<User>>getAllusers(){
        return ResponseEntity.ok().body(userrepo.findAll());
    }

    @GetMapping("getuser/{id}")
    public ResponseEntity<User>getByUserId(@PathVariable Integer id) throws IDNotFoundException {
        Optional<User>u=userrepo.findById(id);
            if(u.isEmpty()){
                throw new IDNotFoundException("user with id not found");
//                return ResponseEntity.noContent().build(); (if exception class is not present)
            }
            else{
                return  ResponseEntity.ok().body(userrepo.findById(id).orElse(null));
            }

    }
    @GetMapping("/getbook")
    public ResponseEntity<List<Book>>getAllbook(){

        return ResponseEntity.ok().body(bookrepo.findAll());
    }
    @GetMapping("/getbook/{id}")
    public ResponseEntity<Book>getByBookId(@PathVariable Integer id){
        return ResponseEntity.ok().body(bookrepo.findById(id).orElse(null));
    }
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Integer id){
          userrepo.deleteById(id);
          return ResponseEntity.ok().body("deleted userid");
    }
    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<String>deleteBybookid(@PathVariable Integer id){
        bookrepo.deleteById(id);
        return ResponseEntity.ok().body("deleted bookid");
    }
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User>updateByuserId(@RequestBody User user, @PathVariable Integer id) {
        User old = null;
        Optional<User> user1 = userrepo.findById(id);
//          if (user1.isPresent()) {
        old = user1.get();
        old.setUserid(id);
        old.setUserName(user.getUserName());
        return ResponseEntity.ok().body(userrepo.save(old));

//     else{
//           return ResponseEntity.notFound().build();
//       }
    }
  @PutMapping("/updatebook/{id}")
    public ResponseEntity<Book>updateBybookId(@RequestBody Book book,@PathVariable Integer id){
        Book old= null;
        Optional<Book>book1=bookrepo.findById(id);

            old = book1.get();
            old.setBookid(id);
            old.setBookName(book.getBookName());
            return ResponseEntity.ok().body(bookrepo.save(old));
        }


 }






