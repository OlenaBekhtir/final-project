package demo.project.twitter.facade.images;


import demo.project.twitter.model.User;
import demo.project.twitter.models.tweet.AttachmentImage;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServicAttachmentImage implements FunctionAttachmentImage {
    private final RepoAttachmentImage repo;

   /* Дальнейший код приведен для примера.
        В данном классе создаются методы сервиса, заявленные в интерфейсе Function,
        в том числе, и с подключением интерфейса Repo (наследник CrudRepository)
        */

// ************************************** EXAMPLE START **************************************

    @Override
    public AttachmentImage saveOne(AttachmentImage img) {
        return repo.save(img);
    }
    @Override
    public Optional<AttachmentImage> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

//    ************************************** EXAMPLE END **************************************

}