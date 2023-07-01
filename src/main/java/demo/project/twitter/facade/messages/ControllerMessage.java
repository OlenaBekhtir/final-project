package demo.project.twitter.facade.messages;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

@RequestMapping("/api/v1/messages")



@CrossOrigin(origins = {"https://twitter-clone-application.vercel.app",
        "http://localhost:5173",
        "https://twitter-clone-application-e8cz8renm-bondoleks.vercel.app"})
public class ControllerMessage {
    private final FacadeMessage facade;


    @GetMapping("get/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable("id") Long id) {
        return facade.getEntity(id);
    }

    @PostMapping("save")
    public DtoMessage saveMessage(@RequestBody DtoMessage dto) {
        return facade.saveEntity(dto);
    }

    @PostMapping("delete/{id}")
    public DtoMessage saveMessage(@PathVariable("id") Long id) {
        return facade.deleteById(id);
    }

}
