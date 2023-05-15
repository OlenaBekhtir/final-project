package demo.project.twitter.facade.masseges;

import demo.project.twitter.model.User;
import demo.project.twitter.models.chat.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoMessage extends CrudRepository<Message, Long> { }