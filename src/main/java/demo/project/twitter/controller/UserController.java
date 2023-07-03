package demo.project.twitter.controller;


import demo.project.twitter.dto.UserDto;
import demo.project.twitter.facade.UserFacade;
import demo.project.twitter.model.User;
import demo.project.twitter.service.GeneralService;
import demo.project.twitter.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"https://twitter-clone-application.vercel.app",
        "http://localhost:5173",
        "https://twitter-clone-application-e8cz8renm-bondoleks.vercel.app"})
@RequestMapping("api/v1/user")
public class UserController {

    private final UserFacade facade;
    private final GeneralService photo;
    private final UserServiceImpl userService;

   @GetMapping("suggestions")
   public ResponseEntity<List<UserDto>> getSuggestions(Principal principal){
       return facade.whoToFollow(principal.getName());
   }

   @GetMapping("profile")
   @PreAuthorize("hasRole('ROLE_USER')")
   public ResponseEntity getProfile (Principal principal){
       return facade.getProfile(principal.getName());
   }

    @GetMapping("getuser/{id}")
    public ResponseEntity<UserDto> getEntity(@PathVariable("id") Long id) {
        return facade.getEntity(id);
    }

    @PostMapping("update")
    public UserDto updateEntity(@RequestParam ("userName") String username,
                                @RequestParam ("firstName") String firstName,
                                @RequestParam ("email") String email,
                                @RequestParam ("location") String location,
                                @RequestParam ("birthDate") String bDate,
                                @RequestParam ("bio") String bio,
                                @RequestParam ("avatar") MultipartFile avFile,
                                @RequestParam ("headimg") MultipartFile headFile) throws Exception {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate = format.parse(bDate);

        return facade.updateUser(username, firstName, email, location, birthDate, bio, photo.getPhotoUrl(avFile), photo.getPhotoUrl(headFile));
    }

    @PostMapping("update/password")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity updateUserPassword(Principal principal, @RequestParam String oldPassword,
                                             @RequestParam String newPassword, @RequestParam String repeatedNewPassword) {
        if(repeatedNewPassword.equals(newPassword)) {
            User user = userService.findByUsername(principal.getName());
            return userService.changePassword(user, oldPassword, newPassword);
        }
        return ResponseEntity.status(400).body("Wrong repeated password");
    }


    @PostMapping("follow/user/{id}")
    public void follow (@RequestBody UserDto dto, @PathVariable("id") Long id) {
       facade.follow(dto.toUser(), facade.getEntity(id).getBody().toUser());
    }

    @PostMapping("unfollow/user/{id}")
    public void unFollow (@RequestBody UserDto dto, @PathVariable("id") Long id) {
        facade.unFollow(dto.toUser(), facade.getEntity(id).getBody().toUser());
    }

    @GetMapping("followers/{id}")
    public ResponseEntity<?> getFollowers(@PathVariable("id") Long id) {
        return facade.getFollowers(id);
    }

    @GetMapping("following/{id}")
    public ResponseEntity<?> getFollowing(@PathVariable("id") Long id) {
        return facade.getFollowing(id);
    }


}
